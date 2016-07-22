package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.view.View;

import com.example.maulin.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class jokeEndPointRequest extends AsyncTask<Void,Void,String> {

    private final String mURL;
    JokeApi jokeApi=null;
        private GetJokeTaskListener callback;

        jokeEndPointRequest(String url) {
            mURL=url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.showProgressBar(View.VISIBLE);
        }

        public jokeEndPointRequest setJokeListener(GetJokeTaskListener listener) {
            this.callback=listener;
            return this;
        }

        @Override
        protected String doInBackground(Void... params) {
            JokeApi.Builder builder=new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl(mURL);
            jokeApi=builder.build();
            try {
                return jokeApi.getJoke().execute().getJoke();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);
            callback.showProgressBar(View.GONE);
            callback.onComplete(s);
        }

        public static interface GetJokeTaskListener {
            public void onComplete(String joke);
            public void showProgressBar(int show);
        }
    }