package com.example.inshape;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tonned extends AppCompatActivity {

    Button start;
    String T="tonned";
    RecyclerView recyclerView;
    String tonned1[],tonned2[];
    int myimage[] = {R.drawable.chest_shoulder_stretches,R.drawable.shoulder_rotation,R.drawable.incline_dumbbell_press
    ,R.drawable.dumbbell_lateral_raise,R.drawable.dumbbell_rear_lateral_raise,R.drawable.dumbbell_alt_lateral_raise
    ,R.drawable.dumbbell_seated_shoulder_press,R.drawable.dumbbell_standing_alt_raisdw};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonned);

        recyclerView = findViewById(R.id.recyclerView);
        start = findViewById(R.id.start);
        tonned1 = getResources().getStringArray(R.array.exercise_name_tonned);
        tonned2 = getResources().getStringArray(R.array.exercise_description_tonned);

        MyAdapter myAdapter = new MyAdapter(this, tonned1, tonned2, myimage);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tonned.this, start_activity.class);
                intent.putExtra("tonned",true);
                startActivity(intent);
            }
        });



    }
}
