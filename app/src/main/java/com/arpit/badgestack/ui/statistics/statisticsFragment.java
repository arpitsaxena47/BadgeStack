package com.arpit.badgestack.ui.statistics;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.arpit.badgestack.R;
import com.arpit.badgestack.ui.statistics.RankInCourses.RankInCoursesBar;
import com.arpit.badgestack.ui.statistics.Strength.StrengthVerticalBar;
import com.arpit.badgestack.ui.statistics.TimeDevotedPieChart.TimeDevotedPieChart;

public class statisticsFragment extends Fragment implements View.OnClickListener {
    Button leaderBoard;
    Button strength;
    Button timeDevoted;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        container.removeAllViews();
        View view = inflater.inflate(R.layout.activity_statistics, container, false);
        leaderBoard = view.findViewById(R.id.btnRank);
        strength = view.findViewById(R.id.btnMyStrength);
        timeDevoted = view.findViewById(R.id.btnTimeDevotedInCourses);

        leaderBoard.setOnClickListener(this::onClick);
        strength.setOnClickListener(this::onClick);
        timeDevoted.setOnClickListener(this::onClick);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnRank:
                Intent rankIntent = new Intent(getContext() , RankInCoursesBar.class);
                startActivity(rankIntent);
                break;

            case R.id.btnMyStrength:
                Intent strengthIntent = new Intent(getContext() , StrengthVerticalBar.class);
                startActivity(strengthIntent);
                break;

            case R.id.btnTimeDevotedInCourses:
                Intent timeDevotedIntent = new Intent(getContext() , TimeDevotedPieChart.class);
                startActivity(timeDevotedIntent);
                break;
        }
    }
}
