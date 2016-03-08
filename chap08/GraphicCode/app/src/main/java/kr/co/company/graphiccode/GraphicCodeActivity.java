package kr.co.company.graphiccode;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GraphicCodeActivity extends Activity {
	LinearLayout mLinearLayout;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ���Ͼ� ���̾ƿ��� ���Ѵ�.
		mLinearLayout = new LinearLayout(this);

		float[] array = new float[] { 20, 20, 20, 20, 20, 20, 20, 20 };
		ShapeDrawable rect = new ShapeDrawable(new RoundRectShape(array, null,
				null));
		rect.setIntrinsicHeight(500);
		rect.setIntrinsicWidth(500);
		rect.getPaint().setColor(Color.BLUE);

		ImageView i = new ImageView(this);
		i.setImageDrawable(rect); // ���⼭ �ٷ� �����ϸ� �ȴ�.

		// ImageView�� ���̾ƿ��� �߰��Ѵ�.
		mLinearLayout.addView(i);
		setContentView(mLinearLayout);

	}

}