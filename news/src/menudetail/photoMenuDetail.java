package menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import base.newsdetail;

public class photoMenuDetail extends newsdetail {

	public photoMenuDetail(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView() {
		// TODO Auto-generated method stub
		TextView text = new TextView(mactivity);
		text.setText("Œ“ «Õº∆¨");
		text.setTextColor(Color.RED);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		return text;
	}

}
