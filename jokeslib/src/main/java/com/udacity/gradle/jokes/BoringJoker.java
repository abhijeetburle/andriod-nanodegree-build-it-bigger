package com.udacity.gradle.jokes;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public class BoringJoker implements Joker {
    @Override
    public String tellAJoke() {
        return "This joker tells boring jokes";
    }
}