package com.geektech.firstarchitecturelesson.presentation.images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, new ImagesFragment())
                .commit();
    }
}
