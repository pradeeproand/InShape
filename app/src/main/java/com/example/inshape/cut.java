package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cut extends AppCompatActivity {

    Button start;
    RecyclerView recyclerView;
    String cut1[],cut2[];
    int myimage[] = {R.drawable.dynamic_chest_stretches,R.drawable.barbell_bench_press,R.drawable.bench_dumbell_press,R.drawable.barbell_incline_bench_press
    ,R.drawable.incline_dumbbell_press,R.drawable.dumbell_pullover,R.drawable.mountain_climber,R.drawable.chest_dips,
    R.drawable.wide_pushups};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut);

        recyclerView = findViewById(R.id.recyclerView);
        start = findViewById(R.id.start);

        cut1 = getResources().getStringArray(R.array.exercise_name_cut);
        cut2 = getResources().getStringArray(R.array.exercise_description_cut);

        MyAdapter myAdapter = new MyAdapter(this, cut1, cut2, myimage);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cut.this, start_activity.class);
                intent.putExtra("cut",true);
                startActivity(intent);
            }
        });
    }
}
