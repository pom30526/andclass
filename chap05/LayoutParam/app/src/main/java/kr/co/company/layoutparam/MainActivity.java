package kr.co.company.layoutparam;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout manager = new LinearLayout(this);
		manager.setOrientation(LinearLayout.VERTICAL);

		Button button1 = new Button(this);
		button1.setText("테스트 버튼1");
		Button button2 = new Button(this);

		button2.setText("테스트 버튼2");

		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		manager.addView(button1, param);
		manager.addView(button2, param);
		setContentView(manager);
	}


}
