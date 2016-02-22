/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.jokes.gecbackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.JokerFactory;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "gecbackend.jokes.gradle.udacity.com",
    ownerName = "gecbackend.jokes.gradle.udacity.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData(JokerFactory.getRandomJoker().tellAJoke());

        return response;
    }

    /** A simple endpoint method hires a random joker to tell a joke */
    @ApiMethod(name = "tellAJoke")
    public MyBean tellAJoke() {
        MyBean response = new MyBean();
        response.setData(JokerFactory.getRandomJoker().tellAJoke());
        return response;
    }
}
