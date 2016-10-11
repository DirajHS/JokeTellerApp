package com.example.diraj.joketeller.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyJoke {

    private String myJoke;

    public MyJoke(String joke) {
        this.myJoke = joke;
    }

    public String getJoke() {
        return myJoke;
    }

    public void setJoke(String joke) {
        myJoke = joke;
    }
}