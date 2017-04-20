package com.vishalkatgaye.tourguide.forest;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vishalkatgaye.tourguide.R;

import static com.vishalkatgaye.tourguide.R.id.place_information;
import static com.vishalkatgaye.tourguide.R.id.place_title;

/**
 * Created by ViSh on 11-04-2017.
 */

public class NagziraActivity extends AppCompatActivity {

    private ImageView mBackground_Image;
    private TextView mPlace_Information;
    private TextView mPlace_Title;
    private TextView mTime_View;
    private ImageButton mMailButton;
    private Uri mImageUri;

    /* It will navigate to previous fragment by selecting menu item from status bar*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent parentIntent = NavUtils.getParentActivityIntent(this);
                if(parentIntent == null) {
                    finish();
                    return true;
                } else {
                    parentIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(parentIntent);
                    finish();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

//        Set the timing of place
        mTime_View = (TextView)findViewById(R.id.time_view);
        mTime_View.setText(getString(R.string.nagzira_timing));

//        Set title of the place.
        mPlace_Title = (TextView)findViewById(place_title);
        mPlace_Title.setText(getString(R.string.nagzira));

//        Insert text for specific place information.
        mPlace_Information = (TextView)findViewById(place_information);
        mPlace_Information.setText(getString(R.string.nagzira_info));

//        Select image for ImageView by using picasso library.
        mBackground_Image = (ImageView) findViewById(R.id.place_image);
        Picasso.with(this).load(R.drawable.nagzira_forest_reserve).into(mBackground_Image);

//        Share the contents of this activity.
        mMailButton = (ImageButton)findViewById(R.id.share_image);
        mMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.nagzira_forest_reserve);
                Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
                shareIntent.setType("image/png");
                shareIntent.setData(Uri.parse("mailto:"));
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.nagzira));
                shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.nagzira_info));
                shareIntent.putExtra(Intent.EXTRA_STREAM, mImageUri);
                try{
                    startActivity(shareIntent);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(), " Messanger have not been initialized",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        This will make status bar transparent.
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}