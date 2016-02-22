package com.udacity.gradle.builditbigger.service;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.jokes.gecbackend.myApi.MyApi;
import com.udacity.gradle.jokesandroidlib.DisplayJokeActivity;

import java.io.IOException;

/**
 * Created by abhijeet.burle on 2016/02/18.
 */
public class GecBackendEndpointAsynTask extends AsyncTask<Context, Void, String> {
        private final String LOG_TAG = GecBackendEndpointAsynTask.class.getSimpleName();
        private static MyApi myApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params){
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }

            context = params[0];

            try {
                return myApiService.tellAJoke().execute().getData();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Call to API Service failed.",  e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if(result==null){
                result = context.getResources().getString(R.string.msg_no_joke_found);
            }
            Intent intentDisplayJoke  = new Intent(context, DisplayJokeActivity.class);
            intentDisplayJoke.putExtra(DisplayJokeActivity.DISPLAY_JOKE_KEY,
                    result);
            context.startActivity(intentDisplayJoke);
        }
    }