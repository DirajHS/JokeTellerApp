package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.ExecutionException;

/**
 * Created by Diraj H S on 10/11/16.
 * Copyright (c) 2016. All rights reserved.
 */

public class GetJokeTestCase extends AndroidTestCase {

    private static final String TAG = GetJokeTestCase.class.getSimpleName();

    public void testFetchesNonEmptyString() {
        GetJokeTask getJokeTask = new GetJokeTask();
        getJokeTask.execute();
        try {
            String joke = getJokeTask.get();
            Log.d(TAG, "Joke: " + joke);
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }
}
