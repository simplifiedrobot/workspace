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
			getParent().requestDisallowInterceptTouchEvent(true);// ��Ҫ���أ���֤action_move����
			startX = (int) ev.getRawX();
			startY = (int) ev.getRawY();
			break;
		case MotionEvent.ACTION_MOVE:
			endX = (int) ev.getRawX();
			endY = (int) ev.getRawY();
			if (Math.abs(endX - startX) > Math.abs(endY - startY)) {// �ж��Ǻ��򻬶�
				if (endX > startX) {// �һ�
					if (getCurrentItem() == 0) {
						getParent().requestDisallowInterceptTouchEvent(false);// ����
					}
				} else {
					if (getCurrentItem() == getAdapter().getCount() - 1) {
						getParent().requestDisallowInterceptTouchEvent(false);// ����
					}
				}
			} else {// ���»���
				getParent().requestDisallowInterceptTouchEvent(false);// ����
			}
			break;
		default:
			break;
		}

		return super.dispatchTouchEvent(ev);
	}

}