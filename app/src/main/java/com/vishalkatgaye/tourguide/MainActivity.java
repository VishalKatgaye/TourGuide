package com.vishalkatgaye.tourguide;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.vishalkatgaye.tourguide.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity
        implements ComponentCallbacks2 {

    /**
     * Release memory when the UI becomes hidden or when system resources become low.
     *
     * @param level the memory-related event that was raised.
     */
    @Override
    public void onTrimMemory(int level) {

//        Determine which lifecycle or system event was raised.
        switch (level) {
            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                /**
                 * Release any UI objects that currently hold memory.
                 * The user interface has moved to the background. */
                break;

            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
                /**
                 *  Release any memory that your app doesn't need to run.
                 *  The device is running low on memory while the app is running.
                 *  The event raised indicates the severity of the memory-related event.
                 *  If the event is TRIM_MEMORY_RUNNING_CRITICAL, then the system will
                 *  begin killing background processes.
                 */
                break;

            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:

                /**
                 *  Release as much memory as the process can.
                 *  The app is on the LRU list and the system is running low on memory.
                 *  The event raised indicates where the app sits within the LRU list.
                 *  If the event is TRIM_MEMORY_COMPLETE, the process will be one of
                 *  the first to be terminated.*/
                break;

            default:
                /**
                 *  Release any non-critical data structures.
                 *  The app received an unrecognized memory level value
                 *  from the system. Treat this as a generic low-memory message.*/
                break;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager and tab layout that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        PagerAdapter adapter = new PagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Set tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_view);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.deep_orange));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}