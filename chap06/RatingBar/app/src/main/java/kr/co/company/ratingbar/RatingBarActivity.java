    package kr.co.company.ratingbar;

    import android.support.v7.app.ActionBarActivity;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.widget.RatingBar;
    import android.widget.Toast;

    public class RatingBarActivity extends ActionBarActivity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            final RatingBar ratingbar = (RatingBar)
                    findViewById(R.id.ratingbar);
            ratingbar.setOnRatingBarChangeListener(new  RatingBar.OnRatingBarChangeListener() {
                        public void onRatingChanged(RatingBar ratingBar, float
                                         rating, boolean fromUser)
                        {
                           Toast.makeText(getApplicationContext(), "New Rating: " +
                             rating, Toast.LENGTH_SHORT).show();
                        }
            });

        }
    }