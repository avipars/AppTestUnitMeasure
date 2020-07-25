package com.eliorcohen.apptest.AdaptersPackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.eliorcohen.apptest.R;

public class RVAdapterHolder extends RecyclerView.ViewHolder {

    public TextView textRV;
    public ImageView imageRV;

    public RVAdapterHolder(View itemView) {
        super(itemView);

        textRV = itemView.findViewById(R.id.textRV);;
        imageRV = itemView.findViewById(R.id.imageRV);;
    }

}
