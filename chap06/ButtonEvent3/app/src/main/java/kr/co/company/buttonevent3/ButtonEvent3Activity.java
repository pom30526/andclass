package kr.co.company.buttonevent3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonEvent3Activity extends Activity  implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(this);
	}
	

	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "버튼이 눌려졌습니다.", Toast.LENGTH_SHORT).show();
	}
}