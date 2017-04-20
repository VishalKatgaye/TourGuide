package com.vishalkatgaye.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vishalkatgaye.tourguide.Places;
import com.vishalkatgaye.tourguide.R;

import java.util.ArrayList;

/**
 * Created by ViSh on 02-04-2017.
 */

public class PlacesAdapter extends ArrayAdapter<Places> {
    /**
     * Background color resource.
     **/
    private int mColorResourceId;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View home_view = convertView;

        final Places placesPosition = getItem(position);

        if (home_view == null) {
            home_view = LayoutInflater.from(getContext()).inflate(R.layout.places_list, parent, false);
        }

        TextView titleTextView = (TextView) home_view.findViewById(R.id.title_text);
        titleTextView.setText(placesPosition.getPlaceName());
        ImageView infoImageView = (ImageView) home_view.findViewById(R.id.image_area);

        if (placesPosition.hasImage()) {
//            infoImageView.setImageResource(placesPosition.getImagesResourceId());
            Picasso.with(getContext()).load(placesPosition.getImagesResourceId()).into(infoImageView);
            infoImageView.setVisibility(View.VISIBLE);
        } else {
            infoImageView.setVisibility(View.GONE);
        }

        /** Linear layout sets the theme color of places text */
        View placeContainer = home_view.findViewById(R.id.places_container);

        /* Find the color that resource id maps with */
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        /* Sets the background color*/
        placeContainer.setBackgroundColor(color);

        return home_view;
    }

    public PlacesAdapter(Context context, ArrayList<Places> place, int colorResourceId) {
        super(context, 0, place);
        mColorResourceId = colorResourceId;
    }
}