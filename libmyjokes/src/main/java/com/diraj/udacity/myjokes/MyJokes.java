package com.diraj.udacity.myjokes;

import java.util.Random;

public class MyJokes {

    private static final Random rndIndxGenerator = new Random();
    public static String[] JOKES = {
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "‘I’m sorry’ and ‘I apologize’ generally mean the same thing – except at funerals.",
            "Patient: Doctor! You've got to help me! Nobody ever listens to me. No one ever pays any attention to what I have to say.\n" +
                    "Doctor: Next please! ",
            "It is so cold outside I saw a politician with his hands in his own pockets.",
            "I'd like to buy a new boomerang please. Also, can you tell me how to throw the old one away?",
            "I wanted to grow my own food but I couldn’t get bacon seeds anywhere.",
            "I can’t believe I forgot to go to the gym today. That’s 7 years in a row now.",
            "Woke up with a dead leg this morning. I will not take out a loan with the mafia ever again.",
            "Why haven’t you ever seen any elephants hiding up trees? Because they’re really, really good at it."
    };

    public static String getJoke() {
        return JOKES[rndIndxGenerator.nextInt(JOKES.length)];
    }
}
