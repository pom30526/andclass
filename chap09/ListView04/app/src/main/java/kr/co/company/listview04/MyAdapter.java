package kr.co.company.listview04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public MyAdapter(Context context, String[] values) {
		super(context, R.layout.list_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.list_item, parent, false);
		TextView textView = (TextView) itemView.findViewById(R.id.label);
		ImageView imageView = (ImageView)  itemView.findViewById(R.id.icon);
		textView.setText(values[position]);
		String s = values[position];
		if (s.startsWith("App") || s.startsWith("Cher") || s.startsWith("Ban")) {
			imageView.setImageResource(R.drawable.good);
		} else {
			imageView.setImageResource(R.drawable.fig);
		}

		return itemView;
	}
}