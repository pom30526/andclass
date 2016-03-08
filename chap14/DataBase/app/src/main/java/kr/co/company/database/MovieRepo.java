package kr.co.company.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieRepo {
    private DBHelper dbHelper;

    public MovieRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Movie movie) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Movie.KEY_year, movie.year);
        values.put(Movie.KEY_director, movie.director);
        values.put(Movie.KEY_name, movie.name);

        long movie_Id = db.insert(Movie.TABLE, null, values);
        db.close();
        return (int) movie_Id;
    }

    public void delete(int movie_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Movie.TABLE, Movie.KEY_ID + "= ?", new String[] { String.valueOf(movie_Id) });
        db.close();
    }

    public void update(Movie movie) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Movie.KEY_year, movie.year);
        values.put(Movie.KEY_director, movie.director);
        values.put(Movie.KEY_name, movie.name);

        db.update(Movie.TABLE, values, Movie.KEY_ID + "= ?", new String[] { String.valueOf(movie.movie_ID) });
        db.close();
    }

    public ArrayList<HashMap<String, String>>  getMovieList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Movie.KEY_ID + "," +
                Movie.KEY_name + "," +
                Movie.KEY_director + "," +
                Movie.KEY_year +
                " FROM " + Movie.TABLE;

        ArrayList<HashMap<String, String>> movieList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> movie = new HashMap<String, String>();
                movie.put("id", cursor.getString(cursor.getColumnIndex(Movie.KEY_ID)));
                movie.put("name", cursor.getString(cursor.getColumnIndex(Movie.KEY_name)));
                movieList.add(movie);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return movieList;

    }

    public Movie getMovieById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Movie.KEY_ID + "," +
                Movie.KEY_name + "," +
                Movie.KEY_director + "," +
                Movie.KEY_year +
                " FROM " + Movie.TABLE
                + " WHERE " +
                Movie.KEY_ID + "=?";

        Movie movie = new Movie();
        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                movie.movie_ID =cursor.getInt(cursor.getColumnIndex(Movie.KEY_ID));
                movie.name =cursor.getString(cursor.getColumnIndex(Movie.KEY_name));
                movie.director  =cursor.getString(cursor.getColumnIndex(Movie.KEY_director));
                movie.year =cursor.getInt(cursor.getColumnIndex(Movie.KEY_year));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return movie;
    }

}