package com.jing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.activity.R;
import com.jing.model.News_BolgModel;

import java.util.List;

/**
 * Created by jing on 2016/1/6.
 */
public class NewsBolgAdapter extends BaseAdapter {
    private List<News_BolgModel> list;
    private Context context;

    public NewsBolgAdapter(Context context, List<News_BolgModel> list) {
        this.context = context;
        this.list = list;
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
        View view;
        ViewHolder holder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_news,null);
            holder=new ViewHolder();
            holder.author= (TextView) view.findViewById(R.id.item_news_author);
            holder.body= (TextView) view.findViewById(R.id.item_news_body);

            holder.title= (TextView) view.findViewById(R.id.item_news_title);
            holder.commentcount= (TextView) view.findViewById(R.id.item_news_commentcount);
            holder.times= (TextView) view.findViewById(R.id.item_news_times);

            holder.image_type= (ImageView) view.findViewById(R.id.item_news_image_type);
            view.setTag(holder);

        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();

        }
        String documentType = list.get(position).getDocumentType();
        if(documentType.equals("1")){
            holder.image_type.setImageResource(R.drawable.widget_original_icon);
        }else {
            holder.image_type.setImageResource(R.drawable.widget_repaste_icon);
        }

        holder.title.setText(list.get(position).getTitle());
        holder.body.setText(list.get(position).getBody());
        holder.times.setText(list.get(position).getPubDate());

        holder.commentcount.setText(list.get(position).getCommentCount());
        holder.author.setText(list.get(position).getAuthorname());
        return view;
    }

    class ViewHolder
    {

        ImageView image_type;
        TextView title,body,author,times,commentcount;
    }
}
