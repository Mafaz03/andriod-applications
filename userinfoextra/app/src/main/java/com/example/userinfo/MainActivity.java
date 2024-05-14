package com.example.userinfo;

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

    public void submit(View view){
        EditText nameEdit = findViewById(R.id.nameText);
        String name = nameEdit.getText().toString();

        EditText ageEdit = findViewById(R.id.ageText);
        String age = ageEdit.getText().toString();

        EditText RRNEdit = findViewById(R.id.RRNText);
        String RRN = RRNEdit.getText().toString();

        TextView nameView = findViewById(R.id.nameView);
        TextView ageView = findViewById(R.id.ageView);
        TextView RRNView = findViewById(R.id.RRNView);

        nameView.setText("Name: " + name);
        ageView.setText("Age: " + age);
        RRNView.setText("RRN: " + RRN);

    }
}