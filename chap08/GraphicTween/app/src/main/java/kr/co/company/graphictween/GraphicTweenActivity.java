package kr.co.company.graphictween;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GraphicTweenActivity extends Activity {
	LinearLayout mLinearLayout;
	Animation anim;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ���Ͼ� ���̾ƿ��� �����Ѵ�.
		mLinearLayout = new LinearLayout(this);

		float[] array = new float[] { 20, 20, 20, 20, 20, 20, 20, 20 };
		ShapeDrawable rect = new ShapeDrawable(new RoundRectShape(array, null,
				null));
		rect.setIntrinsicHeight(300);
		rect.setIntrinsicWidth(600);
		rect.getPaint().setColor(Color.BLUE);

		ImageView i = new ImageView(this);
		i.setImageDrawable(rect); // ���⼭ �ٷ� �����ϸ� �ȴ�.
		i.setVisibility(View.VISIBLE);
		anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
		i.startAnimation(anim);
		// ImageView�� ���̾ƿ��� �߰��Ѵ�.
		mLinearLayout.addView(i);
		setContentView(mLinearLayout);

		// Load the appropriate animation
	}
}