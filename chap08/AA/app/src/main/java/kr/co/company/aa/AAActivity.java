package kr.co.company.aa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) 
    {
    	Paint paint = new Paint();
    	paint.setColor(Color.RED);

    	paint.setAntiAlias(true);
        paint.setTextSize(50);
    	canvas.drawText("앤티 에일리어싱 ON", 30, 300, paint);
    	canvas.drawOval(new RectF(50,400,450,800), paint);

    	paint.setAntiAlias(false);
    	canvas.drawText("앤티 에일리어싱 OFF", 500, 300, paint);
    	canvas.drawOval(new RectF(500,400,900,800), paint);
    }
}

public class AAActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
} 