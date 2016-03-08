package kr.co.company.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MovieDetail extends ActionBarActivity {

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextName;
    EditText editTextDirector;
    EditText editTextYear;
    private int _Movie_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDirector = (EditText) findViewById(R.id.editTextDirector);
        editTextYear = (EditText) findViewById(R.id.editTextYear);

        _Movie_Id =0;
        Intent intent = getIntent();
        _Movie_Id =intent.getIntExtra("movie_Id", 0);
        MovieRepo repo = new MovieRepo(this);
        Movie movie;
        movie = repo.getMovieById(_Movie_Id);

        editTextYear.setText(String.valueOf(movie.year));
        editTextName.setText(movie.name);
        editTextDirector.setText(movie.director);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            MovieRepo repo = new MovieRepo(this);
            Movie movie = new Movie();
            movie.year= Integer.parseInt(editTextYear.getText().toString());
            movie.director=editTextDirector.getText().toString();
            movie.name=editTextName.getText().toString();
            movie.movie_ID=_Movie_Id;

            if (_Movie_Id==0){
                _Movie_Id = repo.insert(movie);

                Toast.makeText(this,"새로운 영화가 추가되었음!",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(movie);
                Toast.makeText(this,"영화 기록이 변경되었음!",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            MovieRepo repo = new MovieRepo(this);
            repo.delete(_Movie_Id);
            Toast.makeText(this, "영화가 삭제되었음!", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}