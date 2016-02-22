package com.udacity.gradle.jokes.test;
import com.udacity.gradle.jokes.HilariousJoker;
import com.udacity.gradle.jokes.Joker;
import com.udacity.gradle.jokes.JokerFactory;
import com.udacity.gradle.jokes.JokerType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public class JokerTest {
    @Test
    public void testWhetherAllJokerTellJokes() {
        Joker joker;
        for (JokerType jType: JokerType.values()) {
            joker = JokerFactory.getJoker(jType);
            assert  joker.tellAJoke().length() > 0 : joker.getClass().getSimpleName() + " cant tell a joke. ";
        }
    }
    @Test
    public void testIfAllJokerTypeCanBeHired() {
        int maxAttempts=10;
        Joker joker;
        List<Class<? extends Joker>> allJokers = new ArrayList<Class<? extends Joker>>();
        for (JokerType jType: JokerType.values()
             ) {
            allJokers.add(JokerFactory.getJoker(jType).getClass());
        };
        assert  allJokers.size() > 0 : "Joker types not present.";
        int attempt = maxAttempts;
        while(allJokers.size()>0 && attempt>0){
            joker = JokerFactory.getRandomJoker();
            if(allJokers.contains(joker.getClass())){
                allJokers.remove(joker.getClass());
            }
            --attempt;
        }
        assert allJokers.size() == 0  : "Random joker hiring is biased. Even after "
                +maxAttempts+" attempts, "+allJokers+" were never hired";
    }
}
