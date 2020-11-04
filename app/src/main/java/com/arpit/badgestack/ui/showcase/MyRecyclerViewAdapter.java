package com.arpit.badgestack.ui.showcase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.arpit.badgestack.ItemClickView;
import com.arpit.badgestack.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<itemView> mData ;
    private LayoutInflater mInflater;

    // Data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, ArrayList<itemView> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // Inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String imageUrl  = mData.get(position).getImageUrl();
        String badgeName = mData.get(position).getBadgeName();
        String companyName = mData.get(position).getCompanyName();
        String dateOfIssue = mData.get(position).getDateOfIssue();

        Picasso.get().load(imageUrl).into(holder.imgBadge);
        holder.txtBadgeName.setText(badgeName);
        holder.txtCompanyName.setText(companyName);
        holder.txtDateOfIssue.setText(dateOfIssue);
    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtBadgeName;
        public TextView txtCompanyName;
        public TextView txtDateOfIssue;
        public ImageView imgBadge;
        private  Context context;


        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            txtBadgeName = (TextView) itemView.findViewById(R.id.txtBadgeName);
            txtCompanyName = (TextView) itemView.findViewById(R.id.txtcompanyName);
            txtDateOfIssue = (TextView) itemView.findViewById(R.id.txtDate);
          imgBadge = (ImageView)itemView.findViewById(R.id.imgBadge);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            onItemClick(view, getAdapterPosition());
            Intent intent = new Intent(context , ItemClickView.class);
            intent.putExtra("imageURL" , mData.get(getAdapterPosition()).imageUrl);
            intent.putExtra("badgeName" , mData.get(getAdapterPosition()).badgeName);
            intent.putExtra("companyName" , mData.get(getAdapterPosition()).companyName);
            intent.putExtra("issueDate" , mData.get(getAdapterPosition()).dateOfIssue);
            context.startActivity(intent);
        }

    }

//     Convenience method for getting data at click position
    public itemView getItem(int id) {
        return mData.get(id);
    }

//     Method that executes your code for the action received
    public void onItemClick(View view, int position) {

    }
}
