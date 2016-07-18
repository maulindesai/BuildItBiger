package com.example.maulin.displayjoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class displayJoke extends AppCompatActivity {

    public static final java.lang.String JOKE_EXTRA = "jokeextra";
    private TextView tv_joke;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        tv_joke= (TextView) findViewById(R.id.tv_joke);

        if(getIntent().getExtras()!=null) {
            String joke=getIntent().getExtras().getString(JOKE_EXTRA);
            tv_joke.setText(joke);
        } else {
            tv_joke.setText(R.string.no_joke_found);
        }
    }
}
