package com.eliorcohen.apptest.AdaptersPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eliorcohen.apptest.R;
import com.eliorcohen.apptest.ModelsPackage.RVModel;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapterHolder> {

    private final LayoutInflater mInflater;
    private ArrayList<RVModel> rvModelArrayList;

    public RVAdapter(Context context, ArrayList<RVModel> rvModelArrayList) {
        mInflater = LayoutInflater.from(context);
        this.rvModelArrayList = rvModelArrayList;
    }

    @NonNull
    @Override
    public RVAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item_total, parent, false);
        return new RVAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RVAdapterHolder holder, final int position) {
        RVModel current = rvModelArrayList.get(position);
        holder.textRV.setText(current.getTextRV());
        try {
            Glide.with(mInflater.getContext()).load(current.getImageRV()).into(holder.imageRV);
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        if (rvModelArrayList != null)
            return rvModelArrayList.size();
        else return 0;
    }

}
