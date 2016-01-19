package com.jing.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.karumi.expandableselector.ExpandableItem;
import com.karumi.expandableselector.ExpandableSelector;
import com.karumi.expandableselector.ExpandableSelectorListener;
import com.karumi.expandableselector.OnExpandableItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 便签页面
 *
 */
public class NoteActivit extends Activity {


    private EditText note_ed_content;
    private ImageView note_img;
    private TextView note_tv_time;
    private RelativeLayout note_rl;
    private ExpandableSelector iconsExpandableSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note);

        initView();
        initTop();
        initializeIconsExpandableSelector();

    }
    private void  initView(){

        note_ed_content = (EditText) findViewById(R.id.note_ed_content);
        note_img = (ImageView) findViewById(R.id.note_img);
        note_tv_time = (TextView) findViewById(R.id.note_tv_time);
        note_rl = (RelativeLayout) findViewById(R.id.note_rl);


    }
    /**
     * 设置头部
     */
    private void initTop(){
        ImageView top_img = (ImageView) findViewById(R.id.top_img);
        TextView top_tv = (TextView) findViewById(R.id.top_tv);
        ImageView right_img = (ImageView) findViewById(R.id.top_right_img);
        top_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        right_img.setImageResource(R.drawable.icon_qr_code);
        top_tv.setText("编辑便签");
    }
    private void initializeIconsExpandableSelector() {
        iconsExpandableSelector = (ExpandableSelector) findViewById(R.id.es_icons);
        List<ExpandableItem> expandableItems = new ArrayList<ExpandableItem>();
        ExpandableItem item = new ExpandableItem();
        item.setResourceId(R.drawable.item_brown);
        expandableItems.add(item);
        item = new ExpandableItem();
        item.setResourceId(R.drawable.item_green);
        expandableItems.add(item);
        item = new ExpandableItem();
        item.setResourceId(R.drawable.item_pink);
        expandableItems.add(item);
        item = new ExpandableItem();
        item.setResourceId(R.drawable.item_orange);
        expandableItems.add(item);
        iconsExpandableSelector.showExpandableItems(expandableItems);
        iconsExpandableSelector.setOnExpandableItemClickListener(new OnExpandableItemClickListener() {
            @Override
            public void onExpandableItemClickListener(int index, View view) {
                if (index == 0 && iconsExpandableSelector.isExpanded()) {
                    iconsExpandableSelector.collapse();

                }
                switch (index) {
                    case 1:

                        break;
                    case 2:

                        break;
                    default:
                }
            }
        });
        iconsExpandableSelector.setExpandableSelectorListener(new ExpandableSelectorListener() {
            @Override
            public void onCollapse() {

            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapsed() {

            }

            @Override
            public void onExpanded() {

            }
        });
    }
}
