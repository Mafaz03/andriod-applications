package com.example.database;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
    EditText RRN, Name, CGPA;
    Button Insert, Delete, Update, View, ViewAll;
    SQLiteDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RRN = findViewById(R.id.RRN);
        Name = findViewById(R.id.Name);
        CGPA = findViewById(R.id.CGPA);
        Insert = findViewById(R.id.Insert);
        Delete = findViewById(R.id.Delete);
        Update = findViewById(R.id.Update);
        View = findViewById(R.id.View);
        ViewAll = findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);

        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rrn VARCHAR, name VARCHAR, cgpa VARCHAR);");
    }

    public void onClick(View view) {
        if (view == Insert) {
            String rrnValue = RRN.getText().toString();
            String nameValue = Name.getText().toString();
            String cgpaValue = CGPA.getText().toString();

            if (rrnValue.isEmpty() || nameValue.isEmpty() || cgpaValue.isEmpty()) {
                showMessage("Error", "Please enter all values");
                return;
            }

            db.execSQL("INSERT INTO student(rrn, name, cgpa) VALUES('" + rrnValue + "','" + nameValue + "','" + cgpaValue + "')");
            showMessage("Success", "Record added");
            clearText();
        }
        else if (view == Delete) {
            String rrnValue = RRN.getText().toString();
            if (rrnValue.isEmpty()) {
                showMessage("Error", "Please enter RRN");
                return;
            }

            Cursor c = db.rawQuery("SELECT * FROM student WHERE rrn='" + rrnValue + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM student WHERE rrn='" + rrnValue + "'");
                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid RRN");
            }
            clearText();
        }
        // Similarly, add logic for Update, View, and ViewAll
        else if (view == View) {
            // View logic
            String rrnValue = RRN.getText().toString();
            if (rrnValue.isEmpty()) {
                showMessage("Error", "Please enter RRN");
                return;
            }

            Cursor c = db.rawQuery("SELECT * FROM student WHERE rrn='" + rrnValue + "'", null);
            if (c.moveToFirst()) {
                Name.setText(c.getString(1));
                CGPA.setText(c.getString(2));
            } else {
                showMessage("Error", "Invalid RRN");
                clearText();
            }
        }
        else if (view == ViewAll) {
            // ViewAll logic
            Cursor c = db.rawQuery("SELECT * FROM student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("RRN: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("CGPA: " + c.getString(2) + "\n\n");
            }
            showMessage("Student Details", buffer.toString());
            }
        }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        RRN.setText("");
        Name.setText("");
        CGPA.setText("");
        RRN.requestFocus();
    }
}
