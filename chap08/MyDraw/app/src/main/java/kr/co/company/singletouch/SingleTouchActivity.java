package kr.co.company.singletouch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class SingleTouchActivity extends Activity {
	private SingleTouchView drawView;
	private ImageButton currPaint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		drawView = (SingleTouchView) findViewById(R.id.drawing);
		LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);
		currPaint = (ImageButton) paintLayout.getChildAt(0);

	}

	public void clicked(View view) {
		if (view != currPaint) {
			String color = view.getTag().toString();
			drawView.setColor(color);
			currPaint = (ImageButton) view;
		}
	}

}
