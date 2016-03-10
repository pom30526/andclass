package com.example.lsm.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.inject.Inject;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectPreference;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {
    @InjectView(R.id.txtName)
    TextView txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtName.setText("How are you");
    }
}
