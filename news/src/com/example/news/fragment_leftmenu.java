package com.example.news;

import java.util.ArrayList;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import base.impl.newspager;
import bean.newsbean;
import bean.newsbean.slidingnews;

public class fragment_leftmenu extends baseFragment {

	private ListView lv_menu;
	private ArrayList<slidingnews> slidingnews;
	private int mCurrentPosition;
	private menuAdapter adapter;
	private MainActivity activity;

	@Override
	public View initView() {
		View view = View.inflate(getActivity(), R.layout.fragment_leftmenu,
				null);
		lv_menu = (ListView) view.findViewById(R.id.lv_menu);
		lv_menu.setVerticalScrollBarEnabled(false);
		return view;
	}

	public void initData() {
		lv_menu.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCurrentPosition = position;
				MainActivity acitivity=(MainActivity) mactivity;
				fragment_contentView fragment = (fragment_contentView) acitivity.getcontentView();
				newspager basepager = (newspager) fragment.list.get(1);
				basepager.setNewsDetialPosition(position);
				slidingMenuShow();
				adapter.notifyDataSetChanged();
			}
		});
	}
	public void slidingMenuShow(){
		activity = (MainActivity) mactivity;
		SlidingMenu slidingMenu = activity.getSlidingMenu();
		slidingMenu.toggle();
	}

	public void setMenuData(newsbean data) {
		System.out.println("���ܵ�����" + data);
		slidingnews = data.data;
		adapter = new menuAdapter();
		lv_menu.setAdapter(adapter);
		
	}
	class menuAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return slidingnews.size();
		}
		@Override
		public Object getItem(int position) {
			return slidingnews.get(position);
		}
		@Override
		public long getItemId(int position) {
			return position;
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflate = View
					.inflate(mactivity, R.layout.listview_menu, null);
			TextView tv_menu_title = (TextView) inflate
					.findViewById(R.id.tv_menu_title);
			tv_menu_title.setText(slidingnews.get(position).getTitle());
			if (mCurrentPosition == position) {
				tv_menu_title.setEnabled(true);
			} else {
				tv_menu_title.setEnabled(false);
			}
			return inflate;
		}
	}
}