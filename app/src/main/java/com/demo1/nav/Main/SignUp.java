package com.demo1.nav.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.demo1.nav.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText edit_oran,edit_password,edit_username,edit_email;
    Button register;
    TextView girissayfasına_git;
    FirebaseDatabase database ;
    FirebaseAuth auth;
    ProgressDialog pd;
    DatabaseReference databaseReference;
    private User user;
    private static final String USER="user";
    private static final String TAG="SignUp";
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edit_email=findViewById(R.id.edit_email);
        edit_oran=findViewById(R.id.edit_oran);
        edit_password=findViewById(R.id.edit_password);
        edit_username=findViewById(R.id.edit_username);
        edit_email=findViewById(R.id.edit_email);
        register=findViewById(R.id.register);
        girissayfasına_git=findViewById(R.id.girişsayfasına_git);
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference(USER);
        auth=FirebaseAuth.getInstance();

        girissayfasına_git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this, Login.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd=new ProgressDialog(SignUp.this);
                pd.setMessage("Please Wait...");
                pd.show();

                String email=edit_email.getText().toString();
                String username=edit_username.getText().toString();
                String password=edit_password.getText().toString();
                String oran=edit_oran.getText().toString();
                user=new User(email,username,password,oran);

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(oran)|| TextUtils.isEmpty(password)||TextUtils.isEmpty(username)){
                    Toast.makeText(SignUp.this, "Please fill in the blanks",Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
                else if (password.length()<6){
                    Toast.makeText(SignUp.this, "Password must be min 6 car.", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                }
                else{
                    //yeni kullanıcı
                   registerUser();

//

                }
            }
        });
    }
//    private void register(final        register(email,password); String email, final String password) {
//        final FirebaseAuth auth = FirebaseAuth.getInstance();
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(SignUp.this, "Succesful", Toast.LENGTH_LONG).show();
//
//                            FirebaseUser user = auth.getCurrentUser();
//                            String user_id = user.getUid();
//                            DatabaseReference  databaseReference= FirebaseDatabase.getInstance().getReference().child("Users").child("Users_ID").push();
//
//                            HashMap<String, Object> hashMap = new HashMap<>();
//                            hashMap.put("id", user_id);
//                            hashMap.put("username", username);
//                            hashMap.put("oran", oran);
//                            hashMap.put("email",email);
//
//
//
//                            //hashMap.put("id",user_id);
//
//                            databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        pd.dismiss();
//                                        Intent intent=new Intent(SignUp.this, Home.class);
//                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//                                        startActivity(intent);
//                                        finish();
//
//                                    }
//                                }
//                            });
//
//
//
//                        } else {
//
//                            Toast.makeText(SignUp.this, task.getException().getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//
//                });
//
//    private void register(String email,String password){
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(SignUp.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//
//    private void updateUI(FirebaseUser currentUser) {
//        String keyId=databaseReference.push().getKey();
//        databaseReference.child(keyId).setValue(user);
//        Intent loginIntent=new Intent(this, Home.class);
//        startActivity(loginIntent);
//
//    }


    private void registerUser() {
        final String email = edit_email.getText().toString().trim();
        final String username = edit_username.getText().toString().trim();
        String password = edit_password.getText().toString().trim();
        final String oran = edit_oran.getText().toString().trim();

        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(
                                    email,
                                    username,
                                    password,
                                    oran
                            );

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {


                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignUp.this, "Welcome", Toast.LENGTH_LONG).show();
                                                Intent loginIntent=new Intent(SignUp.this, Home.class);
                                                startActivity(loginIntent);

                                    } else {
                                        //display a failure message
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }



}