package com.example.hejoyy.lsm;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by 608_22 on 2016-03-30.
 */
public class mulitzoom extends Activity {
    ImageView imageView;
    PhotoViewAttacher mAttacher;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =(ImageView)findViewById(R.id.imageView);

        Drawable bitmap =getResources().getDrawable(R.drawable.lion);
        imageView.setImageDrawable(bitmap);

        mAttacher = new PhotoViewAttacher(imageView);
    }
}
