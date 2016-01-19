package com.jing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.activity.R;

/**
 * Created by jing on 2016/1/6.
 */
public class FindAdapter extends BaseAdapter {

    private String [] names;
    private  int [] image;
    private Context context;

    public FindAdapter(String[] names, int[] image, Context context) {
        this.names = names;
        this.image = image;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.item_find, null);
        ImageView images = (ImageView) convertView.findViewById(R.id.item_find_img);
        TextView name = (TextView) convertView.findViewById(R.id.item_find_img_name);
        if (names[position].equals("")){
            convertView=View.inflate(context, R.layout.item__view, null);
        }else{
        images.setImageResource(image[position]);
        name.setText(names[position]);
        }
        return convertView;
    }
}
