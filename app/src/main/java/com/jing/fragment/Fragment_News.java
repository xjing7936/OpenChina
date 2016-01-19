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
 * Created by jing on 2016/1/7.
 */
public class Fragment_News extends Fragment {

    private View view;
    private PagerSlidingTabStrip news_tab;
    private ViewPager news_pager;
    private DisplayMetrics dm;
    private  Fragment_News_next n1;
    private  Fragment_News_next n2;
    private  Fragment_Bolg_next n3;
    private  Fragment_Bolg_next n4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, null);
        setOverflowShowingAlways();
        dm = getResources().getDisplayMetrics();
        initView();
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView(){
        news_tab = (PagerSlidingTabStrip) view.findViewById(R.id.news_tab);
        news_pager = (ViewPager) view.findViewById(R.id.news_viewpager);
        MyPagerAdapter adapter=new MyPagerAdapter(getActivity().getSupportFragmentManager());
        news_pager.setAdapter(adapter);

        news_tab.setViewPager(news_pager);
//        n1=new Fragment_News_next();
//        FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
//        Bundle bundle1=new Bundle();
//        bundle1.putString("postion","1");
//        n1.setArguments(bundle1);
//        ft1.show(n1).commit();
        setTabsValue();

    }
    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        news_tab.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        news_tab.setDividerColor(Color.GRAY);
        // 设置Tab底部线的高度
        news_tab.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        news_tab.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        news_tab.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        news_tab.setIndicatorColor(Color.parseColor("#40AA52"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        news_tab.setSelectedTextColor(Color.parseColor("#40AA52"));
        // 取消点击Tab时的背景色
        news_tab.setTabBackground(0);
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
    /**
     *
     * 给Fragment添加适配器
     */
public  class MyPagerAdapter extends  FragmentPagerAdapter{

        private final String[] titles = { "资讯", "热点","博客", "推荐"};
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
                    if (n1==null){
                        n1=new Fragment_News_next();

                    }
                    FragmentTransaction ft1 = getActivity().getSupportFragmentManager().beginTransaction();
                     Bundle bundle1=new Bundle();
                    bundle1.putString("postion","1");
                    n1.setArguments(bundle1);
                    ft1.show(n1).commit();
                    return  n1;
                case  1:
                    if (n2==null){
                        n2=new Fragment_News_next();

                    }
                    FragmentTransaction ft2 = getActivity().getSupportFragmentManager().beginTransaction();
                    Bundle bundle2=new Bundle();
                    bundle2.putString("postion","4");
                    n2.setArguments(bundle2);
                    ft2.show(n2).commit();
                    return  n2;
                case  2:
                    if (n3==null){
                        n3=new Fragment_Bolg_next();

                    }
                    FragmentTransaction ft3 = getActivity().getSupportFragmentManager().beginTransaction();
                    Bundle bundle3=new Bundle();
                    bundle3.putString("postion","lates");
                    n3.setArguments(bundle3);
                    ft3.show(n3).commit();
                    return  n3;
                case  3:
                    if (n4==null){
                        n4=new Fragment_Bolg_next();

                    }
                    FragmentTransaction ft4 = getActivity().getSupportFragmentManager().beginTransaction();
                    Bundle bundle4=new Bundle();
                    bundle4.putString("postion","recommend");
                    n4.setArguments(bundle4);
                    ft4.show(n4).commit();
                    return  n4;

            }
            return null;
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
//            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
//                try {
//                    Method m = menu.getClass().getDeclaredMethod(
//                            "setOptionalIconsVisible", Boolean.TYPE);
//                    m.setAccessible(true);
//                    m.invoke(menu, true);
//                } catch (Exception e) {
//                }
//            }
//        }
//        return onMenuOpened(featureId, menu);
//    }

}
