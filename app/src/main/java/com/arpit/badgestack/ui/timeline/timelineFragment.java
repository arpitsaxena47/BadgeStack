package com.arpit.badgestack.ui.timeline;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arpit.badgestack.R;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class timelineFragment extends Fragment {
    TimelineAdapter adapter;
    RecyclerView timelineRecyclerView;
    ArrayList<TimelineItemView> names = new ArrayList<>();
    StorageReference storageRef;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        container.removeAllViews();
        View view =  inflater.inflate(R.layout.activity_timeline, container, false);
        timelineRecyclerView = view.findViewById(R.id.timelineRecyclerView);
        timelineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false ));
        names.add(new TimelineItemView("Hacker Earth" , Color.GREEN ));
//        adapter = new TimelineAdapter(this,names);
//        timelineRecyclerView.setAdapter(adapter);

//        timelineRecyclerView.setLayoutManager(new GridLayoutManager(this , 3));
        names.add(new TimelineItemView("Java Basic" , Color.CYAN ));
        names.add(new TimelineItemView("C++ Basic" , Color.CYAN));
        names.add(new TimelineItemView("Python Basic" , Color.CYAN));
        adapter = new TimelineAdapter(getContext(),names);
//        adapter.setClickListener(this);
        adapter = new TimelineAdapter(getContext(),names);
        timelineRecyclerView.setAdapter(adapter);
        return view;
    }
}
