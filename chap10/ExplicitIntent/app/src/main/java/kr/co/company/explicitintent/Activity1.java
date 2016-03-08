package kr.co.company.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1 extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
	    Button b = (Button)findViewById(R.id.Button01);
	    b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Activity1.this,
								Activity2.class);
				startActivity(intent);
			}
		}); 
    }
}
