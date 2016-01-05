package menudetail;

import java.util.ArrayList;

import view.RefreshListView;
import view.topnewsViewpager;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import base.newsdetail;
import bean.TabData;
import bean.TabData.TabNewsData;
import bean.newsbean.tabnews;

import com.example.news.MainActivity;
import com.example.news.R;
import com.example.news.utils.MyURL;
import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.viewpagerindicator.CirclePageIndicator;

public class menu_news_detail extends newsdetail implements
		OnPageChangeListener {
	public tabnews mnews;
	private TextView text;
	private TabData detail_news;
	private topnewsViewpager mViewpager;
	private ArrayList<TabData.TopNewsData> topnewsdata;
	public ArrayList<TabNewsData> news;
	private BitmapUtils utils;
	@ViewInject(R.id.topnews_listview)
	private RefreshListView topnews_listview;

	private CirclePageIndicator indicator;
	@ViewInject(R.id.tv_topnews_title)
	private TextView tv_topnews_title;
	private ViewHodler hodler;

	public menu_news_detail(Activity activity) {
		super(activity);
	}

	public menu_news_detail(Activity activity, tabnews news) {
		super(activity);
		System.out.println("menu_news_detail得到的数据news" + news);
		mnews = news;
		initDate();
	}

	@Override
	public View initView() {

		View view = View.inflate(mactivity, R.layout.menu_news_detail, null);
		ViewUtils.inject(this, view);
		mViewpager = (topnewsViewpager) view
				.findViewById(R.id.vp_newsmenudetail_detail);
		indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);

		return view;
	}

	public void initDate() {
		System.out.println("进入initdate方法");
		HttpUtils http = new HttpUtils();
		utils = new BitmapUtils(mactivity);
		String url = MyURL.ROOTURL + mnews.url;
		http.send(HttpMethod.GET, url, new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String json = responseInfo.result;
				Gson gson = new Gson();
				detail_news = gson.fromJson(json, TabData.class);
				System.out.println("获取数据成功");
				topnewsdata = detail_news.data.topnews;
				news = detail_news.data.news;
				if (topnewsdata != null) {
					mViewpager.setAdapter(new MyAdapter());
					indicator.setViewPager(mViewpager);
					indicator.setSnap(true);// 支持快照显示
					indicator.setOnPageChangeListener(menu_news_detail.this);
					indicator.onPageSelected(0);// 让指示器重新定位到第一个点

					tv_topnews_title.setText(topnewsdata.get(0).title);
				}
				if (topnews_listview != null) {
					topnews_listview.setAdapter(new MyListViewAdapter());
				}
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				error.printStackTrace();
				Toast.makeText(mactivity, "获取数据失败", 0).show();
			}
		});
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int arg0) {
		tv_topnews_title.setText(topnewsdata.get(arg0).title);

	}

	class MyListViewAdapter extends BaseAdapter {

		private View listview;

		@Override
		public int getCount() {
			return news.size();
		}

		@Override
		public Object getItem(int position) {
			return news.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			if (convertView == null) {
				listview = View.inflate(mactivity, R.layout.topnews_listview,
						null);
				hodler = new ViewHodler();
				hodler.listimage = (ImageView) listview
						.findViewById(R.id.iv_newsimage);
				hodler.title = (TextView) listview.findViewById(R.id.tv_title);
				hodler.pubdate = (TextView) listview.findViewById(R.id.tv_time);
				listview.setTag(hodler);
			} else {
				hodler = (ViewHodler) listview.getTag();
			}
			hodler.title.setText(news.get(position).title);
			hodler.pubdate.setText(news.get(position).pubdate);
			utils.display(hodler.listimage, news.get(position).listimage);
			return listview;
		}

	}

	static class ViewHodler {
		ImageView listimage;
		TextView title;
		TextView pubdate;
	}

	class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return topnewsdata.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView image = new ImageView(mactivity);
			image.setBackgroundResource(R.drawable.news_pic_default);
			image.setScaleType(ImageView.ScaleType.FIT_XY);
			String imageUrl = topnewsdata.get(position).topimage;
			utils.display(image, imageUrl);
			container.addView(image);
			return image;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) (object));
		}
	}

}
