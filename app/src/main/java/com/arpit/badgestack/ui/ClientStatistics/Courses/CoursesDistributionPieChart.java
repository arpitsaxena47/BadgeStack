package com.arpit.badgestack.ui.ClientStatistics.Courses;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.arpit.badgestack.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class CoursesDistributionPieChart extends AppCompatActivity {

    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList<PieEntry> pieEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_distribution_pie_chart);
        pieChart = findViewById(R.id.pieChartCourseDistribution);
        getEntries();
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setSliceSpace(5f);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieChart.setDrawEntryLabels(false);
        pieDataSet.setValueTextSize(20f);
        pieDataSet.setSliceSpace(5f);
        pieChart.setCenterText("Courses Distribution Among No. of Students");
        pieChart.setCenterTextColor(Color.MAGENTA);
        pieChart.setCenterTextSize(30f);
        pieChart.animateXY(2000 , 2000);
    }
    private void getEntries() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(40000, "Java Basic",0 ));
        pieEntries.add(new PieEntry(30000, "C++",1));
        pieEntries.add(new PieEntry(10000, "Web development",2));
        pieEntries.add(new PieEntry(10000, "Java Advanced",3));
        pieEntries.add(new PieEntry(5000,"Android Development", 4));
        pieEntries.add(new PieEntry(4000,"Machine learning", 6));

    }
}