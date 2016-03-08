package kr.co.company.emailtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

public class EmailTestActivity extends ActionBarActivity {
    EditText toEdit;
    EditText subjectEdit;
    EditText messageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        toEdit = (EditText) findViewById(R.id.address);
        subjectEdit = (EditText) findViewById(R.id.subject);
        messageEdit = (EditText) findViewById(R.id.message);

    }

    public void send(View view) {
        sendEmail();
    }

    protected void sendEmail() {

        String to = toEdit.getText().toString();
        String subject = subjectEdit.getText().toString();
        String message = messageEdit.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "이메일 클라이언트 선택하기 :"));
    }
}