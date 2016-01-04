package com.example.news;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import base.basepager;
import base.impl.govpager;
import base.impl.homepager;
import base.impl.masterpager;
import base.impl.newspager;
import base.impl.settingpager;

public class fragment_contentView extends baseFragment {

	public  ArrayList<basepager> list;
	private RadioGroup rg_group;
	private ViewPager viewpager;

	@Override
	View initView() {
		View view = View.inflate(getActivity(), R.layout.fragment_contentview,
				null);
		viewpager = (ViewPager) view.findViewById(R.id.viewpager_main);

		rg_group = (RadioGroup) view.findViewById(R.id.rg_group);
		rg_group.check(R.id.rb_home);
		rg_group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					viewpager.setCurrentItem(0, false);
					break;
				case R.id.rb_news:
					viewpager.setCurrentItem(1, false);
					break;
				case R.id.rb_smart:
					viewpager.setCurrentItem(2, false);
					break;
				case R.id.rb_gov:
					viewpager.setCurrentItem(3, false);
					break;
				case R.id.rb_setting:
					viewpager.setCurrentItem(4, false);

				}
			}
		});
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				list.get(arg0).initData();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		return view;
	}

	@Override
	public void initData() {
		list = new ArrayList<basepager>();
		list.add(new homepager(mactivity));
		list.add(new newspager(mactivity));
		list.add(new masterpager(mactivity));
		list.add(new govpager(mactivity));
		list.add(new settingpager(mactivity));
		super.initData();
		viewpager.setAdapter(new contentAdapter());
		list.get(0).initData();
	}

	class contentAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			container.addView(list.get(position).mview);
			return list.get(position).mview;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}
