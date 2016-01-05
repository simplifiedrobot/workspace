package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import com.example.news.R;

public class RefreshListView extends ListView {

	public RefreshListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView();
	}

	public RefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();
	}

	public RefreshListView(Context context) {
		super(context);
		initView();
	}

	public void initView() {
		View view = View.inflate(getContext(), R.layout.refresh_header, null);
		this.addHeaderView(view);
		view.measure(0, 0);
		int MeasuredHeight = view.getMeasuredHeight();
		view.setPadding(0, -MeasuredHeight, 0, 0);
	};
}
