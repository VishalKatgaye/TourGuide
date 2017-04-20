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
import com.vishalkatgaye.tourguide.shopping.GandhiChaukActivity;
import com.vishalkatgaye.tourguide.shopping.SainathActivity;
import com.vishalkatgaye.tourguide.shopping.SindhiLaneActivity;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class ShoppingFragment extends Fragment {

    /* Default constructor*/
    public ShoppingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        /* Will add various shopping places in ArrayList.*/
        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(getString(R.string.gandhi_chauk), R.drawable.gandhi_chauk));
        places.add(new Places(getString(R.string.sainath_handloom), R.drawable.sainath_handloom));
        places.add(new Places(getString(R.string.sindhi_lane), R.drawable.sindhi_lane));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places, R.color.deep_orange);
        ListView playView = (ListView) rootView.findViewById(R.id.list);
        playView.setAdapter(placesAdapter);

        playView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), GandhiChaukActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getActivity(), SainathActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getActivity(), SindhiLaneActivity.class);
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