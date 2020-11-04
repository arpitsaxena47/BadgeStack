package com.arpit.badgestack.ui.statistics.TimeDevotedPieChart;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.arpit.badgestack.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class TimeDevotedPieChart extends AppCompatActivity {
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList<PieEntry> pieEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_devoted_pie_chart);
        pieChart = findViewById(R.id.pieChart);
        getEntries();
        pieDataSet = new PieDataSet(pieEntries, "hours");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(10f);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieChart.setEntryLabelColor(Color.BLACK);;
        pieDataSet.setValueTextSize(20f);
//        pieDataSet.setSliceSpace(5f);
        pieChart.setCenterText("Time Spent On Each Courses");
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterTextSize(30f);
        pieChart.animateXY(2000 , 2000);


    }
    private void getEntries() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(3, "Java Basic",0 ));
        pieEntries.add(new PieEntry(2, "Android Development",1));
        pieEntries.add(new PieEntry(0.5f, "C++",2));
        pieEntries.add(new PieEntry(1,"Java advanced", 3));
        pieEntries.add(new PieEntry(2, "Personality Development", 4));
    }
}