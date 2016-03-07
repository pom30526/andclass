package kr.co.company.reservation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {

	private TimePicker tPicker;
	private CalendarView calView;
	private EditText text;
	private EditText text1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tPicker = (TimePicker) findViewById(R.id.timePicker1);
		calView = (CalendarView) findViewById(R.id.calendarView1);
		text = (EditText) findViewById(R.id.editText1);
		text1 = (EditText) findViewById(R.id.editText2);

		calView.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				// TODO Auto-generated method stub

				text.setText(" " + year + " : " + month + " : " + dayOfMonth);
			}
		});
		tPicker.setOnTimeChangedListener(new OnTimeChangedListener() {
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				text1.setText(" " + hourOfDay + " : " + minute);
			}
		});
	}
}
