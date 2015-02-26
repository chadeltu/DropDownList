package com.example.dropdownlist;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

class ViewHolder {
	// 顶部控件
	public RelativeLayout rlTop;
	public ImageView ivLogo;
	public TextView tvTitle;
	public TextView tvSubTitle;
	// 底部控件
	public LinearLayout llBottom;
	public TextView tv1;
	public TextView tv2;
	public TextView tv3;
}

public class MyAdapter extends BaseAdapter {

	private Context mContext = null;
	private LayoutInflater mInflater = null;
	private List<ListItem> lData = null;
	// 用一组list保存下拉状态（true - 显示下拉， false - 隐藏下拉）
	public ArrayList<Boolean> lDropDown;

	public MyAdapter(Context context, List<ListItem> list) {
		super();
		this.mContext = context;
		this.mInflater = LayoutInflater.from(context);
		this.lData = list;

		// 初始状态，所有都不显示下拉
		lDropDown = new ArrayList<Boolean>();
		for (int i = 0; i < lData.size(); i++) {
			lDropDown.add(false);
		}
	}

	@Override
	public int getCount() {
		return lData.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item, null);

			holder.rlTop = (RelativeLayout) convertView
					.findViewById(R.id.rl_top_bar);
			holder.ivLogo = (ImageView) convertView.findViewById(R.id.iv_logo);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tvSubTitle = (TextView) convertView
					.findViewById(R.id.tv_subtitle);
			holder.llBottom = (LinearLayout) convertView
					.findViewById(R.id.ll_bottom_bar);
			holder.tv1 = (TextView) convertView.findViewById(R.id.tv_btn1);
			holder.tv2 = (TextView) convertView.findViewById(R.id.tv_btn2);
			holder.tv3 = (TextView) convertView.findViewById(R.id.tv_btn3);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		ListItem item = lData.get(position);

		holder.tvTitle.setText(item.title);
		holder.tvSubTitle.setText(item.subTitle);

		if (lDropDown.get(position)) {
			holder.llBottom.setVisibility(View.VISIBLE);	// 显示下拉内容
		} else {
			holder.llBottom.setVisibility(View.GONE);		// 隐藏下拉内容
		}

		final int index = position;
		
		// 顶部控件组（RelativeLayout）响应点击操作，用于显示/隐藏底部控件组（下拉内容）
		holder.rlTop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean bFlagTemp = lDropDown.get(index);
				for (int i = 0; i < lData.size(); i++) {
					lDropDown.set(i, false);
				}
				lDropDown.set(index, !bFlagTemp);
				notifyDataSetChanged();
			}
		});

		holder.tv1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "list item - " + index + ", btn 1",
						Toast.LENGTH_SHORT).show();
			}
		});

		holder.tv2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "list item - " + index + ", btn 2",
						Toast.LENGTH_SHORT).show();
			}
		});

		holder.tv3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "list item - " + index + ", btn 3",
						Toast.LENGTH_SHORT).show();
			}
		});

		return convertView;
	}

}
