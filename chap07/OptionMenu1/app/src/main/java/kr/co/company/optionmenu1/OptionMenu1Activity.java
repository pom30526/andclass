package kr.co.company.optionmenu1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionMenu1Activity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);

		MenuItem item1 = menu.add(0, 1, 0, "사과");
		item1.setIcon(R.drawable.ic_launcher);
		item1.setAlphabeticShortcut('a');

		menu.add(0, 2, 0, "포도").setIcon(R.drawable.ic_launcher);
		menu.add(0, 3, 0, "바나나").setIcon(R.drawable.ic_launcher);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "사과", Toast.LENGTH_SHORT).show();
			return true;
		case 2:
			Toast.makeText(this, "포도", Toast.LENGTH_SHORT).show();
			return true;
		case 3:
			Toast.makeText(this, "바나나", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}