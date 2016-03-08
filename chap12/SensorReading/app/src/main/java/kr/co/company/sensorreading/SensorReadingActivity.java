package kr.co.company.sensorreading;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;


public class SensorReadingActivity extends ActionBarActivity {
    MyReceiver myReceiver=null;

        Intent i;
        static final String LOG_TAG = "ServiceActivity";
    TextView textfield;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.d(LOG_TAG, "onCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            textfield = (TextView) findViewById(R.id.editText);

            //Start service
            i= new Intent(this, SimpleService.class);
            startService(i);
            Log.d( LOG_TAG, "onCreate/startService" );
        }
        @Override
        public void onResume(){
            super.onResume();
            Log.d(LOG_TAG, "onResume/registering receiver");
            myReceiver = new MyReceiver();
            //Register BroadcastReceiver to receive accelerometer data from service
            //if (myReceiver == null){
            IntentFilter filter = new IntentFilter();
            filter.addAction(SimpleService.MY_ACTION);
            registerReceiver(myReceiver, filter);
            //}
        }

        @Override
        public void onPause(){
            super.onPause();
            Log.d( LOG_TAG, "onPause/unregistering receiver" );
            stopService(i);

            if (myReceiver != null){
                unregisterReceiver(myReceiver);
                myReceiver = null;
            }
        }

        @Override
        protected void onStop(){
            super.onStop();
            Log.d( LOG_TAG, "onStop" );
            if (myReceiver != null) {
                unregisterReceiver (myReceiver);
                myReceiver = null;
            }
            stopService(i);
        }
}
