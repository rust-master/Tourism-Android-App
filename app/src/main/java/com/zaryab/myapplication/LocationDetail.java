package com.zaryab.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.zaryab.myapplication.Model.Location;
import com.zaryab.myapplication.ViewHolder.LocationViewHolder;

public class LocationDetail extends AppCompatActivity {


    TextView loc_name,loc_Descriptio;
    ImageView loc_Image ,  MainImage;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnShare;

    String locationId="";

    FirebaseDatabase database;
    DatabaseReference location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);

        // database
        database = FirebaseDatabase.getInstance();
        location = database.getReference("Location");


        location.keepSynced(true);

        // init
         btnShare = (FloatingActionButton) findViewById(R.id.btnshare);
         loc_Image = (ImageView) findViewById(R.id.img_location);
//        mapImage = (ImageView) findViewById(R.id.maps);
         loc_name = (TextView) findViewById(R.id.location_name);
         loc_Descriptio =(TextView) findViewById(R.id.location_description);




         btnShare.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String d  = loc_Descriptio.getText().toString();
                 Intent sendIntent = new Intent();
                 sendIntent.setAction(Intent.ACTION_SEND);
                 sendIntent.putExtra(Intent.EXTRA_TEXT, d);
                 sendIntent.setType("text/plain");
                 startActivity(sendIntent);
                 sendIntent.setPackage("com.whatsapp");
             }
         });

         collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
         collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
         collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

         if(getIntent() != null)
             locationId = getIntent().getStringExtra("LocationId");
         if(!locationId.isEmpty())
         {
//             shareLocationDetail(locationId);
             getDetailLocation(locationId);
         }

    }

    private void locationId(String locationId){



    }

    private void getDetailLocation(String locationId) {
        location.child(locationId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Location loc = dataSnapshot.getValue(Location.class);





                collapsingToolbarLayout.setTitle(loc.getName());

                Picasso.with(getBaseContext()).load(loc.getImage())
                        .into(loc_Image);

                loc_name.setText(loc.getName());
                loc_Descriptio.setText(loc.getDescription());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
