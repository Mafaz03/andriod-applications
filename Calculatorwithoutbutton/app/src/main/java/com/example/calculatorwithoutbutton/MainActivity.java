package com.example.calculatorwithoutbutton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tres, tes;
    EditText editTextNumber5, editTextNumber6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tres = findViewById(R.id.tres);
        tes = findViewById(R.id.textView7);
        editTextNumber5 = findViewById(R.id.editTextNumber5);
        editTextNumber6 = findViewById(R.id.editTextNumber6);

        editTextNumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addNum();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        editTextNumber6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                addNum();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void addNum() {
        double n1, n2, result;
        String te = "Addition of two values is ";
        try {
            n1 = Double.parseDouble(editTextNumber5.getText().toString());
            n2 = Double.parseDouble(editTextNumber6.getText().toString());
            result = n1 + n2;
        } catch (Exception e) {
            e.printStackTrace();
            result = 0;
        }
        tres.setText(String.valueOf(result));
        tes.setText(String.valueOf(te));
    }
}
