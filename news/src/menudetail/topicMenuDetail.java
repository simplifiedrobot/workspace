package menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import base.newsdetail;

public class topicMenuDetail extends newsdetail {

	public topicMenuDetail(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView() {
		TextView text = new TextView(mactivity);
		text.setText("��������");
		text.setTextColor(Color.RED);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		return text;
	}

}
