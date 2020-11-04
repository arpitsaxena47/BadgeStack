package com.arpit.badgestack.ui.statistics.RankInCourses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.arpit.badgestack.R;

public class RankInCoursesBar extends AppCompatActivity {
    TextView row1txt1;
    TextView row1txt2;
    TextView row1txt3;
    TextView row2txt1;
    TextView row2txt2;
    TextView row2txt3;
    TextView row3txt1;
    TextView row3txt2;
    TextView row3txt3;
    TextView row4txt1;
    TextView row4txt2;
    TextView row4txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank_in_courses_bar);
        row1txt1 = findViewById(R.id.row1txt1);
        row1txt2 = findViewById(R.id.row1txt2);
        row1txt3 = findViewById(R.id.row1txt3);
        row2txt1 = findViewById(R.id.row2txt1);
        row2txt2 = findViewById(R.id.row2txt2);
        row2txt3 = findViewById(R.id.row2txt3);
        row3txt1 = findViewById(R.id.row3txt1);
        row3txt2 = findViewById(R.id.row3txt2);
        row3txt3 = findViewById(R.id.row3txt3);
        row4txt1 = findViewById(R.id.row4txt1);
        row4txt2 = findViewById(R.id.row4txt2);
        row4txt3 = findViewById(R.id.row4txt3);


       row2txt1.setText("Arpit Saxena");
       row3txt1.setText("Shubham Singla");
       row4txt1.setText("Lovekesh Dhanda");

       row2txt2.setText("1");
       row3txt2.setText("2");
       row4txt2.setText("3");

       row2txt3.setText("95.5");
       row3txt3.setText("89.6");
       row4txt3.setText("80.0");

    }
}