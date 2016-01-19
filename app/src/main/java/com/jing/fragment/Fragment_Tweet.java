package com.jing.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

import com.jing.activity.R;
import com.jing.view.PagerSlidingTabStrip;

import java.lang.reflect.Field;

/**
 * 动弹
 * Created by jing on 2016/1/8.
 */
public class Fragment_Tweet extends Fragment{

    private View view;
    private PagerSlidingTabStrip tweet_tab;
    private ViewPager tweet_pager;
    private DisplayMetrics dm;
    private Fragment_Tweet_new news;
    private Fragment_Tweet_new news1;
    private Fragment_Tweet_new news2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_news,null);
        setOverflowShowingAlways();
        dm=getResources().getDisplayMetrics();
        initView();
        return view;
    }

    /**
     * 初始化动画
     */
    private void initView(){
        tweet_tab = (PagerSlidingTabStrip) view.findViewById(R.id.news_tab);
        tweet_pager = (ViewPager) view.findViewById(R.id.news_viewpager);
        MyPagerAdapter adapter=new MyPagerAdapter(getActivity().getSupportFragmentManager());
        tweet_pager.setAdapter(adapter);
        tweet_tab.setViewPager(tweet_pager);
        news=new Fragment_Tweet_new();
        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
        Bundle bundle1=new Bundle();
        bundle1.putString("postion","0");
        news.setArguments(bundle1);
        ft1.show(news).commit();
        setTabsValue();
    }
    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tweet_tab.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        tweet_tab.setDividerColor(Color.GRAY);
        // 设置Tab底部线的高度
        tweet_tab.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        tweet_tab.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        tweet_tab.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        tweet_tab.setIndicatorColor(Color.parseColor("#40AA52"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        tweet_tab.setSelectedTextColor(Color.parseColor("#40AA52"));
        // 取消点击Tab时的背景色
        tweet_tab.setTabBackground(0);
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(getActivity());
            Field menuKeyField = ViewConfiguration.class
                    .getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(config, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public class MyPagerAdapter extends FragmentPagerAdapter{
       private final String[] titles = { "最新动弹", "热门动弹","我的动弹"};
       public MyPagerAdapter(FragmentManager fm) {
           super(fm);
       }
       @Override
       public CharSequence getPageTitle(int position) {
           return titles[position];
       }
       @Override
       public Fragment getItem(int position) {
           switch (position){
               case 0:
                   if (news==null){
                       news=new Fragment_Tweet_new();

                   }
                   FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                   Bundle bundle1=new Bundle();
                   bundle1.putString("postion","0");
                   news.setArguments(bundle1);
                   ft1.show(news).commit();
                   return  news;
               case 1:
                   if (news1==null){
                       news1=new Fragment_Tweet_new();

                   }
                   FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
                   Bundle bundle2=new Bundle();
                   bundle2.putString("postion","0");
                   news1.setArguments(bundle2);
                   ft2.show(news1).commit();
                   return  news1;
               case 2:
                   if (news2==null){
                       news2=new Fragment_Tweet_new();

                   }
                   FragmentTransaction ft3 = getActivity().getSupportFragmentManager().beginTransaction();
                   Bundle bundle3=new Bundle();
                   bundle3.putString("postion","0");
                   news2.setArguments(bundle3);
                   ft3.show(news2).commit();
                   return  news2;
           }
           return null;
       }

       @Override
       public int getCount() {
           return titles.length;
       }
   }
}
