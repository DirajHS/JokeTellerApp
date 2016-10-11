package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.diraj.joketeller.backend.libmyjoke.Libmyjoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Diraj H S on 10/11/16.
 * Copyright (c) 2016. All rights reserved.
 */

public class GetJokeTask extends AsyncTask<Void, Void, String> {
    private static Libmyjoke libMyJokeService = null;

    @Override
    protected final String doInBackground(Void... params) {
        if (libMyJokeService == null) {
            Libmyjoke.Builder builder = new Libmyjoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://169.254.225.115:8080/_ah/api/");
            libMyJokeService = builder.build();
        }
        try {
            return libMyJokeService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }
}
