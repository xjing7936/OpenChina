package com.jing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.activity.R;
import com.jing.model.DrawerModel;

import java.util.List;

/**
 * Created by jing on 2016/1/6.
 */
public class DrawAdapter extends BaseAdapter {
    private List<DrawerModel> list;
    private Context context;

    public DrawAdapter(List<DrawerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.item_drawer, null);
        ImageView image = (ImageView) convertView.findViewById(R.id.item_drawer_img);
        TextView name = (TextView) convertView.findViewById(R.id.item_drawer_name);
        image.setImageResource(list.get(position).getImg());
        name.setText(list.get(position).getName());
        return convertView;
    }
}
