package kr.co.company.mybroadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MyBroadcastActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("kr.co.company.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

}
