package com.example.expensetracker_extra;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.expensetracker_extra.R;

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
        EditText cycle_name = findViewById(R.id.cycletext);
        String cycle_name_Text = cycle_name.getText().toString();
        int cycle_name_int = Integer.parseInt(cycle_name_Text);

        EditText cycle = findViewById(R.id.cycle);
        TextView cycle_show = findViewById(R.id.cycleview);
        String cycleText = cycle.getText().toString();
        int cycle_int = Integer.parseInt(cycleText)*cycle_name_int;
        cycle_show.setText(String.valueOf(cycle_int) + " rps");

//      ========================
        EditText walk_name = findViewById(R.id.walktext);
        String walk_name_Text = walk_name.getText().toString();
        int walk_name_int = Integer.parseInt(walk_name_Text);

        EditText walk = findViewById(R.id.walk);
        TextView walk_show = findViewById(R.id.walkview);
        String walkText = walk.getText().toString();
        int walk_int = Integer.parseInt(walkText)*walk_name_int;
        walk_show.setText(String.valueOf(walk_int) + " rps");


        //      ========================
        EditText gym_name = findViewById(R.id.gymtext);
        String gym_name_Text = gym_name.getText().toString();
        int gym_name_int = Integer.parseInt(gym_name_Text);

        EditText gym = findViewById(R.id.gym);
        TextView gym_show = findViewById(R.id.gymview);
        String gymText = gym.getText().toString();
        int gym_int = Integer.parseInt(gymText)*gym_name_int;
        gym_show.setText(String.valueOf(gym_int) + " rps");

        TextView total_show = findViewById(R.id.totalcal);
        int total = gym_int + walk_int + cycle_int;
        total_show.setText("Total Expense: " + String.valueOf(total));
    }
}