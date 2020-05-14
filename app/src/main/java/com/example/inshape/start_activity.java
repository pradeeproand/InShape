package com.example.inshape;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class start_activity extends AppCompatActivity {

    int second,i=0;
    CountDownTimer countDownTimer;
    boolean timerRunning;
    private static final long tym_initial = 30000;
    long time_left = tym_initial;
    GifImageView gifImageView;
    TextView timer, teller,title_text;
    String[] title_array;
    int image[] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

        title_text = findViewById(R.id.title);
        gifImageView = findViewById(R.id.exercise_gif_start);
        timer = findViewById(R.id.timer);
        teller = findViewById(R.id.teller);
        title_array = getResources().getStringArray(R.array.exercise_name_tonned);

        if(getIntent().hasExtra("tonned"))
        {
            tonned td = new tonned();
            image = td.myimage;
            title_array = getResources().getStringArray(R.array.exercise_name_tonned);
            teller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent_fuction(title_array, image);
                }
            });
        }
        else if(getIntent().hasExtra("bulk"))
        {
            bulk bk = new bulk();
            image = bk.myimage;
            title_array = getResources().getStringArray(R.array.exercise_name_bulk);
            teller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent_fuction(title_array, image);
                }
            });
        }
        else if(getIntent().hasExtra("cut"))
        {
            cut ct =new cut();
            image = ct.myimage;
            title_array = getResources().getStringArray(R.array.exercise_name_cut);
            teller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent_fuction(title_array, image);
                }
            });
        }
        else if(getIntent().hasExtra("weightloss"))
        {
            weightloss wl = new weightloss();
            image = wl.fat_images;
            title_array = getResources().getStringArray(R.array.exercise_name_fat);
            teller.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent_fuction(title_array, image);
                }
            });
        }
    }

    public void intent_fuction(String title_array[], int image[])
    {
        final MediaPlayer mediaPlayer = MediaPlayer.create(start_activity.this, R.raw.beep);
        mediaPlayer.start();
        gifImageView.setImageResource(image[i]);
        title_text.setText(title_array[i]);
        starttym();
    }

    private void starttym()
    {
         countDownTimer =new CountDownTimer(time_left,1000) {
             @Override
             public void onTick(long millisUntilFinished) {
                 time_left = millisUntilFinished;
                 updateTym();

             }

             @Override
             public void onFinish() {
                 final MediaPlayer mediaPlayer = MediaPlayer.create(start_activity.this, R.raw.beep);
                 time_left = tym_initial;
                 i=i+1;
                 mediaPlayer.start();

             }
         }.start();
    }

    private void updateTym() {

         second = (int)(time_left/1000)%60;
        String sec = String.valueOf(second);
        timer.setText(sec);

    }

}
