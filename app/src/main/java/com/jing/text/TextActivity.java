package com.jing.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.jing.activity.R;
import com.karumi.expandableselector.ExpandableItem;
import com.karumi.expandableselector.ExpandableSelector;
import com.karumi.expandableselector.ExpandableSelectorListener;
import com.karumi.expandableselector.OnExpandableItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class TextActivity extends AppCompatActivity {

    private ExpandableSelector colorsExpandableSelector;
    private View colorsHeaderButton;
    private ExpandableSelector iconsExpandableSelector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initializeIconsExpandableSelector();
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
