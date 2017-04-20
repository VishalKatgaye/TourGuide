package com.vishalkatgaye.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView welcomeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeImage = (ImageView) findViewById(R.id.welcome_image);
        welcomeImage.setScaleType(ImageView.ScaleType.FIT_XY);
        Picasso.with(this).load(R.drawable.welcome).into(welcomeImage);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1300);  //Delay of 1.3 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(WelcomeActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}