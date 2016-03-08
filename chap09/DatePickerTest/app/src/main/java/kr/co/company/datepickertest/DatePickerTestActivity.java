package kr.co.company.datepickertest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class DatePickerTestActivity extends ActionBarActivity {

        private TextView mDateDisplay;
        private Button mPickDate;
        private int mYear;

        private int mMonth;
        private int mDay;
        static final int DATE_DIALOG_ID = 0;

        private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                updateDisplay();
            }

        };

        @Override
        protected Dialog onCreateDialog(int id) {
            switch (id) {
                case DATE_DIALOG_ID:
                    return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                            mDay);
            }
            return null;
        }

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            // 레이아웃에서 뷰 요소를 찾는다.
            mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
            mPickDate = (Button) findViewById(R.id.pickDate);

            // 버튼에 리스너를 추가한다.
            mPickDate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    showDialog(DATE_DIALOG_ID);
                }
            });

            // 현재 날짜를 얻는다.
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            // 현재 날자를 표시한다.

                    updateDisplay();

        }

        // 텍스트 뷰의 날짜를 변경한다.
        private void updateDisplay() {
            mDateDisplay.setText(new StringBuilder()
                    // 월은 0부터 시작되기 때문에 1을 더한다.
                    .append(mMonth + 1).append("-").append(mDay).append("-")
                    .append(mYear).append(" "));
        }

    }

