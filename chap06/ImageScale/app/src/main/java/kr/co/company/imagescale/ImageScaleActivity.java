package kr.co.company.imagescale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ImageScaleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyImageView(this));

	}

}
