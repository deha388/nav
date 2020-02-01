package com.demo1.nav.Workout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo1.nav.R;
import com.demo1.nav.Workout.Split.split;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StartWorkout extends AppCompatActivity {

    List<String> arrayList;

    TextView titlepage, subtitlepage, btnexercise;
    ImageView imgpage;
    View bgprogress, bgprogresstop;
    FirebaseUser user;
    DatabaseReference databaseReference;
    private static final String USER = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        imgpage = (ImageView) findViewById(R.id.imgpage);
        bgprogress = (View) findViewById(R.id.bgprogress);
        bgprogresstop = (View) findViewById(R.id.bgprogresstop);

        user=FirebaseAuth.getInstance().getCurrentUser();
        String uid=user.getUid();
        databaseReference=FirebaseDatabase.getInstance().getReference(USER);
        arrayList=new ArrayList<>();

//
//        userRef=rootRef.child(USER);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayList.clear();
                String oran = dataSnapshot.child(uid).child("oran").getValue(String.class);
                arrayList.add(oran);
               // Toast.makeText(StartWorkout.this, oran, Toast.LENGTH_LONG).show();
                int x=Integer.parseInt(oran);

                if(x<20&x>=14){
                    subtitlepage.setText("Your body shape is more suitable for INTERMEDIATE-WORKOUT");
                }
                else if (x<14){
                    subtitlepage.setText("Your body shape is more suitable for ADVANCED-WORKOUT");

                }
                else if(x>=20){
                    subtitlepage.setText("Your body shape is more suitable for BEGINNER-WORKOUT");
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(StartWorkout.this, split.class);
                startActivity(a);
            }
        });
    }
}
