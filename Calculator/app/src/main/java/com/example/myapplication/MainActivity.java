package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvRes, tv;
    EditText editTextNumber, editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRes = findViewById(R.id.textView14);
        tv = findViewById(R.id.textView15);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
    }

    public void addNumber(View v) {
        double n1, n2, result;
        String te = "Addition of two values is";
        n1 = Double.parseDouble(editTextNumber.getText().toString());
        n2 = Double.parseDouble(editTextNumber2.getText().toString());
        result = n1 + n2;
        tvRes.setText(String.valueOf(result));
        tv.setText(String.valueOf(te));
    }

    public void subNumber(View v) {
        double n1, n2, result;
        String te = "Subtraction of two values is";
        n1 = Double.parseDouble(editTextNumber.getText().toString());
        n2 = Double.parseDouble(editTextNumber2.getText().toString());
        result = n1 - n2;
        tvRes.setText(String.valueOf(result));
        tv.setText(String.valueOf(te));
    }

    public void mulNumber(View v) {
        double n1, n2, result;
        String te = "Mul of two values is";
        n1 = Double.parseDouble(editTextNumber.getText().toString());
        n2 = Double.parseDouble(editTextNumber2.getText().toString());
        result = n1 * n2;
        tvRes.setText(String.valueOf(result));
        tv.setText(String.valueOf(te));
    }

    public void divNumber(View v) {
        double n1, n2, result;
        String te = "Division of two values is";
        n1 = Double.parseDouble(editTextNumber.getText().toString());
        n2 = Double.parseDouble(editTextNumber2.getText().toString());
        result = n1 / n2;
        tvRes.setText(String.valueOf(result));
        tv.setText(String.valueOf(te));
    }
}
