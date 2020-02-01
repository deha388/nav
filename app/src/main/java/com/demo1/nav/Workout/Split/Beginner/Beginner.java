package com.demo1.nav.Workout.Split.Beginner;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo1.nav.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Beginner extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();






    TextView btnexercise,titlepage, subtitlepage, intropage, subintropage,
             fitonetitle, fitonedesc, fittwotitle, fittwodesc,
            fitthreetitle, fitthreedesc, fitfourtitle, fitfourdesc;
//    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven, btteight;


    View divpage, bgprogress;

    LinearLayout fitone, fittwo, fitthree, fitfour;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beginner);
//        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
//        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
//        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
//        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
//        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix);
//        bttseven = AnimationUtils.loadAnimation(this, R.anim.bttseven);
//        btteight = AnimationUtils.loadAnimation(this, R.anim.btteight);



        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);

        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);

        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);

        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);

        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);


        // assign the animations
//        titlepage.startAnimation(bttone);
//        subtitlepage.startAnimation(bttone);
//        divpage.startAnimation(bttone);
//
//        intropage.startAnimation(bttwo);
//        subintropage.startAnimation(bttwo);
//
//        fitone.startAnimation(bttwo);
//        fittwo.startAnimation(bttfour);
//        fitthree.startAnimation(bttfive);
//        fitfour.startAnimation(bttsix);
//
//        btnexercise.startAnimation(btteight);
//        bgprogress.startAnimation(bttseven);

        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
                String a=user.getEmail();




                Intent intent=new Intent(Beginner.this,Beg.class);
                startActivity(intent);
            }
        });



    }











}
