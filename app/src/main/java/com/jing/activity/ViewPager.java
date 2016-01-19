package com.jing.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jing.model.Model;
import com.jing.utils.OkHttpClientManager;
import com.lidroid.xutils.BitmapUtils;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 网络加载图片用动态添加viewpager
 */

public class ViewPager extends AppCompatActivity {
    private android.support.v4.view.ViewPager viewpager;
    private List<String> list_img;
    private List<ImageView> imageViewList;
    private MyHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewpager = (android.support.v4.view.ViewPager) findViewById(R.id.viewpager);
        imageViewList = new ArrayList<ImageView>();
        handler = new MyHandler();
        list_img = new ArrayList<String>();
         new Thread(){
             @Override
             public void run() {
                 try {
                     Response response = OkHttpClientManager.getAsyn("http://103.27.6.3:909/api/banner.action?method=findRotatePic");

                     String string = response.body().string();
                     Model model = new Gson().fromJson(string, Model.class);
                     List<Model.DataEntity> data = model.getData();
                     for (Model.DataEntity img: data)
                     {
                         if (img.getType().equals("3")){
                             list_img.add(img.getImagePath());
                         }
                     }
                     Message message = handler.obtainMessage(1, list_img);
                     handler.sendMessage(message);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }.start();
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
           if (msg.what==1){
               ArrayList<String> img_list= (ArrayList<String>) msg.obj;
               Toast.makeText(ViewPager.this,img_list.toString(),Toast.LENGTH_LONG).show();
               for (int i=0;i<img_list.size();i++){
                   ImageView im=new ImageView(ViewPager.this);
                   imageViewList.add(im);
                   BitmapUtils bitmapUtils=new BitmapUtils(ViewPager.this);
                   bitmapUtils.display(im,img_list.get(i));
                   Toast.makeText(ViewPager.this,"学习 ",Toast.LENGTH_LONG).show();
               }
               MyPager adapter=new MyPager();
               viewpager.setAdapter(adapter);
           }
        }
    }
class MyPager extends PagerAdapter{

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = imageViewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(imageViewList.get(position));
    }
}
}
