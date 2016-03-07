package kr.co.company.togglebutton;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.
public class ToggleButtonActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    public void onToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            Toast.makeText(getApplicationContext(), "Checked",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Not checked",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
