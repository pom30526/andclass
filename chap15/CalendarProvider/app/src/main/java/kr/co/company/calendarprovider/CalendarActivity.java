package kr.co.company.calendarprovider;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Toast;

public class CalendarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View v) {
        query();
    }

    public void query() {
        String[] projection = {CalendarContract.Events._ID,
                CalendarContract.Events.TITLE};
        // 이벤트 제공자를 찾아서 쿼리하고 결과를 커서로 받는다.
        Cursor cursor = getContentResolver().query(
                CalendarContract.Events.CONTENT_URI, projection, null, null,
                null);
        // 컬럼의 인덱스를 구한다.
        int nameIdx = cursor
                .getColumnIndexOrThrow(CalendarContract.Events.TITLE);
        int idIdx = cursor.getColumnIndexOrThrow(CalendarContract.Events._ID);
        // 결과 집합을 초기화한다.
        String[] result = new String[cursor.getCount()];
        // 결과 집합을 커서로 반복한다.
        while (cursor.moveToNext()) {
            // 이름을 추출한다.
            String name = cursor.getString(nameIdx);
            // 아이디를 추출한다.
            String id = cursor.getString(idIdx);
            result[cursor.getPosition()] = name + "(" + id + ")";
            Toast.makeText(this, name + "(아이디=" + id + ")", Toast.LENGTH_SHORT)
                    .show();
        }
        // 커서를 닫는다.
        cursor.close();
    }

}