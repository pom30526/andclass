package kr.co.company.graphiccustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
	public CustomView(Context context) {
		super(context);
		setBackgroundColor(Color.YELLOW);
	}

	public CustomView(Context context, AttributeSet attrs) {
		super(context);
		setBackgroundColor(Color.YELLOW);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		canvas.drawArc(new RectF(30, 480, 500, 880), 120, 270, true, paint);
	}
}