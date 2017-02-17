package com.yt.cs.lrsclistview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yt.cs.lrsclistview.adapter.MyLeftAdapter;
import com.yt.cs.lrsclistview.adapter.MyRightAdapter;
import com.yt.cs.lrsclistview.change.TabListViewActivity;
import com.yt.cs.lrsclistview.model.RightModel;
import com.yt.cs.lrsclistview.tool.UtilTools;
import com.yt.cs.lrsclistview.view.SyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<String> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<RightModel> models;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftContainerView = (LinearLayout) findViewById(R.id.left_container);
        leftListView = (ListView) findViewById(R.id.left_container_listview);
        rightContainerView = (LinearLayout) findViewById(R.id.right_container);
        rightListView = (ListView) findViewById(R.id.right_container_listview);
        titleHorsv = (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
        contentHorsv = (SyncHorizontalScrollView) findViewById(R.id.content_horsv);

        tv = (TextView) findViewById(R.id.tv_title);

        // 设置两个水平控件的联动
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);

        // 添加左边内容数据
        leftContainerView.setBackgroundColor(Color.YELLOW);
        initLeftData();
        MyLeftAdapter adapter = new MyLeftAdapter(this, leftlList);
        leftListView.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(leftListView);
        // 添加右边内容数据
        rightContainerView.setBackgroundColor(Color.GRAY);
        initRightData();
        MyRightAdapter myRightAdapter = new MyRightAdapter(this, models);
        rightListView.setAdapter(myRightAdapter);
        UtilTools.setListViewHeightBasedOnChildren(rightListView);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabListViewActivity.class));
            }
        });
    }

    private void initRightData() {
        models = new ArrayList<RightModel>();
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "", "555", "666"));
        models.add(new RightModel("111", "222", "333", "", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "", "666"));
        models.add(new RightModel("1112a", "222a", "333a", "444a", "555a", "666a"));
    }

    private void initLeftData() {
        leftlList = new ArrayList<String>();
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
    }
}
