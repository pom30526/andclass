package com.example.myphotoshop1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private static float mAngle = 0.0F;
	private static float mScaleX = 0.3F;
	private static float mScaleY = 0.3F;
	private static float mBrightScale = 1.0F;
	private static SampleView sampleview;
	ColorMatrix cm = new ColorMatrix();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearLayout imagepos = (LinearLayout) findViewById(R.id.imagepos);
		sampleview = (SampleView) new SampleView(this);
		imagepos.addView(sampleview);

	}

	public void scaleup(View v) {
		mScaleX += 0.1f;
		mScaleY += 0.1f;
		sampleview.invalidate();
	}

	public void scaledown(View v) {
		mScaleX -= 0.1f;
		mScaleY -= 0.1f;
		sampleview.invalidate();
	}

	public void rotate(View v) {
		mAngle = mAngle + 20;
		sampleview.invalidate();
	}

	public void brightup(View v) {
		mBrightScale += 0.1f;
		setColorScale(cm, mBrightScale);
		sampleview.invalidate();
	}

	public void brightdown(View v) {
		mBrightScale -= 0.1f;
		setColorScale(cm, mBrightScale);
		sampleview.invalidate();
	}

	public void reset(View v) {
		mBrightScale = 1.0f;
		mAngle = 0f;
		mScaleX = 0.3f;
		mScaleY = 0.3f;
		setColorScale(cm, mBrightScale);
		sampleview.invalidate();
	}

	public void setColorScale(ColorMatrix cm, float scale) {
		cm.set(new float[] { scale, 0, 0, 0, 0, 0, scale, 0, 0, 0, 0, 0, scale,
				0, 0, 0, 0, 0, 1, 0 });
	}

	public class SampleView extends View {
		private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		private ColorMatrix mCM = new ColorMatrix();
		private Bitmap mBitmap;
		private float mSaturation;

		public SampleView(Context context) {
			super(context);

			mBitmap = BitmapFactory.decodeResource(context.getResources(),
					R.drawable.lenna);
		}

		@Override
		protected void onDraw(Canvas canvas) {
			Paint paint = mPaint;
			float x = 20;
			float y = 20;

			canvas.drawColor(Color.WHITE);
			canvas.scale(mScaleX, mScaleY, 0, 0);
			canvas.rotate(mAngle, mBitmap.getWidth() / 2,
					mBitmap.getWidth() / 2);

			paint.setColorFilter(null);
			paint.setColorFilter(new ColorMatrixColorFilter(cm));
			canvas.drawBitmap(mBitmap, x, y, paint);

		}
	}
}