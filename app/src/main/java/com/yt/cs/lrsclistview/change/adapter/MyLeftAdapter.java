package com.yt.cs.lrsclistview.change.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yt.cs.lrsclistview.R;
import com.yt.cs.lrsclistview.change.model.Data;

import java.util.List;


public class MyLeftAdapter extends BaseAdapter {
	
	private Context context;
	private List<Data> list;

	public MyLeftAdapter(Context context, List<Data> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		if (list!=null) {
			return list.size();
		}
		return 0;
	}

	@Override
	public Object getItem(int position) {
		if (list!=null) {
			return list.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHold hold;
		if (convertView==null) {
			hold=new ViewHold();
			convertView=LayoutInflater.from(context).inflate(R.layout.layout_left_item, null);
			hold.textView=(TextView) convertView.findViewById(R.id.left_container_textview0);
			convertView.setTag(hold);
		}else {
			hold=(ViewHold) convertView.getTag();
		}
		hold.textView.setText(list.get(position).getLeftTitle());
		return convertView;
	}
	
	static class ViewHold{
		TextView textView;
	}

}
