package kr.co.company.graphictext1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
	public MyView(Context context) {
		super(context);
		setBackgroundColor(Color.YELLOW);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTextSize(100);

		Typeface t;
		t = Typeface.create(Typeface.SERIF, Typeface.NORMAL);
		paint.setTypeface(t);
		paint.setTextAlign(Paint.Align.LEFT);
		canvas.drawText("This is a test!", 10, 400, paint);

		paint.setTextAlign(Paint.Align.CENTER);
		canvas.drawText("This is a test!", 300, 600, paint);

		paint.setTextAlign(Paint.Align.RIGHT);
		canvas.drawText("This is a test!", 600, 800, paint);

		paint.setTextAlign(Paint.Align.LEFT);
		paint.setColor(Color.RED);

		paint.setUnderlineText(true);
		canvas.drawText("This is a test!", 10, 1000, paint);
		paint.setUnderlineText(false);

		paint.setStrikeThruText(true);
		canvas.drawText("This is a test!", 10, 1200, paint);
		paint.setStrikeThruText(false);

		paint.setTextSkewX(-0.5f);
		canvas.drawText("This is a test!", 10, 1400, paint);
		paint.reset();
	}
}

public class GraphicText1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView w = new MyView(this);
		setContentView(w);
	}
}
