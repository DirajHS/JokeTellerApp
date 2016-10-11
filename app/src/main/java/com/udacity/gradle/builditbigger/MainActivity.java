package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.diraj.displayjokes.AppConstants;
import com.diraj.displayjokes.DisplayJokeActivity;
import com.example.diraj.joketeller.backend.libmyjoke.Libmyjoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new GetJokeTask().execute(this);
    }

    private static class GetJokeTask extends AsyncTask<Context, Void, String> {

        private static Libmyjoke libMyJokeService = null;
        private Context mContext;
        @Override
        protected String doInBackground(Context... contexts) {
            if(libMyJokeService == null) {
                Libmyjoke.Builder builder = new Libmyjoke.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("http://192.168.145.134:8080/_ah/api/");
                libMyJokeService = builder.build();
            }

            mContext = contexts[0];
            try{
                return libMyJokeService.getJoke().execute().getJoke();
            } catch (IOException e) {
                return e.getLocalizedMessage();
            }
        }

        @Override
        protected void onPostExecute(String joke) {
            Intent intent = new Intent(mContext, DisplayJokeActivity.class);
            intent.putExtra(AppConstants.INTENT_JOKE, joke);
            mContext.startActivity(intent);
        }
    }

}
