/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.maulin.myapplication.backend;

import com.example.Jokers;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.myapplication.maulin.example.com",
    ownerName = "backend.myapplication.maulin.example.com",
    packagePath=""
  )
)
public class JokeEndpoint {

    private final Jokers mJokers;

    public JokeEndpoint() {
        mJokers=new Jokers();
    }

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke() {
        JokeBean response = new JokeBean();
        response.setJoke(mJokers.findJoke());
        return response;
    }

}
