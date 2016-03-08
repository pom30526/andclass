package kr.co.company.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "movies.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE " + Movie.TABLE  + "("
                + Movie.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Movie.KEY_name + " TEXT, "
                + Movie.KEY_year + " INTEGER, "
                + Movie.KEY_director + " TEXT )";

        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Movie.TABLE);

        onCreate(db);
    }
}