package com.udacity.gradle.jokes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public class JokerFactory {

    /**
     * Factory method to hire a specific type of joker
     * @param jType
     * @return
     */
    public static Joker getJoker(JokerType jType){
        switch (jType){
            case HILARIOUS:
                return new HilariousJoker();
            case FUNNY:
                return new FunnyJoker();
            case NOTSOFUNNY:
                return new NotSoFunnyJoker();
            case BORING:
            default:
                return new BoringJoker();
        }
    }

    /**
     * Factory method to hire a random type of joker
     * @return
     */
    public static Joker getRandomJoker(){
        return getJoker(JokerType.getRandomJokerType());
    }
}
