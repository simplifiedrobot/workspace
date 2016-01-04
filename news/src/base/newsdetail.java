package base;

import android.app.Activity;
import android.view.View;
import bean.newsbean.slidingnews;
import bean.newsbean.tabnews;

public abstract class newsdetail {

	public Activity mactivity;
	public View view;
	public  slidingnews mslidingnews;
	public newsdetail(Activity activity) {
		mactivity = activity;
		view = initView();
		initData();
	}

	public newsdetail(Activity activity, slidingnews slidingnews) {
		mslidingnews = slidingnews;
		mactivity = activity;
		view = initView();
		initData();
	}

	public abstract View initView();

	public void initData() {
	};
}
