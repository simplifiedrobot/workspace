package com.example.news;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.example.news.utils.mprefUtils;

public class guideActivity extends Activity {
	private ViewPager viewpager;
	private LinearLayout ll_pointer;
	private ArrayList<ImageView> imagelist;
	private ImageView iv_point;
	private Button bt_splash;
	private int pointWidth;
	private static final int[] drawableIds = new int[] { R.drawable.guide_1,
			R.drawable.guide_2, R.drawable.guide_3 };;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activityguide);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		ll_pointer = (LinearLayout) findViewById(R.id.ll_pointer);
		iv_point = (ImageView) findViewById(R.id.iv_point);
		bt_splash=(Button) findViewById(R.id.bt_splash);
		initView();
		// 获取视图树
		ll_pointer.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						ll_pointer.getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);// 删除监听器
						pointWidth = ll_pointer.getChildAt(1).getLeft()
								- ll_pointer.getChildAt(0).getLeft();
						System.out.println(pointWidth);
					}
				});
		viewpager.setAdapter(new myAdapter());
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				if(position==drawableIds.length-1){
					bt_splash.setVisibility(View.VISIBLE);
				}else{
					bt_splash.setVisibility(View.INVISIBLE);
				}
			}
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) iv_point
						.getLayoutParams();
				int newleft = (int) ( (positionOffset * pointWidth) + (position * pointWidth));
				params.leftMargin=newleft;
				iv_point.setLayoutParams(params);
			}
			@Override
			public void onPageScrollStateChanged(int state) {
			}
		});
	}

	private void initView() {
		imagelist = new ArrayList<ImageView>();
		for (int i = 0; i < drawableIds.length; i++) {// 初始化引导图片
			ImageView image = new ImageView(this);
			image.setBackgroundResource(drawableIds[i]);
			imagelist.add(image);
		}
		for (int i = 0; i < drawableIds.length; i++) {// 初始化引灰色圆点
			View view = new View(this);
			view.setBackgroundResource(R.drawable.guide_pointer_grey);
			LayoutParams params = new LinearLayout.LayoutParams(10, 10);
			if (i > 0) {
				params.leftMargin = 10;
			}
			view.setLayoutParams(params);
			ll_pointer.addView(view);
		}
		bt_splash.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mprefUtils.putboolean(guideActivity.this, "is_user_guide", true);
				startActivity(new Intent(guideActivity.this,MainActivity.class));
				finish();
			}
		});
	}

	class myAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return drawableIds.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(imagelist.get(position));
			return imagelist.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
	
}
