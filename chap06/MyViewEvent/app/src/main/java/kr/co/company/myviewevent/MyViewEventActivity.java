package kr.co.company.myviewevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;

// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.
class MyView extends View {
    int key;
    String str;
    int x, y;

    public MyView(Context context) {

        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX(0);
        y = (int) event.getY(0);
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(60);
        canvas.drawText("(" + x + ", " + y + ") 에서 터치 이벤트가 발생하였음", x, y, paint);
    }

}

public class MyViewEventActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView w = new MyView(this);
        setContentView(w);
    }
}