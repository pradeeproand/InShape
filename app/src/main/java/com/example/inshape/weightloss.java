package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

public class weightloss extends AppCompatActivity {

    Button start;
    RecyclerView recyclerView;
    String fat1[],fat2[];
    int fat_images[] = {R.drawable.barbell_bicep_curl, R.drawable.hammer_curl, R.drawable.daimond_pushup, R.drawable.close_grip_pushup,
    R.drawable.decline_triceps, R.drawable.triceps_kickback, R.drawable.plank, R.drawable.reverse_plank};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weightloss);

        recyclerView = findViewById(R.id.recyclerView);
        start = findViewById(R.id.start);

        fat1 = getResources().getStringArray(R.array.exercise_name_fat);
        fat2 = getResources().getStringArray(R.array.exercise_description_fat);

        MyAdapter myAdapter = new MyAdapter(this, fat1, fat2, fat_images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weightloss.this, start_activity.class);
                intent.putExtra("weightloss",true);
                startActivity(intent);
            }
        });


    }
}
