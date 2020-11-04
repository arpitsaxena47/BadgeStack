package com.arpit.badgestack.ui.AssociatedIndustries;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arpit.badgestack.R;
import com.arpit.badgestack.ui.ClientStatistics.Courses.CoursesDistributionPieChart;
import com.arpit.badgestack.ui.ClientStatistics.Income.IncomeBar;

import java.util.ArrayList;

public class IndustriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        container.removeAllViews();
        return inflater.inflate(R.layout.activity_industries_fragment, container, false);

    }


}