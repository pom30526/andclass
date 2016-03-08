package kr.co.company.pingpong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//�����̴� ���� ��Ÿ���� Ŭ����
class Ball {
	int x, y, xInc = 1, yInc = 1; // xInc�� yInc�� �ѹ� �����̴� �Ÿ��̴�.
	int diameter; // ���� ������
	static int WIDTH = 1080, HEIGHT = 1920; // �����̴� ���� ũ��

	public Ball(int d) { // ����
		this.diameter = d;

		// ���� ��ġ�� �����ϰ� ����
		x = (int) (Math.random() * (WIDTH - d) + 3);
		y = (int) (Math.random() * (HEIGHT - d) + 3);

		// �ѹ� �����̴� �Ÿ��� �����ϰ� ����
		xInc = (int) (Math.random() * 30 + 1);
		yInc = (int) (Math.random() * 30 + 1);

	}

	// ���⼭ ���� �׸���.
	public void paint(Canvas g) {
		Paint paint = new Paint();

		// ���� �ε�ġ�� �ݻ��ϰ� �Ѵ�.
		if (x < diameter || x > (WIDTH - 300))
			xInc = -xInc;
		if (y < diameter || y > (HEIGHT - 300))
			yInc = -yInc;

		// ���� ��ǥ�� �����Ѵ�.
		x += xInc;
		y += yInc;

		// ���� ȭ�鿡 �׸���.
		paint.setColor(Color.RED);
		g.drawCircle(x, y, diameter, paint);
	}
}

// ���ǽ� �� ����
public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	public Ball basket[] = new Ball[10]; // Ball�� �迭 ����
	private MyThread thread; // ������ ���� ����

	public MySurfaceView(Context context) { // ����
		super(context);

		SurfaceHolder holder = getHolder(); // ���ǽ� ���� Ȧ���� ��´�.
		holder.addCallback(this); // �ݹ� �޼ҵ带 ó���Ѵ�.

		thread = new MyThread(holder); // �����带 ���Ѵ�.

		// Ball ��ü�� ���Ͽ��� �迭�� �ִ´�.
		for (int i = 0; i < 10; i++)
			basket[i] = new Ball(100);
	}

	public MyThread getThread() {
		return thread;
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// �����带 �����Ѵ�.
		thread.setRunning(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;

		// �����带 ������Ų��.
		thread.setRunning(false);
		while (retry) {
			try {
				thread.join(); // ���� ������� ��ģ��.
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// Ball.WIDTH = width;
		// Ball.HEIGHT = height;
	}

	// �����带 ���� Ŭ������ �����Ѵ�.
	public class MyThread extends Thread {

		private boolean mRun = false;
		private SurfaceHolder mSurfaceHolder;

		public MyThread(SurfaceHolder surfaceHolder) {
			mSurfaceHolder = surfaceHolder;
		}

		@Override
		public void run() {
			while (mRun) {
				Canvas c = null;
				try {
					c = mSurfaceHolder.lockCanvas(null); // ĵ������ ��´�.
					c.drawColor(Color.BLACK); // ĵ������ ����� �����.
					synchronized (mSurfaceHolder) {
						for (Ball b : basket) { // basket�� ��� ��Ҹ� �׸���.
							b.paint(c);
						}
					}
				} finally {
					if (c != null) {
						// ĵ������ ��ŷ�� Ǭ��.
						mSurfaceHolder.unlockCanvasAndPost(c);
					}
				}
				// try { Thread.sleep(100); } catch (InterruptedException e) { }
			}
		}

		public void setRunning(boolean b) {
			mRun = b;
		}
	}
}