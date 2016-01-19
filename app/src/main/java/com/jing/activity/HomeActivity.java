package com.jing.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jing.adapter.DrawAdapter;
import com.jing.fragment.Find_Fragment;
import com.jing.fragment.Fragment_News;
import com.jing.fragment.Fragment_Tweet;
import com.jing.fragment.Mine_Fragment;
import com.jing.model.DrawerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends ActionBarActivity implements View.OnClickListener {
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private DrawerLayout home_drawer;
    private FrameLayout home_fragment;
    private ListView drawer_lv;
    private RelativeLayout home_light;
    private RelativeLayout home_set;

    private List<DrawerModel> list;
    String[] name = {"技术问答", "开源软件", "博客区", "Git客户端"};
    int[] img = {R.drawable.drawer_menu_icon_quest_nor, R.drawable.drawer_menu_icon_opensoft_nor,
            R.drawable.drawer_menu_icon_blog_nor, R.drawable.drawer_menu_icon_gitapp_nor};
    private TextView tv_news;
    private TextView tv_find;
    private TextView tv_me;
    private TextView tv_tweet;
    private ImageView img_quick;
    public FragmentManager fm;
    private  TextView tv_show;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        fm = getSupportFragmentManager();
        Fragment_News news=new Fragment_News();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.home_fragment,news).commit();
        toolbar.setTitle("开源中国");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));//设置标题颜色

        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, home_drawer, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };
        mDrawerToggle.syncState();
        home_drawer.setDrawerListener(mDrawerToggle);


    }

    /**
     * 初始化控件
     */
    private void initView() {
        list = new ArrayList<DrawerModel>();
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        home_drawer = (DrawerLayout) findViewById(R.id.home_drawer);
        home_fragment = (FrameLayout) findViewById(R.id.home_fragment);
        drawer_lv = (ListView) findViewById(R.id.home_drawer_lv);
        home_light = (RelativeLayout) findViewById(R.id.home_rl_night);
        home_set = (RelativeLayout) findViewById(R.id.home_rl_set);

        tv_news = (TextView) findViewById(R.id.home_tv_news);//综合
        tv_find = (TextView) findViewById(R.id.home_tv_find);//发现
        tv_me = (TextView) findViewById(R.id.home_tv_me);//我
        tv_tweet = (TextView) findViewById(R.id.home_tv_tweet);//动弹
        img_quick = (ImageView) findViewById(R.id.home_tv_quick);//快速
//        Drawable drawable1 = getResources().getDrawable(R.drawable.widget_bar_news_nor);
//        drawable1.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
//        tv_news.setCompoundDrawables(null,drawable1, null, null);//只放左边
//
//        Drawable drawable2 = getResources().getDrawable(R.drawable.widget_bar_explore_nor);
//        drawable2.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
//        tv_find.setCompoundDrawables(null,drawable2,  null, null);//只放左边
//
//        Drawable drawable3 = getResources().getDrawable(R.drawable.widget_bar_tweet_nor);
//        drawable3.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
//        tv_tweet.setCompoundDrawables(null,drawable3,  null, null);//只放左边
//
//        Drawable drawable4 = getResources().getDrawable(R.drawable.widget_bar_me_nor);
//        drawable4.setBounds(0, 0, 50, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
//        tv_me.setCompoundDrawables(null,drawable4,  null, null);//只放左边

        tv_news.setOnClickListener(this);
        tv_tweet.setOnClickListener(this);
        tv_find.setOnClickListener(this);
        tv_me.setOnClickListener(this);
        img_quick.setOnClickListener(this);
        home_light.setOnClickListener(this);
        home_set.setOnClickListener(this);

        tv_show = tv_news;
        tv_show.setSelected(true);
        tv_show.setTextColor(getResources().getColor(R.color.Indigo_colorPrimary));


        for (int i = 0; i < name.length; i++) {
            DrawerModel model = new DrawerModel();
            model.setName(name[i]);
            model.setImg(img[i]);
            list.add(model);
        }

        DrawAdapter adapter = new DrawAdapter(list, this);
        drawer_lv.setAdapter(adapter);
        drawer_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(HomeActivity.this, QuestionActivity.class);
                        intent.putExtra("name", list.get(position).getName());
                        startActivity(intent);

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;


                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                    msg += "Click edit";
                    break;

            }

            if (!msg.equals("")) {
                Toast.makeText(HomeActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    /**
     * 给相关控件加监听
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fm.beginTransaction();
    switch (v.getId()){
        case R.id.home_tv_news://综合
            tv_show.setSelected(false);
            tv_show = tv_news;
            tv_show.setSelected(true);
            tv_show.setTextColor(getResources().getColor(R.color.Indigo_colorPrimary));
            Fragment_News news=new Fragment_News();
            ft.replace(R.id.home_fragment,news).commit();

            break;
        case R.id.home_tv_find://发现
            tv_show.setSelected(false);
            tv_show.setTextColor(Color.BLACK);
            tv_show = tv_find;
            tv_show.setSelected(true);
            tv_show.setTextColor(getResources().getColor(R.color.Indigo_colorPrimary));

            Find_Fragment find=new Find_Fragment();
            ft.replace(R.id.home_fragment,find).commit();
    Toast.makeText(HomeActivity.this,"发现",Toast.LENGTH_LONG).show();
            break;
        case R.id.home_tv_me://我
            tv_show.setSelected(false);
            tv_show.setTextColor(Color.BLACK);
            tv_show = tv_me;
            tv_show.setSelected(true);
            tv_show.setTextColor(getResources().getColor(R.color.Indigo_colorPrimary));
            Toast.makeText(HomeActivity.this,"我",Toast.LENGTH_LONG).show();
            Mine_Fragment mine=new Mine_Fragment();
            ft.replace(R.id.home_fragment,mine).commit();

            break;
        case R.id.home_tv_tweet://动弹
            tv_show.setSelected(false);
            tv_show.setTextColor(Color.BLACK);
            tv_show = tv_tweet;
            tv_show.setSelected(true);
            tv_show.setTextColor(getResources().getColor(R.color.Indigo_colorPrimary));
            Fragment_Tweet tweet=new Fragment_Tweet();
            ft.replace(R.id.home_fragment,tweet).commit();

            Toast.makeText(HomeActivity.this, "动弹", Toast.LENGTH_LONG).show();
            break;
        case R.id.home_tv_quick://快速
            getPop();

            break;

        case R.id.home_rl_set://设置


            break;
        case R.id.home_rl_night://日夜间


            break;

        case R.id.quick_note://便签
        Intent intent=new Intent(HomeActivity.this,NoteActivit.class);
            startActivity(intent);
            pop.dismiss();
            break;
    }
    }

    /**
     * 弹出泡泡窗口
     */
    private  void getPop(){
        View view = View.inflate(HomeActivity.this, R.layout.quick_dialog,null);

        TextView quick_album = (TextView) view.findViewById(R.id.quick_album);
        Drawable drawable1 = getResources().getDrawable(R.drawable.quick_option_album_nor);
        drawable1.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_album.setCompoundDrawables(null,drawable1, null, null);//只放左边

        TextView quick_note = (TextView) view.findViewById(R.id.quick_note);
        Drawable drawable2 = getResources().getDrawable(R.drawable.quick_option_album_nor);
        drawable2.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_note.setCompoundDrawables(null,drawable2, null, null);//只放左边

        TextView quick_photo = (TextView) view.findViewById(R.id.quick_photo);
        Drawable drawable3 = getResources().getDrawable(R.drawable.quick_option_photo_nor);
        drawable3.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_photo.setCompoundDrawables(null,drawable3, null, null);//只放左边

        TextView quick_scan = (TextView) view.findViewById(R.id.quick_scan);
        Drawable drawable4 = getResources().getDrawable(R.drawable.quick_option_scan_nor);
        drawable4.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_scan.setCompoundDrawables(null,drawable4, null, null);//只放左边

        TextView quick_text = (TextView) view.findViewById(R.id.quick_text);
        Drawable drawable5 = getResources().getDrawable(R.drawable.quick_option_text_nor);
        drawable5.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_text.setCompoundDrawables(null,drawable5, null, null);//只放左边

        TextView quick_voice = (TextView) view.findViewById(R.id.quick_voice);
        Drawable drawable6 = getResources().getDrawable(R.drawable.quick_option_voice_nor);
        drawable6.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        quick_voice.setCompoundDrawables(null, drawable6, null, null);//只放左边

        quick_album.setOnClickListener(this);
        quick_note.setOnClickListener(this);
        quick_photo.setOnClickListener(this);
        quick_scan.setOnClickListener(this);
        quick_text.setOnClickListener(this);
        quick_voice.setOnClickListener(this);
        pop = new PopupWindow();
        pop.setContentView(view);
        //设置SelectPicPopupWindow弹出窗体的宽
        pop.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        pop.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        //点击其它消失
        pop.setBackgroundDrawable(new BitmapDrawable());
        pop.setAnimationStyle(R.style.dialogAnim);
        pop.showAtLocation(home_fragment, Gravity.BOTTOM, 0, 0);

        //pop显示变暗
        if(pop.isShowing()){
            WindowManager.LayoutParams params=HomeActivity.this.getWindow().getAttributes();
            params.alpha=0.8f;
            HomeActivity.this.getWindow().setAttributes(params);
        }
        //pop消失变回来
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }
}
