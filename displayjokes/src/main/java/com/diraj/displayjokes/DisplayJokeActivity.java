package com.diraj.displayjokes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        getSupportActionBar().setTitle(getString(R.string.app_name));
        String joke = getIntent().getStringExtra(AppConstants.INTENT_JOKE);
        TextView jokeView = (TextView) findViewById(R.id.tv_joke);
        jokeView.setText(joke);
    }
}
