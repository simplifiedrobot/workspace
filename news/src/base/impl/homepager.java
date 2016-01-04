package base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;
import base.basepager;

import com.example.news.R;

public class homepager extends basepager {

	private FrameLayout fl_content;

	public homepager(Activity activity) {
		super(activity);
	}

	@Override
	public void initView() {
		super.initView();
		TextView tv_title = (TextView) mview.findViewById(R.id.tv_title);
		tv_title.setText("主页");
		fl_content = (FrameLayout) mview.findViewById(R.id.fl_content);
	}

	@Override
	public void initData() {
		super.initData();
		setbtVisible(false);
		setSlidingmenu(false);
		TextView text = new TextView(mactivity);
		text.setText("新闻中心");
		text.setTextColor(Color.RED);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}

}
