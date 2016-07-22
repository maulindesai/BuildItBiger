package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;

import java.util.concurrent.CountDownLatch;

/**
 * Created by maulin on 22/7/16.
 */
public class FetchJokeTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private CountDownLatch signal;
    String mJoke=null;

    public FetchJokeTest(Class<MainActivity> applicationClass) {
        super(applicationClass);
    }

    public FetchJokeTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeEndPointRequest() throws InterruptedException {
        new jokeEndPointRequest(getActivity().getString(R.string.api_url))
        .setJokeListener(
                new jokeEndPointRequest.GetJokeTaskListener() {
                    @Override
                    public void onComplete(String joke) {
                        mJoke=joke;
                        signal.countDown();
                    }

                    @Override
                    public void showProgressBar(int show) {

                    }
                }
        ).execute();
        signal.await();
        assertNotNull(mJoke);
    }
}
