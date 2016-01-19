package com.jing.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jing.activity.R;
import com.jing.adapter.FindAdapter;
import com.jing.view.XCRoundImageView;

/**
 * Created by jing on 2016/1/9.
 */
public class Mine_Fragment extends Fragment {

    private View view;
    private LinearLayout ll_collect;
    private LinearLayout ll_number;
    private LinearLayout ll_guanzhu;
    private LinearLayout ll_fensi;
    private ListView mine_lv;
    private XCRoundImageView mine_photo;
    private ImageView qr_code;
    private TextView tv_collect;
    private TextView tv_guanzhu;
    private TextView tv_fensi;
    private TextView tv_bumber;
    private String [] lv_name={"消息","博客","便签","团队"};
    private int [] lv_img={R.drawable.icon_my_message,R.drawable.icon_my_blog,R.drawable.icon_my_note,R.drawable.icon_my_team};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine,null);
        initView();
        return view;
    }
    private void initView(){
        ll_collect = (LinearLayout) view.findViewById(R.id.mine_ll_collect);
        ll_number = (LinearLayout) view.findViewById(R.id.mine_ll_number);
        ll_guanzhu = (LinearLayout) view.findViewById(R.id.mine_ll_guanzhu);
        ll_fensi = (LinearLayout) view.findViewById(R.id.mine_ll_fensi);
        mine_lv = (ListView) view.findViewById(R.id.mine_lv);
        mine_photo = (XCRoundImageView) view.findViewById(R.id.mine_photo);
        qr_code = (ImageView) view.findViewById(R.id.mine_qr_code);
        tv_collect = (TextView) view.findViewById(R.id.mine_tv_collect);
        tv_guanzhu = (TextView) view.findViewById(R.id.mine_tv_guanzhu);
        tv_fensi = (TextView) view.findViewById(R.id.mine_tv_fensi);
        tv_bumber = (TextView) view.findViewById(R.id.mine_tv_number);

        FindAdapter adapter=new FindAdapter(lv_name,lv_img,getActivity());
        mine_lv.setAdapter(adapter);


    }

}
