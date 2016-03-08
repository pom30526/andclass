package kr.co.company.database;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseActivity extends ListActivity {

    TextView movie_Id;

    public void onClick1(View view) {
        Intent intent = new Intent(this, MovieDetail.class);
        intent.putExtra("movie_Id", 0);
        startActivity(intent);
    }
    public void onClick2(View view) {
            MovieRepo repo = new MovieRepo(this);
            ArrayList<HashMap<String, String>> movieList =  repo.getMovieList();
            if(movieList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        movie_Id = (TextView) view.findViewById(R.id.movie_Id);
                        String movieId = movie_Id.getText().toString();
                        Intent intent = new Intent(getApplicationContext(),MovieDetail.class);
                        intent.putExtra("movie_Id", Integer.parseInt( movieId));
                        startActivity(intent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( DataBaseActivity.this, movieList, R.layout.entry, new String[] { "id","name"}, new int[] {R.id.movie_Id, R.id.movie_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this,"영화가 입력되지 않았음!",Toast.LENGTH_SHORT).show();
            }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

}