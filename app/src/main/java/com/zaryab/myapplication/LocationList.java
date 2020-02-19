package com.zaryab.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.zaryab.myapplication.Interface.ItemClickListener;
import com.zaryab.myapplication.Model.Location;
import com.zaryab.myapplication.Model.Place;

import com.zaryab.myapplication.ViewHolder.LocationViewHolder;
import com.zaryab.myapplication.ViewHolder.PlaceViewHolder;

public class LocationList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference locationList;

    String placeId = "";
    FirebaseRecyclerAdapter<Location, LocationViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // firebase
        database = FirebaseDatabase.getInstance();
        locationList = database.getReference("Location");

        locationList.keepSynced(true);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_location);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // get Intent here
        if (getIntent() !=null)
            placeId =  getIntent().getStringExtra("PlaceId");
        if(!placeId.isEmpty() && placeId != null)
        {
            loadLocationList(placeId);
        }
    }

    private void loadLocationList(String placeId) {
           adapter = new FirebaseRecyclerAdapter<Location, LocationViewHolder>(
                   Location.class,
                   R.layout.location_item,
                   LocationViewHolder.class,
                   locationList.orderByChild("menuId").equalTo(placeId)
           ) {
               @Override
               protected void populateViewHolder(final LocationViewHolder viewHolder, final Location model, int position) {
                    viewHolder.location_Name.setText(model.getName());
                    viewHolder.location_Description.setText(model.getDescription());
//                   Picasso.with(getBaseContext()).load(model.getImage())
//                           .into(viewHolder.location_image);



                   Picasso.with(getBaseContext()).load(model.getImage()).networkPolicy(NetworkPolicy.OFFLINE)
                           .into(viewHolder.location_image, new Callback() {
                       @Override
                       public void onSuccess() {

                       }

                       @Override
                       public void onError() {
                           Picasso.with(getBaseContext()).load(model.getImage()).into(viewHolder.location_image);
                       }
                   });


                   final Location local =  model;
                   viewHolder.setItemClickListener(new ItemClickListener() {
                       @Override
                       public void OnClick(View view, int position, boolean isLongClick) {
                           Intent locDetail = new Intent(LocationList.this,LocationDetail.class);
                           locDetail.putExtra("LocationId",adapter.getRef(position).getKey());
                           startActivity(locDetail);

                       }
                   });
               }
           };

           recyclerView.setAdapter(adapter);
    }


}
