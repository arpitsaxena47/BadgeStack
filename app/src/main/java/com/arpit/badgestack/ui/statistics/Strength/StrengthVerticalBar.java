package com.arpit.badgestack.ui.statistics.Strength;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.arpit.badgestack.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class StrengthVerticalBar extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_vertical_bar);
        barChart = findViewById(R.id.BarChartVerticle);
        getEntries();
        barDataSet = new BarDataSet(barEntries,  "STRENGTH RATE OUT OF 5" );
        barData = new BarData(barDataSet );
        barChart.setData(barData);
        Description description = new Description();
        description.setText("Strength In Various Courses");
        barChart.setDescription(description);
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueTextSize(20f);
        final String[] labels = new String[] {"Java", "Android Dev", "C++", "Java Adv.", "Personality"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        barChart.animateY(2000);
    }
    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0f, 4 ));
        barEntries.add(new BarEntry(1f, 3 ));
        barEntries.add(new BarEntry(2f, 0.5f));
        barEntries.add(new BarEntry(3f, 2));
        barEntries.add(new BarEntry(4f, 3));
    }

}