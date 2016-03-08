package kr.co.company.listview04;

import android.app.ListActivity;
import android.os.Bundle;

public class ListView04Activity extends ListActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] values = { "Apple", "Apricot", "Avocado", "Banana",
				"Blackberry", "Blueberry", "Cherry", "Coconut", "Cranberry",
				"Grape Raisin", "Honeydew", "Jackfruit", "Lemon", "Lime",
				"Mango", "Watermelon" };
		MyAdapter adapter = new MyAdapter(this, values);
		setListAdapter(adapter);
	}

}
