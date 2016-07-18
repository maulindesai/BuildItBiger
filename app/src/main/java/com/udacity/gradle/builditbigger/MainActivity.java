package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.maulin.displayjoke.displayJoke;
import com.example.maulin.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar= (ProgressBar) findViewById(R.id.progressBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * fetch joke from api
     */
    public void tellJoke(){
        new jokeEndPointRequest().execute();
    }

    public class jokeEndPointRequest extends AsyncTask<Void,Void,String> {

        JokeApi jokeApi=null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... params) {
            JokeApi.Builder builder=new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl(getString(R.string.api_url));
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
            mProgressBar.setVisibility(View.GONE);
            if(s!=null) {
                displayJoke(s);
            } else {
                Toast.makeText(MainActivity.this, R.string.network_error,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void displayJoke(String joke){
        Intent intent = new Intent(MainActivity.this, displayJoke.class);
        intent.putExtra(displayJoke.JOKE_EXTRA, joke);
        startActivity(intent);
    }
}
