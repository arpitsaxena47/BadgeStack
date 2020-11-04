package com.arpit.badgestack.ui.ClientStatistics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arpit.badgestack.R;
import com.arpit.badgestack.ui.ClientStatistics.Courses.CoursesDistributionPieChart;
import com.arpit.badgestack.ui.ClientStatistics.Income.IncomeBar;
import com.arpit.badgestack.ui.statistics.RankInCourses.RankInCoursesBar;

public class ClientStatistics extends Fragment implements View.OnClickListener {
    Button courses;
    Button income;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        container.removeAllViews();
        View view = inflater.inflate(R.layout.activity_client_statistics, container, false);
        courses = view.findViewById(R.id.courses);
        income = view.findViewById(R.id.income);


        courses.setOnClickListener(this::onClick);
        income.setOnClickListener(this::onClick);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.courses:
                Intent rankIntent = new Intent(getContext() , CoursesDistributionPieChart.class);
                startActivity(rankIntent);
                break;

            case R.id.income:
                Intent strengthIntent = new Intent(getContext() , IncomeBar.class);
                startActivity(strengthIntent);
                break;

        }
    }
}