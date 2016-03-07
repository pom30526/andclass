package kr.co.company.weighttest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WeightTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight_test, menu);
		return true;
	}

}
