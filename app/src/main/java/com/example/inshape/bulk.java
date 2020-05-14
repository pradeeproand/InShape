package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bulk extends AppCompatActivity {

    Button start;
    RecyclerView recyclerView;
    String bulk1[],bulk2[];
    int myimage[] = {R.drawable.situps,R.drawable.air_bikes,R.drawable.crcns,R.drawable.crunches
            ,R.drawable.plank,R.drawable.leg_raise,R.drawable.side_plank,R.drawable.russian_twist,
            R.drawable.vups};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulk);

        recyclerView = findViewById(R.id.recyclerView);
        start = findViewById(R.id.start);
        bulk1 = getResources().getStringArray(R.array.exercise_name_bulk);
        bulk2 = getResources().getStringArray(R.array.exercise_description_bulk);

        MyAdapter myAdapter = new MyAdapter(this, bulk1, bulk2, myimage);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bulk.this, start_activity.class);
                intent.putExtra("bulk",true);
                startActivity(intent);
            }
        });
    }
}
