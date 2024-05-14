package com.example.fitnesstracker_extra;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculate(View view) {
        EditText cycle = findViewById(R.id.cycle);
        TextView cycle_show = findViewById(R.id.cycleview);
        String cycleText = cycle.getText().toString();
        int cycle_int = Integer.parseInt(cycleText)*1020;
        cycle_show.setText(String.valueOf(cycle_int) + " cal");


        EditText walk = findViewById(R.id.walk);
        TextView walk_show = findViewById(R.id.walkview);
        String walkText = walk.getText().toString();
        int walk_int = Integer.parseInt(walkText)*534;
        walk_show.setText(String.valueOf(walk_int) + " cal");

        EditText gym = findViewById(R.id.gym);
        TextView gym_show = findViewById(R.id.gymview);
        String gymText = gym.getText().toString();
        int gym_int = Integer.parseInt(gymText)*234;
        gym_show.setText(String.valueOf(gym_int) + " cal");

        TextView total_show = findViewById(R.id.totalcal);
        int total = gym_int + walk_int + cycle_int;
        total_show.setText("Total Calories Burned: " + String.valueOf(total));
    }
}