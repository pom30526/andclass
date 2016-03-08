package kr.co.company.sensorreading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    static final String LOG_TAG = "MyReceiver";
    @Override
    public void onReceive(Context arg0, Intent arg1){
        String measurement = arg1.getStringExtra("measurement");
        Log.d(LOG_TAG, "onReceive"+measurement);
        //Toast.makeText(arg0, " " + measurement, Toast.LENGTH_SHORT).show();
    }
}
