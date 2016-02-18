package com.udacity.gradle.jokes;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public enum JokerType {
    // Joker types
    HILARIOUS, FUNNY, NOTSOFUNNY, BORING;

    /**
     * Returns a random joker type
     * @return
     */
    public static JokerType getRandomJokerType()  {
        return values()[(int) (Math.random() * values().length)];
    }
}
