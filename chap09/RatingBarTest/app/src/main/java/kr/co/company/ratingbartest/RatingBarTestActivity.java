package kr.co.company.ratingbartest;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingBarTestActivity extends ActionBarActivity {

        private RatingBar ratingBar;
        private TextView value;
        private Button button;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            SetupRatingBar();
            SetupButton();

        }

        public void SetupRatingBar() {

            ratingBar = (RatingBar) findViewById(R.id.ratingBar);
            value = (TextView) findViewById(R.id.value);

            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

                public void onRatingChanged(RatingBar ratingBar, float rating,	boolean fromUser) {

                    value.setText(String.valueOf(rating));

                }
            });
        }

        public void SetupButton() {

            ratingBar = (RatingBar) findViewById(R.id.ratingBar);
            button = (Button) findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Toast.makeText(getBaseContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
                }

            });

        }
    }

