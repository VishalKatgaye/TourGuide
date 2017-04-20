package com.vishalkatgaye.tourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vishalkatgaye.tourguide.fragments.HistoricalPlacesFragment;

/**
 * Created by ViSh on 13-04-2017.
 */

public class HistoricalPlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new HistoricalPlacesFragment())
                .commit();
    }
}