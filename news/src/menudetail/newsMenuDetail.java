package menudetail;

import java.util.ArrayList;

import view.HorizontalViewpager;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import base.newsdetail;
import bean.newsbean.slidingnews;
import bean.newsbean.tabnews;

import com.example.news.MainActivity;
import com.example.news.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;

public class newsMenuDetail extends newsdetail implements
OnPageChangeListener{

	private TextView text;
	private ArrayList<tabnews> list;
	private ViewPager viewpager;
	private newsDetialAdpter mAdapter;
	private ArrayList<menu_news_detail> titleList;
	private TabPageIndicator indicator;
	private menu_news_detail news;
	private ImageButton iv_next;

	public newsMenuDetail(Activity activity, slidingnews slidingnews) {
		super(activity, slidingnews);
		System.out.println("newsMenuDetail得到的数据" + slidingnews);
		list = slidingnews.getChildren();
		initDataView();
	}

	@Override
	public View initView() {
		View view = View.inflate(mactivity, R.layout.newsmenudetail, null);
		viewpager = (ViewPager) view
				.findViewById(R.id.vp_newsmenudetail);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);

		iv_next = (ImageButton) view.findViewById(R.id.iv_next);
		return view;
	}

	@Override
	public void initData() {
		super.initData();
	}

	public void initDataView() {
		titleList = new ArrayList<menu_news_detail>();
		for (int i = 0; i < list.size(); i++) {
			menu_news_detail menu_news_detail = new menu_news_detail(mactivity,
					list.get(i));
			titleList.add(menu_news_detail);
		}
		mAdapter = new newsDetialAdpter();
		viewpager.setAdapter(mAdapter);
		indicator.setViewPager(viewpager);
		indicator.setOnPageChangeListener(newsMenuDetail.this);
		iv_next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int currentItem = viewpager.getCurrentItem();
				viewpager.setCurrentItem(++currentItem);
			}
		});
	}

	class newsDetialAdpter extends PagerAdapter {

		@Override
		public CharSequence getPageTitle(int position) {

			return list.get(position).title;
		}

		@Override
		public int getCount() {
			return titleList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			news = titleList.get(position);
			container.addView(news.view);
			System.out.println(position + "^^^^^^^^^" + news.view.toString());
			return news.view;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			container.removeView((View) object);

		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		MainActivity mActivity = (MainActivity) mactivity;
		SlidingMenu slidingMenu = mActivity.getSlidingMenu();
		
		if (arg0 == 0) {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		} else {
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}

}
