package com.jing.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jing.activity.R;
import com.jing.adapter.FindAdapter;

/**
 * Created by jing on 2016/1/9.
 */
public class Find_Fragment extends Fragment {

    private View view;
    private String [] name={"","好友圈","","找人","活动","","扫一扫","徭一摇"};
    private  int [] image={0,R.drawable.icon_explore_friends,0,R.drawable.icon_explore_finduser,
            R.drawable.icon_explore_event,0,R.drawable.icon_explore_scan,R.drawable.icon_explore_shake};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_find, null);

        initView();
        return view;
    }

    private void initView(){
        ListView find_lv = (ListView) view.findViewById(R.id.find_lv);
        FindAdapter adapter=new FindAdapter(name,image,getActivity());
        find_lv.setAdapter(adapter);


    }
}
