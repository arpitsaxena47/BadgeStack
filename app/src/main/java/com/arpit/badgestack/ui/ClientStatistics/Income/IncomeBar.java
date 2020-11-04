package com.arpit.badgestack.ui.ClientStatistics.Income;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arpit.badgestack.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class IncomeBar extends AppCompatActivity {

    HorizontalBarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_bar);
        barChart = findViewById(R.id.BarChartVerticleIncome);
        getEntries();
        barDataSet = new BarDataSet(barEntries,  "Income in Millions" );
        barData = new BarData(barDataSet );
        barChart.setData(barData);
        Description description = new Description();
        description.setText("Income generated in various courses");
        barChart.setDescription(description);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextSize(20f);
        final String[] labels = new String[] {"Java", "Android Dev", "C++", "Java Adv.", "Machine Learning"  , "Personality Dev." , "Web Dev."};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        barChart.animateY(4000 );
    }
    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, 4 ));
        barEntries.add(new BarEntry(1f, 2 ));
        barEntries.add(new BarEntry(2f, 4));
        barEntries.add(new BarEntry(3f, 1));
        barEntries.add(new BarEntry(4f, 0.5f));
        barEntries.add(new BarEntry(4f, 1));
        barEntries.add(new BarEntry(4f, 2));
    }

}