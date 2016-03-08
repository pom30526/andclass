package kr.co.company.receivedata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiveDataActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //이미지뷰를 얻는다.
        ImageView imageView = (ImageView) findViewById(R.id.picture);
        //텍스트뷰를 얻는다.
        TextView txtView = (TextView) findViewById(R.id.txt);
        //수신된 인텐트를 구한다.
        Intent intent = getIntent();
        //인텐트에서 액션을 얻는다.
        String action = intent.getAction();
        //MIME 타입을 구한다.
        String type = intent.getType();

        //이 액티비티가 ACTION_SEND로 시작되었으면
        if (action.equals(Intent.ACTION_SEND)) {
            if (type.startsWith("text/")) {
                //텍스트를 처리한다.
                //이미지뷰를 안보이게 한다.
                imageView.setVisibility(View.GONE);
                //수신된 텍스트를 얻는다.
                String text = intent.getStringExtra(Intent.EXTRA_TEXT);
                //문자열이 널문자열인지를 검사한다.
                if (text != null) {
                    //텍스트뷰에 텍스트를 보인다.
                    txtView.setText(text);
                }
            } else if (type.startsWith("image/")) {
                //이미지를 처리한다.
                //텍스트뷰를 가린다.
                txtView.setVisibility(View.GONE);
                //이미지의 url을 얻는다.
                Uri uri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
                //null이 아니면
                if (uri != null) {
                    //이미지뷰에 이미지를 설정한다.
                    imageView.setImageURI(uri);
                }
            }
        } else if (action.equals(Intent.ACTION_MAIN)) {
            //앱이 론처에서 시작되었으면 아무것도 하지 않는다.
        }
    }
}
