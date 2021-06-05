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

public class UserDataRecyclerViewAdapter extends RecyclerView.Adapter<UserDataRecyclerViewAdapter.MyViewHolder> {
    private ArrayList<UserDataRecyclerViewContent> dataList;
    private Context mContext;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView userData;


        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title_text_id);
            userData = view.findViewById(R.id.data_text_id);

        }
    }
    public UserDataRecyclerViewAdapter(ArrayList<UserDataRecyclerViewContent> dataList1) {
        this.dataList = dataList1;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_data_layout, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final UserDataRecyclerViewContent cardContent = dataList.get(position);
        holder.title.setText(cardContent.getDataTitle());
        holder.userData.setText(cardContent.getUserData());
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
