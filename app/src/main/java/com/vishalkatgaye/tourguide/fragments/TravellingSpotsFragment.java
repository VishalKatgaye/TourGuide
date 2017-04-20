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
import com.vishalkatgaye.tourguide.travelling.AndhalgaonActivity;
import com.vishalkatgaye.tourguide.travelling.GaimukhActivity;
import com.vishalkatgaye.tourguide.travelling.IndirasagarActivity;
import com.vishalkatgaye.tourguide.travelling.RawanvadiActivity;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class TravellingSpotsFragment extends Fragment {

    /* Default constructor*/
    public TravellingSpotsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        /* Will add various travelling spots in ArrayList.*/
        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(getString(R.string.andhalgaon), R.drawable.andhalgaon));
        places.add(new Places(getString(R.string.gaimukh), R.drawable.gaimukh));
        places.add(new Places(getString(R.string.indirasagar), R.drawable.indirasagar_dam));
        places.add(new Places(getString(R.string.rawanvadi), R.drawable.rawanvadi));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places, R.color.deep_orange);
        ListView playView = (ListView) rootView.findViewById(R.id.list);
        playView.setAdapter(placesAdapter);

        playView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), AndhalgaonActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getActivity(), GaimukhActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getActivity(), IndirasagarActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getActivity(), RawanvadiActivity.class);
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