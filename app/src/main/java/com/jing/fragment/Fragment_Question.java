package com.jing.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jing.activity.R;
import com.jing.adapter.QuestionAdapter;
import com.jing.model.NewsModel;
import com.jing.utils.OkHttpClientManager;
import com.jing.utils.Question_SaxHandler;
import com.squareup.okhttp.Response;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by jing on 2016/1/6.
 */
public class Fragment_Question extends Fragment {

    private View view;
    private List<NewsModel> list;
    private MyHandler handler;
    private ListView question_lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_question, null);
        initView();
        return view;
    }
    private  void initView(){
        question_lv = (ListView) view.findViewById(R.id.fg_question_lv);
        handler = new MyHandler();
        if(list==null){
            list=new ArrayList<NewsModel>();
        }


            new Thread(){
                @Override
                public void run() {
                    Bundle bundle = getArguments();
                    int postion = bundle.getInt("postion");
                    Log.i("TAG",postion+"尖尖砂砂砂在");
                    String url="http://www.oschina.net/action/api/post_list?catalog="+postion+"&pageIndex=1&pageSize=20";
                    try {

                        Response response = OkHttpClientManager.getAsyn(url);
                        InputStream inputStream = response.body().byteStream();
                        //通过获取到的InputStream来得到InputSource实例
                        InputSource is=new InputSource(inputStream);
                        //得到SAX解析工厂
                        SAXParserFactory factory=SAXParserFactory.newInstance();

                        try {
                            //通过工厂得到解析器
                            SAXParser parser = factory.newSAXParser();
                            //通过SAXParser得到XMLReader的实例
                            XMLReader reader = parser.getXMLReader();
                            //实例化自定义MySaxHandle类
                           Question_SaxHandler handle=new Question_SaxHandler(list);
                            //将实例化对象 传给reader
                            reader.setContentHandler(handle);
                            //调用parse解析
                            reader.parse(is);
                            List<NewsModel> list = handle.getList();
                            Message message = handler.obtainMessage(1, list);
                            handler.sendMessage(message);
                        } catch (ParserConfigurationException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (SAXException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

    }
    class  MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                List<NewsModel> list= (List<NewsModel>) msg.obj;
                QuestionAdapter adapter=new QuestionAdapter(getActivity(),list);
                question_lv.setAdapter(adapter);
            }
        }
    }
}
