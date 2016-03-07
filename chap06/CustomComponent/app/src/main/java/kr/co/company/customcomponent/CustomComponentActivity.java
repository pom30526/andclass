package kr.co.company.customcomponent;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class CustomComponentActivity extends ActionBarActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        VolumeControlView view = (VolumeControlView)findViewById(R.id.volume);
        view.setKnobListener(new VolumeControlView.KnobListener() {
            @Override
            public void onChanged(double angle) {

                if (angle > 0)
                    ; // 오른쪽으로 회전
                else
                    ; // 왼쪽으로 회전

            }
        });
    }

}
