package com.yt.cs.lrsclistview.change.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yt.cs.lrsclistview.R;
import com.yt.cs.lrsclistview.change.model.Data;
import com.yt.cs.lrsclistview.model.RightModel;

import java.util.List;


public class MyRightAdapter extends BaseAdapter {
    private Context context;
    List<Data> list;

    public MyRightAdapter(Context context, List<Data> models) {
        super();
        this.context = context;
        this.list = models;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHold viewHold;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_right_item2, null);
            viewHold.ll = (LinearLayout) convertView.findViewById(R.id.ll);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }

        if(position%2==0){
            viewHold.ll.setBackgroundColor(Color.GREEN);
        }else {
            viewHold.ll.setBackgroundColor(Color.WHITE);
        }


        viewHold.ll.removeAllViews();
        //因为不知道到底有几列数据，只能动态生成
        for (int i = 0; i < list.get(position).getList().size(); i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.change_item, null);
            TextView t = (TextView) view.findViewById(R.id.tv000);

            t.setText(list.get(position).getList().get(i).toString());
            final int i1 = i;
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"点击了"+position+"-"+i1,Toast.LENGTH_SHORT).show();
                }
            });

            viewHold.ll.addView(view);
        }

        return convertView;
    }

    static class ViewHold {
        LinearLayout ll;
    }

}
