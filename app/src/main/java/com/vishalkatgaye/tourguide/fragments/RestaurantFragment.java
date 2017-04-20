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
import com.vishalkatgaye.tourguide.restaurant.AppleActivity;
import com.vishalkatgaye.tourguide.restaurant.KambhojActivity;
import com.vishalkatgaye.tourguide.restaurant.RanatBhavarActivity;
import com.vishalkatgaye.tourguide.restaurant.RoyalPlazaActivity;
import com.vishalkatgaye.tourguide.restaurant.TuliSuitActivity;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class RestaurantFragment extends Fragment {

    /* Default constructor*/
    public RestaurantFragment() {
    }

    @SuppressWarnings("deprecation")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list, container, false);

        /* Will add various restaurants in ArrayList.*/
        final ArrayList<Places> places = new ArrayList<>();
        places.add(new Places(getString(R.string.apple_restaurent), R.drawable.apple_restaurant));
        places.add(new Places(getString(R.string.kambhoj), R.drawable.kambhoj_foods));
        places.add(new Places(getString(R.string.ranat_bhavar), R.drawable.ranat_bhavar));
        places.add(new Places(getString(R.string.royal_plaza), R.drawable.hotel_royal_plaza));
        places.add(new Places(getString(R.string.tuli_suit), R.drawable.tuli_suits_sakoli));

        PlacesAdapter placesAdapter = new PlacesAdapter(getActivity(), places, R.color.deep_orange);
        ListView playView = (ListView) rootView.findViewById(R.id.list);
        playView.setAdapter(placesAdapter);

        playView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), AppleActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getActivity(), KambhojActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getActivity(), RanatBhavarActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getActivity(), RoyalPlazaActivity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getActivity(), TuliSuitActivity.class);
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