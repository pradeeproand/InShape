package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class detailsInfo extends AppCompatActivity {

    GifImageView gifImageView;
    TextView title,description,play;

    String data1,data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);

        gifImageView = findViewById(R.id.exercise_gif);
        title = findViewById(R.id.exercise_title);
        description = findViewById(R.id.exercise_description_details);
        play = findViewById(R.id.play_button);

        getdata();
        setdata();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), detailVideo.class);
                intent.putExtra("title",data1);
                startActivity(intent);
            }
        });

    }
    private void getdata()
    {
        if(getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("myimages"))
        {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("myimages", 1);
        }
        else
        {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
    }
    private void setdata()
    {
           title.setText(data1);
           description.setText(data2);
           gifImageView.setImageResource(images);

    }
}
