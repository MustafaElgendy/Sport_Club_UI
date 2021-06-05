package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClubActivitiesAdapter extends RecyclerView.Adapter<ClubActivitiesAdapter.MyViewHolder> {
    private ArrayList<UserDataRecyclerViewContent> dataList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;


        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.activities_text_id);
            image = view.findViewById(R.id.activities_image);

        }
    }
    public ClubActivitiesAdapter(ArrayList<UserDataRecyclerViewContent> dataList1) {
        this.dataList = dataList1;
    }
    @NonNull
    @Override
    public ClubActivitiesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.acrivities_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubActivitiesAdapter.MyViewHolder holder, int position) {
        final UserDataRecyclerViewContent cardContent = dataList.get(position);
        holder.title.setText(cardContent.getDataTitle());
        holder.image.setImageResource(cardContent.getImage());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
