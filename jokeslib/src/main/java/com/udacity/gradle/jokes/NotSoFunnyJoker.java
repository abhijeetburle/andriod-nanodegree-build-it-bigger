package com.udacity.gradle.jokes;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public class NotSoFunnyJoker implements Joker{
    @Override
    public String tellAJoke(){
        return "This joker tells not so funny jokes";
    }
}