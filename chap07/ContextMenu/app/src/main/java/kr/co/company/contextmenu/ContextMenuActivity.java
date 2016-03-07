package kr.co.company.contextmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ContextMenuActivity extends Activity {
	TextView text;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text = (TextView) findViewById(R.id.TextView01);
		registerForContextMenu(text);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("컨텍스트메뉴");
		menu.add(0, 1, 0, "배경색: RED");
		menu.add(0, 2, 0, "배경색: GREEN");
		menu.add(0, 3, 0, "배경색: BLUE");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			text.setBackgroundColor(Color.RED);
			return true;
		case 2:
			text.setBackgroundColor(Color.GREEN);
			return true;
		case 3:
			text.setBackgroundColor(Color.BLUE);
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

} 