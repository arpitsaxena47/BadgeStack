package com.arpit.badgestack.ui.showcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.arpit.badgestack.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ShowcaseActivity extends AppCompatActivity {

    //GridView Object
    private GridView gridView;
//    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef ;


    MyRecyclerViewAdapter adapter;
    public ArrayList<itemView> mData = new ArrayList<>();
    private String imageURL = "";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        gs://badgestack.appspot.com
        setContentView(R.layout.activity_showcase);

        recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false ));
        dataFeed();
        adapter = new MyRecyclerViewAdapter(this, mData);
//        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }
    public void dataFeed()
    {
//        storageRef = FirebaseStorage.getInstance().getReference().child("/badge.png");
//       storageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                String downloadUrl = uri.toString();
//                Log.i("TAGGG" , downloadUrl);
//            }
//        });

        for(int i = 0;i<5 ; i++) {
            itemView item = new itemView("https://firebasestorage.googleapis.com/v0/b/badgestack.appspot.com/o/badge.png?alt=media&token=431aa632-362d-4b78-9802-75eaf6613de0",
                    "Java Basic" + i, "HackerEarth" + i, "1-1-1");
            mData.add(item);
        }
//        https://firebasestorage.googleapis.com/v0/b/badgestack.appspot.com/o/badge2.png?alt=media&token=8549a7da-27be-456f-b94e-d7683ffa6d4e
    }
}