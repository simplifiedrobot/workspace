package menudetail;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import base.newsdetail;

public class interactMenuDetail extends newsdetail {

	public interactMenuDetail(Activity activity) {
		super(activity);
	}

	@Override
	public View initView() {
		TextView text = new TextView(mactivity);
		text.setText("Œ“ «ª•∂Ø");
		text.setTextColor(Color.RED);
		text.setTextSize(22);
		text.setGravity(Gravity.CENTER);
		return text;
	}

}
