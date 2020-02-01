package com.demo1.nav.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.demo1.nav.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button SignUp,Login;
    FirebaseUser baslangicuser;

    @Override
    protected void onStart(){
        super.onStart();
        baslangicuser= FirebaseAuth.getInstance().getCurrentUser();

        if(baslangicuser!=null) {
            startActivity(new Intent(MainActivity.this, Home.class));
            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=findViewById(R.id.Login);
        SignUp=findViewById(R.id.SignUp);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.demo1.nav.Main.SignUp.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.demo1.nav.Main.Login.class));

            }
        });



    }
    public void onBackPressed(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}

