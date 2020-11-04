package com.arpit.badgestack.ui.showcase;

import android.content.Intent;
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

import java.util.ArrayList;

public class showcaseFragment extends Fragment {


    MyRecyclerViewAdapter adapter;
    public ArrayList<itemView> mData = new ArrayList<>();
    private String imageURL = "";
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        container.removeAllViews();
        View view =  inflater.inflate(R.layout.activity_showcase, container, false);
        recyclerView = view.findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false ));
        dataFeed();
        adapter = new MyRecyclerViewAdapter(getContext(), mData);
//        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void dataFeed()
    {

        for(int i = 0;i<3 ; i++) {
            itemView item1 = new itemView("https://firebasestorage.googleapis.com/v0/b/badgestack.appspot.com/o/badge.png?" +
                    "alt=media&token=431aa632-362d-4b78-9802-75eaf6613de0",
                    "Java Basic" + i, "HackerEarth" + i, "1-1-1");
            mData.add(item1);

            itemView item2 = new itemView("https://firebasestorage.googleapis.com/v0/b/badgestack.appspot.com/o/badge2.png?" +
                    "alt=media&token=8549a7da-27be-456f-b94e-d7683ffa6d4e",
                    "Java Basic" + i, "HackerEarth" + i, "1-1-1");
            mData.add(item2);

            itemView item3 = new itemView("https://firebasestorage.googleapis.com/v0/b/badgestack.appspot.com/o/ribbon.png" +
                    "?alt=media&token=f8c46626-19dc-4e73-aba7-23887f053f65",
                    "Java Basic" + i, "HackerEarth" + i, "1-1-1");
            mData.add(item3);
        }

    }

}



