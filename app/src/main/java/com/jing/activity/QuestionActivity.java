package com.jing.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.fragment.Fragment_Question;
import com.jing.view.PagerSlidingTabStrip;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 侧划跳转的技术问答页面
 *
 */
public class QuestionActivity extends FragmentActivity {

    private PagerSlidingTabStrip qurstion_tab;
    private ViewPager question_viewPager;
    private DisplayMetrics dm;
    private  Fragment_Question f1;
    private  Fragment_Question f2;
    private  Fragment_Question f3;
    private  Fragment_Question f4;
    private  Fragment_Question f5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setOverflowShowingAlways();
        dm = getResources().getDisplayMetrics();
        initView();
        initTop();
    }

    /**
     * 设置头部
     */
    private void initTop(){
        ImageView top_img = (ImageView) findViewById(R.id.top_img);
        TextView top_tv = (TextView) findViewById(R.id.top_tv);
        top_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        top_tv.setText(name);
    }

    /**
     * 初始化控件
     */
    private  void  initView(){

        qurstion_tab = (PagerSlidingTabStrip) findViewById(R.id.question_tab);
        question_viewPager = (ViewPager) findViewById(R.id.question_viewpager);
        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager());
        question_viewPager.setAdapter(adapter);
        qurstion_tab.setViewPager(question_viewPager);

        setTabsValue();
    }
    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        qurstion_tab.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        qurstion_tab.setDividerColor(Color.GRAY);
        // 设置Tab底部线的高度
        qurstion_tab.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        qurstion_tab.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        qurstion_tab.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        qurstion_tab.setIndicatorColor(Color.parseColor("#40AA52"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        qurstion_tab.setSelectedTextColor(Color.parseColor("#40AA52"));
        // 取消点击Tab时的背景色
        qurstion_tab.setTabBackground(0);
    }

    private void setOverflowShowingAlways() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
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
    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        private final String[] titles = { "提问", "分享","综合", "职业"," 站务" };

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (f1 == null) {
                        f1 = new Fragment_Question();

                    }
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle=new Bundle();
                    bundle.putInt("postion", 1);
                    f1.setArguments(bundle);
                    ft1.show(f1).commit();

                    return f1;
                case 1:
                    if (f2 == null) {
                        f2 = new Fragment_Question();
                    }
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle2=new Bundle();
                    bundle2.putInt("postion",2);
                    f2.setArguments(bundle2);
                    ft2.show(f2).commit();
                    return f2;

                case 2:
                    if (f3 == null) {
                        f3 = new Fragment_Question();
                    }

                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle3=new Bundle();
                    bundle3.putInt("postion",3);
                    f3.setArguments(bundle3);
                    ft3.show(f3).commit();
                    return f3;
                case 3:
                    if (f4 == null) {
                        f4 = new Fragment_Question();
                    }
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle4=new Bundle();
                    bundle4.putInt("postion",4);
                    f4.setArguments(bundle4);
                    ft4.show(f4).commit();
                    return f4;
                case 4:
                    if (f5 == null) {
                        f5 = new Fragment_Question();
                    }
                    FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
                    Bundle bundle5=new Bundle();
                    bundle5.putInt("postion",5);
                    f5.setArguments(bundle5);
                    ft5.show(f5).commit();
                    return f5;
                default:
                    return null;
            }
        }

    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod(
                            "setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
}
