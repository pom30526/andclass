package kr.co.company.imagebutton1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ImageButtonActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View target) {
        Toast.makeText(getApplicationContext(), "버튼이 눌려졌습니다",
                Toast.LENGTH_SHORT).show();
    }
}
