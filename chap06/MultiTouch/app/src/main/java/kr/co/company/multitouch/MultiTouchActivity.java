package kr.co.company.multitouch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MultiTouchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MultiTouchView(this, null));
    }
    
}
