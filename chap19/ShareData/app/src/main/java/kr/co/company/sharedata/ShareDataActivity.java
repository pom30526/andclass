package kr.co.company.sharedata;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;


public class ShareDataActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    /* 텍스트 공유    */
    public void shareText(View v) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "텍스트를 어디로?"));
    }

    /* 이미지 공유    */
    public void shareImage(View v) {
        // SD CARD에 myImage.png 파일이 있어야 한다.
        String imagePath = Environment.getExternalStorageDirectory()
                + "/myImage.png";
        File imageFileToShare = new File(imagePath);
        Uri uri = Uri.fromFile(imageFileToShare);

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, "이미지를 어디로?"));
    }
}