package kr.co.company.graphicresource;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GraphicResourceActivity extends Activity {
	LinearLayout mLinearLayout;

	protected void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);

	    mLinearLayout = new LinearLayout(this);

	    ImageView i = new ImageView(this);
		i.setImageDrawable(getResources().getDrawable(R.drawable.oval));
	    i.setMinimumHeight(500);
	    i.setMinimumWidth(500);

	    mLinearLayout.addView(i);
	    setContentView(mLinearLayout);
	}

}