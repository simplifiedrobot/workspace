package view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class topnewsViewpager extends ViewPager {

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public topnewsViewpager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public topnewsViewpager(Context context) {
		super(context);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			getParent().requestDisallowInterceptTouchEvent(true);// 不要拦截，保证action_move调用
			startX = (int) ev.getRawX();
			startY = (int) ev.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:
			endX = (int) ev.getRawX();
			endY = (int) ev.getRawY();
			if (Math.abs(endX - startX) > Math.abs(endY - startY)) {// 判断是横向滑动
				if (endX > startX) {// 右划
					if (getCurrentItem() == 0) {
						getParent().requestDisallowInterceptTouchEvent(false);// 拦截
					}
				} else {
					if (getCurrentItem() == getAdapter().getCount() - 1) {
						getParent().requestDisallowInterceptTouchEvent(false);// 拦截
					}
				}
			} else {// 上下滑动
				getParent().requestDisallowInterceptTouchEvent(false);// 拦截
			}
			break;
		default:
			break;
		}

		return super.dispatchTouchEvent(ev);
	}

}
