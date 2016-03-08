package kr.co.company.permission;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PermissionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.permission, menu);
        return true;
    }
    
}
