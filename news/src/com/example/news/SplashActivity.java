package com.example.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.news.utils.mprefUtils;

public class SplashActivity extends Activity {

	private RelativeLayout rl_slpash;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slpash);
		rl_slpash = (RelativeLayout) findViewById(R.id.rl_slpash);
		intiUI();
	}

	private void intiUI() {
		AnimationSet set = new AnimationSet(false);
		RotateAnimation rotate = new RotateAnimation(0, 360,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotate.setDuration(1000);
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scale.setDuration(1000);
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(1000);
		set.addAnimation(alpha);
		set.addAnimation(scale);
		set.addAnimation(rotate);
		rl_slpash.startAnimation(set);
		set.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {

				boolean b = mprefUtils.getboolean(SplashActivity.this,
						"is_user_guide", false);
				if (b) {
					System.out.println("…¡∆¡Ω· ¯");
					startActivity(new Intent(SplashActivity.this,
							MainActivity.class));
					finish();
				} else {
					startActivity(new Intent(SplashActivity.this,
							guideActivity.class));
					finish();
				}

			}
		});
	}

}
