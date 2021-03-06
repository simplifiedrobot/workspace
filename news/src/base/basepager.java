package base;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.example.news.MainActivity;
import com.example.news.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class basepager {

	public Activity mactivity;
	public View mview;
	private ImageButton ib_menu;
	private MainActivity activity;
	public basepager(Activity activity) {
		mactivity = activity;
		initView();
	}

	public void initView() {
		mview = View.inflate(mactivity, R.layout.basepager, null);
		ib_menu = (ImageButton) mview.findViewById(R.id.ib_menu);
		ib_menu = (ImageButton) mview.findViewById(R.id.ib_menu);
		ib_menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				slidingMenuShow();
			}
		});
	}
	
	public void slidingMenuShow(){
		activity = (MainActivity) mactivity;
		SlidingMenu slidingMenu = activity.getSlidingMenu();
		slidingMenu.toggle();
	}
	public void initData() {

	};
	public void setbtVisible(boolean b) {
		if (b) {
			ib_menu.setVisibility(View.VISIBLE);
		}else{
			ib_menu.setVisibility(View.INVISIBLE);
		}
	}
	
	
	public void setSlidingmenu(boolean b){
		MainActivity  mainUI=(MainActivity) mactivity;
		SlidingMenu slidingMenu = mainUI.getSlidingMenu();
		if(b){
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		}else{
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}
}
