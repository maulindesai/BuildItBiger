package com.udacity.gradle.builditbigger.paid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button btn_tell_joke= (Button) root.findViewById(R.id.btn_tell_joke);
        btn_tell_joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    tellJoke();
            }
        });
        return root;
    }

    public void tellJoke() {
        ((MainActivity)getActivity()).tellJoke();
    }
}
