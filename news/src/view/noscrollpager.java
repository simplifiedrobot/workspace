package view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class noscrollpager extends ViewPager {

	public noscrollpager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public noscrollpager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
 
	public boolean onTouchEvent(MotionEvent arg0) {
		return false;
	}
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return false;
	}
//×îºóy
}
