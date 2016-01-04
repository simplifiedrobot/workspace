package base.impl;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import base.basepager;

import com.example.news.MainActivity;
import com.example.news.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class masterpager extends basepager {

	private FrameLayout fl_content;
	private ImageButton ib_menu;
	public masterpager(Activity activity) {
		super(activity);
	}
	@Override
	public void initView() {
		super.initView();
		TextView tv_title = (TextView) mview.findViewById(R.id.tv_title);
		tv_title.setText("智慧服务");
		fl_content = (FrameLayout)mview.findViewById(R.id.fl_content);
		ib_menu = (ImageButton) mview.findViewById(R.id.ib_menu);
	}
	@Override
	public void initData() {
		super.initData();
		setbtVisible(true); 
		setSlidingmenu(true);
		TextView text=new TextView(mactivity);
		text.setText("智慧服务");
		text.setTextColor(Color.RED);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		fl_content.addView(text);
	}
}
