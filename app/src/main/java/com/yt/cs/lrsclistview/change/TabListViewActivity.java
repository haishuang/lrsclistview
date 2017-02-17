package com.yt.cs.lrsclistview.change;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yt.cs.lrsclistview.R;

import com.yt.cs.lrsclistview.change.adapter.MyLeftAdapter;
import com.yt.cs.lrsclistview.change.adapter.MyRightAdapter;
import com.yt.cs.lrsclistview.change.adapter.TabAdapter;
import com.yt.cs.lrsclistview.change.model.Data;
import com.yt.cs.lrsclistview.model.RightModel;
import com.yt.cs.lrsclistview.tool.UtilTools;
import com.yt.cs.lrsclistview.view.SyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class TabListViewActivity extends AppCompatActivity {
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<Data> datas;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;

    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_list_view);
        leftContainerView = (LinearLayout) findViewById(R.id.left_container);
        leftListView = (ListView) findViewById(R.id.left_container_listview);
        rightContainerView = (LinearLayout) findViewById(R.id.right_container);
        rightListView = (ListView) findViewById(R.id.right_container_listview);
        titleHorsv = (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
        contentHorsv = (SyncHorizontalScrollView) findViewById(R.id.content_horsv);
        rcv = (RecyclerView) findViewById(R.id.rcv);

        // 设置两个水平控件的联动
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);

        initData();
        // 添加左边内容数据
        //leftContainerView.setBackgroundColor(Color.GRAY);
        MyLeftAdapter adapter = new MyLeftAdapter(this, datas);
        leftListView.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(leftListView);

        // 添加右边内容数据
        rightContainerView.setBackgroundColor(Color.GRAY);
        MyRightAdapter myRightAdapter = new MyRightAdapter(this, datas);
        rightListView.setAdapter(myRightAdapter);

        UtilTools.setListViewHeightBasedOnChildren(rightListView);
        //设置tab头部
        List<String> list = new ArrayList<>();
        list.add("一栋");
        list.add("二栋");
        list.add("三栋");
        list.add("四栋");
        list.add("五栋");
        list.add("六栋");
        rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        TabAdapter tabAdapter = new TabAdapter(this,list);
        rcv.setAdapter(tabAdapter);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List list = new ArrayList();

            list.add((100-i)+"--111");
            list.add((100-i)+"--222");
            list.add((100-i)+"--333");
            list.add((100-i)+"--444");
            list.add((100-i)+"--555");
            list.add((100-i)+"--666");
            datas.add(new Data(list, (100-i)+"F"));
        }
    }

}
