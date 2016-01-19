package com.jing.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jing.activity.R;
import com.jing.adapter.TweetAdapter;
import com.jing.model.TweetModel;
import com.jing.utils.OkHttpClientManager;
import com.jing.utils.Tweet_SaxHandler;
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
 * 最新动弹
 * Created by jing on 2016/1/8.
 */
public class Fragment_Tweet_new extends Fragment {
    private List<TweetModel> list;
    private View view;
    private ListView news_lv;
    private String postion;
    private MyHandler handler;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_question, null);
        initView();
        return view;
    }

    private void initView(){
        news_lv = (ListView) view.findViewById(R.id.fg_question_lv);
        Bundle bundle = getArguments();
        postion = bundle.getString("postion");
        handler = new MyHandler();
        if(list==null){
            list=new ArrayList<TweetModel>();
        }
        getHttp();
    }

    /**
     * 网络请求
     * @param
     */
    private void getHttp(){
        new Thread(){
            @Override
            public void run() {
                String url="http://www.oschina.net/action/api/news_list?catalog="+postion+"&pageIndex=1&pageSize=20";
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
                        Tweet_SaxHandler handle=new Tweet_SaxHandler(list);
                        //将实例化对象 传给reader
                        reader.setContentHandler(handle);
                        //调用parse解析
                        reader.parse(is);
                        List<TweetModel> list = handle.getList();
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
    class  MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                List<TweetModel> list= (List<TweetModel>) msg.obj;
                if (list!=null) {
                    TweetAdapter adapter = new TweetAdapter(getActivity(), list);
                    news_lv.setAdapter(adapter);
                }
            }
        }
    }

////
//    private void getData(){
//        String url="http://pic5.duowan.com/ldj/1105/168654653599/168655230986.jpg";
//
//        FormEncodingBuilder builder = new FormEncodingBuilder();
//        builder.add("username","张鸿洋");
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(builder.build())
//                .build();
//        OkHttpClient mOkHttpClient=new OkHttpClient();
//        mOkHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//
//            }
//        });
//    }
}
