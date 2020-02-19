package com.zaryab.myapplication.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zaryab.myapplication.Interface.ItemClickListener;
import com.zaryab.myapplication.R;

public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView location_Name;
    public TextView location_Description;
    public ImageView location_image;

    private ItemClickListener itemClickListener;




    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);

        location_Name = (TextView) itemView.findViewById(R.id.location_name);
        location_image = (ImageView) itemView.findViewById(R.id.location_image);
        location_Description = (TextView) itemView.findViewById(R.id.location_description);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.OnClick(view, getAdapterPosition(),false);
    }
}
