package kr.co.company.calltest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class CallTestActivity extends ActionBarActivity {
    private EditText receiver, message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        receiver = (EditText) findViewById(R.id.receiver);
        message = (EditText) findViewById(R.id.message);
    }


    public void onClickCall(View v) {
        Uri n = Uri.parse("tel: " + receiver.getText());
        startActivity(new Intent(Intent.ACTION_CALL, n));

    }

    public void onClickDial(View v) {
        Uri n = Uri.parse("tel: " + receiver.getText());
        startActivity(new Intent(Intent.ACTION_DIAL, n));
    }


    public void onClickSMS(View v) {
        Uri n = Uri.parse("smsto: " + receiver.getText());
        Intent intent = new Intent(Intent.ACTION_SENDTO, n);
        String t = message.getText().toString();
        intent.putExtra("sms_body", t);
        startActivity(intent);
    }
}