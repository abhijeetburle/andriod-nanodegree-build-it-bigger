package com.udacity.gradle.jokesandroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 *
 */
public class DisplayJokeActivity extends AppCompatActivity {
    public static final String DISPLAY_JOKE_KEY="DisplayJokeActivityKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
    }
}
