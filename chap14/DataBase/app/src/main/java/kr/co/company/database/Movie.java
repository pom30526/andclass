package kr.co.company.database;

public class Movie {
    // 테이블 이름
    public static final String TABLE = "Movie";

    // 테이블 컬럼 이름
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_director = "director";
    public static final String KEY_year = "year";

    public int movie_ID;
    public String name;
    public String director;
    public int year;
}