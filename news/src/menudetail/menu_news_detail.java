package menudetail;

import java.util.ArrayList;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import base.newsdetail;
import bean.TabData;
import bean.newsbean.tabnews;

import com.example.news.R;
import com.example.news.utils.MyURL;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class menu_news_detail extends newsdetail {
	public tabnews mnews;
	private TextView text;
	private TabData detail_news;
	private ViewPager mViewpager;
	private ArrayList<TabData.TopNewsData> tabnewsdata;
	private BitmapUtils utils;
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
		mViewpager=(ViewPager) view.findViewById(R.id.vp_newsmenudetail_detail);
		return view;
	}
	public void initDate() {
		System.out.println("进入initdate方法");
		HttpUtils http = new HttpUtils();
		utils = new BitmapUtils(mactivity);
		String url=MyURL.ROOTURL+mnews.url;
		http.send(HttpMethod.GET, url,new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String json=responseInfo.result;
				Gson gson = new Gson();
				detail_news = gson.fromJson(json, TabData.class);
				System.out.println("获取数据成功");
				tabnewsdata = detail_news.data.topnews;
				mViewpager.setAdapter(new MyAdapter());
			}
			@Override
			public void onFailure(HttpException error, String msg) {
				error.printStackTrace();
				Toast.makeText(mactivity, "获取数据失败", 0).show();
			}
		} );
	}
	class MyAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return tabnewsdata.size();
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView image = new ImageView(mactivity);
			image.setBackgroundResource(R.drawable.news_pic_default);
			image.setScaleType(ImageView.ScaleType.FIT_XY);
			String imageUrl=tabnewsdata.get(position).topimage;
			utils.display(image, imageUrl);
			container.addView(image);
			return image;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View)(object));
		}
	}
	
}
