package com.arpit.badgestack.ui.timeline;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arpit.badgestack.R;
import com.arpit.badgestack.ui.showcase.MyRecyclerViewAdapter;
import com.arpit.badgestack.ui.showcase.itemView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    private ArrayList<TimelineItemView> names ;
    private LayoutInflater mInflater;

    // Data is passed into the constructor
    public TimelineAdapter(Context context, ArrayList<TimelineItemView> names) {
        this.mInflater = LayoutInflater.from(context);
        this.names = names;
    }

    // Inflates the cell layout from xml when needed
    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.timeline_item, parent, false);
        TimelineViewHolder viewHolder = new TimelineViewHolder(view);
        return viewHolder;
    }

    // Binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(TimelineAdapter.TimelineViewHolder holder, int position) {
        String nameOfItem = names.get(position).getItemName();
        int color = names.get(position).getColor();

        holder.txtName.setText(nameOfItem);
        holder.txtName.setBackgroundColor(color);


    }

    // Total number of cells
    @Override
    public int getItemCount() {
        return names.size();
    }

    // Stores and recycles views as they are scrolled off screen
    public class TimelineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtName;



        public TimelineViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView) itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            onItemClick(view, getAdapterPosition());
        }
    }

}
