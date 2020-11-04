package com.arpit.badgestack.ui.timeline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.arpit.badgestack.R;
import com.arpit.badgestack.ui.showcase.MyRecyclerViewAdapter;
import com.arpit.badgestack.ui.showcase.itemView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {
    TimelineAdapter adapter;
    RecyclerView timelineRecyclerView;
    ArrayList<TimelineItemView> names = new ArrayList<>();
    StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        timelineRecyclerView = findViewById(R.id.timelineRecyclerView);
        timelineRecyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false ));
        names.add(new TimelineItemView("Hacker Earth" , Color.GREEN ));
//        adapter = new TimelineAdapter(this,names);
//        timelineRecyclerView.setAdapter(adapter);

//        timelineRecyclerView.setLayoutManager(new GridLayoutManager(this , 3));
        names.add(new TimelineItemView("Java Basic" , Color.CYAN ));
        names.add(new TimelineItemView("C++ Basic" , Color.CYAN));
        names.add(new TimelineItemView("Python Basic" , Color.CYAN));
        adapter = new TimelineAdapter(this,names);
//        adapter.setClickListener(this);
        adapter = new TimelineAdapter(this,names);
        timelineRecyclerView.setAdapter(adapter);

    }

}