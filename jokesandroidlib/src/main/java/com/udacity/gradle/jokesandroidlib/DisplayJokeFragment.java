package com.udacity.gradle.jokesandroidlib;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayJokeFragment extends Fragment {
    public  DisplayJokeFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_display_joke , container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(DisplayJokeActivity.DISPLAY_JOKE_KEY);
        TextView txtJoke = (TextView) root.findViewById(R.id.txtJoke);
        if (joke != null && joke.length() != 0) {
            txtJoke.setText(joke);
        }

        return root;
    }
}
