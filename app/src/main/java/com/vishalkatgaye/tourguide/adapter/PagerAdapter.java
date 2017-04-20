package com.vishalkatgaye.tourguide.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vishalkatgaye.tourguide.R;
import com.vishalkatgaye.tourguide.fragments.HistoricalPlacesFragment;
import com.vishalkatgaye.tourguide.fragments.ForestFragment;
import com.vishalkatgaye.tourguide.fragments.RestaurantFragment;
import com.vishalkatgaye.tourguide.fragments.ShoppingFragment;
import com.vishalkatgaye.tourguide.fragments.TravellingSpotsFragment;

/**
 * Created by ViSh on 03-04-2017.
 * <p>
 * PagerAdapter used to add pager views and tabs with title.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    /* Context of the app*/
    private Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment place = null;
        if (position == 0) {
            return place = new RestaurantFragment();
        }
        if (position == 1) {
            return place = new ShoppingFragment();
        }
        if (position == 2) {
            return place = new HistoricalPlacesFragment();
        }
        if (position == 3) {
            return place = new TravellingSpotsFragment();
        }
        if (position == 4) {
            return place = new ForestFragment();
        }
        return place;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String place = null;
        if (position == 0) {
            return place = mContext.getString(R.string.restaurant);
        }
        if (position == 1) {
            return place = mContext.getString(R.string.shop);
        }
        if (position == 2) {
            return place = mContext.getString(R.string.historical_place);
        }
        if (position == 3) {
            return place = mContext.getString(R.string.travel);
        }
        if (position == 4) {
            return place = mContext.getString(R.string.forest);
        }
        return place;
    }
}