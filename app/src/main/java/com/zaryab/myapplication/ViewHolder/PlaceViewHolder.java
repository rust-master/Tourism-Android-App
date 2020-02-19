package com.zaryab.myapplication.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zaryab.myapplication.Interface.ItemClickListener;
import com.zaryab.myapplication.R;

public class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtPlaceName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;


    public PlaceViewHolder(@NonNull View itemView) {
        super(itemView);

        txtPlaceName = (TextView) itemView.findViewById(R.id.place_name);
        imageView = (ImageView) itemView.findViewById(R.id.place_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.OnClick(view, getAdapterPosition(),false);
    }
}
