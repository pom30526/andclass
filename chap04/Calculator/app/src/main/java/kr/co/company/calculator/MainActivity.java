package kr.co.company.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edit1;
	private EditText edit2;
	private EditText result;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		edit1 = (EditText) findViewById(R.id.editText1);
		edit2 = (EditText) findViewById(R.id.editText2);
		result = (EditText) findViewById(R.id.editText3);
    }

	public void add(View target)
	{
		String n1 = edit1.getText().toString();
		String n2 = edit2.getText().toString();
		int r = Integer.parseInt(n1) + Integer.parseInt(n2);
		result.setText(" "+ r);
	}
	public void sub(View target)
	{
		String n1 = edit1.getText().toString();
		String n2 = edit2.getText().toString();
		int r = Integer.parseInt(n1) - Integer.parseInt(n2);
		result.setText(" "+ r);
	}
	public void mul(View target)
	{
		String n1 = edit1.getText().toString();
		String n2 = edit2.getText().toString();
		int r = Integer.parseInt(n1) * Integer.parseInt(n2);
		result.setText(" "+ r);
	}
	public void div(View target)
	{
		String n1 = edit1.getText().toString();
		String n2 = edit2.getText().toString();
		int r = Integer.parseInt(n1) / Integer.parseInt(n2);
		result.setText(" "+ r);
	}

}
