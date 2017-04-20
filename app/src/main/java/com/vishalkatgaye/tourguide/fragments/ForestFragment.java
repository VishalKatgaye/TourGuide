package com.vishalkatgaye.tourguide.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vishalkatgaye.tourguide.Places;
import com.vishalkatgaye.tourguide.R;
import com.vishalkatgaye.tourguide.adapter.PlacesAdapter;
import com.vishalkatgaye.tourguide.forest.KokaActivity;
import com.vishalkatgaye.tourguide.forest.NagziraActivity;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class ForestFragment extends Fragment {

    /* Default constructor*/
    public ForestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        /* Will add various forests in ArrayList.*/
        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(getString(R.string.koka), R.drawable.koka));
        places.add(new Places(getString(R.string.nagzira), R.drawable.nagzira_forest_reserve));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places, R.color.deep_orange);
        ListView playView = (ListView) rootView.findViewById(R.id.list);
        playView.setAdapter(placesAdapter);

        playView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), KokaActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getActivity(), NagziraActivity.class);
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}