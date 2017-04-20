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
import com.vishalkatgaye.tourguide.historical_places.AmbagarhActivity;
import com.vishalkatgaye.tourguide.historical_places.OldBridgeActivity;
import com.vishalkatgaye.tourguide.historical_places.PandeMahalActivity;
import com.vishalkatgaye.tourguide.historical_places.SangadiFortActivity;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class HistoricalPlacesFragment extends Fragment {

    /* Default Constructor */
    public HistoricalPlacesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        /* Will add various historical places in ArrayList.*/
        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(getString(R.string.ambagarh_fort), R.drawable.ambagar_fort));
        places.add(new Places(getString(R.string.bhandara_old_bridge), R.drawable.old_bridge));
        places.add(new Places(getString(R.string.pandey_mahal), R.drawable.pande_mahal));
        places.add(new Places(getString(R.string.sangadi_fort), R.drawable.sangadi_fort));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places, R.color.deep_orange);
        ListView playView = (ListView) rootView.findViewById(R.id.list);
        playView.setAdapter(placesAdapter);

        playView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), AmbagarhActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getActivity(), OldBridgeActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getActivity(), PandeMahalActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getActivity(), SangadiFortActivity.class);
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