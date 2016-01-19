package com.jing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jing.activity.R;
import com.jing.model.LikeListModel;
import com.jing.model.TweetModel;
import com.jing.view.XCRoundImageView;
import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jing on 2016/1/6.
 */
public class TweetAdapter extends BaseAdapter {
    private List<TweetModel> list;
    private Context context;

    public TweetAdapter(Context context, List<TweetModel> list) {
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
            view= LayoutInflater.from(context).inflate(R.layout.item_tweet,null);
            holder=new ViewHolder();
            holder.author= (TextView) view.findViewById(R.id.item_tweet_author);
            holder.body= (TextView) view.findViewById(R.id.item_tweet_body);
            holder.good= (ImageView) view.findViewById(R.id.item_tweet_good);
            holder.image= (XCRoundImageView) view.findViewById(R.id.item_tweet_img);
            holder.pinglun= (TextView) view.findViewById(R.id.item_tweet_pinglun);
            holder.times= (TextView) view.findViewById(R.id.item_tweet_time);
            holder.likename= (TextView) view.findViewById(R.id.item_tweet_likename);

            view.setTag(holder);

        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();

        }
        BitmapUtils utils=new BitmapUtils(context);
        utils.display(holder.image, list.get(position).getPortrait());
        holder.author.setText(list.get(position).getAuthor());
        holder.body.setText(list.get(position).getBody());
        holder.times.setText(list.get(position).getPubDate());

        ArrayList<LikeListModel> likeList = list.get(position).getLikeList();
        if (likeList==null){
            holder.likename.setVisibility(View.GONE);
        }else {
            String str="";
            StringBuffer sb=new StringBuffer();
            for (int i = 0; i < likeList.size(); i++) {
                String name = likeList.get(i).getName();
               sb.append(name+"、");

            }
            if (likeList.size()>4){
            holder.likename.setText(str+"等"+list.get(position).getLikeCount()+"觉得很赞");
            }else{
                holder.likename.setText(str+"觉得很赞");
            }
        }
    holder.pinglun.setText(list.get(position).getCommentCount());


        return view;
    }

    class ViewHolder
    {
        XCRoundImageView image;
        TextView author,body,times,pinglun,likename;
        ImageView good;

    }
}
