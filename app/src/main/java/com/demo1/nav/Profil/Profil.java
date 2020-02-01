package com.demo1.nav.Profil;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.demo1.nav.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Profil extends AppCompatActivity {

    ListView listViewl1;

    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    List<String> itemlist;
    List<String> itemlist1;
    TextView text,text11,text111 ;




    private static final String USER = "User";
    private static final String SUCCESS = "Success";


    FirebaseUser user;
    FirebaseUser user1;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        String uid;
        String uid1;

        ListView listViewl1 = findViewById(R.id.listview11);
        TextView text=findViewById(R.id.text);
        TextView text11=findViewById(R.id.text11);
        TextView text111=findViewById(R.id.text111);
        itemlist = new ArrayList<>();
        itemlist1 = new ArrayList<>();


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (this, android.R.layout.simple_list_item_1, android.R.id.text1, liste);
//
//        l1.setAdapter(adapter);
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference(USER);
//        Toast.makeText(Profil.this, uid, Toast.LENGTH_LONG).show();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlist.clear();
                String username = dataSnapshot.child(uid).child("username").getValue(String.class);
                String email = dataSnapshot.child(uid).child("email").getValue(String.class);
                String orana = dataSnapshot.child(uid).child("oran").getValue(String.class);

                itemlist.add(username);
                itemlist.add(email);
                itemlist.add(orana);


//                for (int i = 0; i < itemlist.size(); i++) {
//                    //System.out.println(list.get(i));
//
//
//                    text.setText((text.getText() != null ? text.getText() : "") + itemlist.get(i));
//                }


                String text1 = itemlist.get(0).toString();
                text.setText(text1);
                String text2 = itemlist.get(1).toString();
                text11.setText(text2);
                String text3 = itemlist.get(2).toString();
                text111.setText(text3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        user1 = FirebaseAuth.getInstance().getCurrentUser();
        uid1 = user1.getUid();
        databaseReference1 = FirebaseDatabase.getInstance().getReference(SUCCESS);

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlist1.clear();
                String success = dataSnapshot.child(uid1).getValue(String.class);

                if(success==null){

                    Toast.makeText(Profil.this, success, Toast.LENGTH_LONG).show();

                }else{
                    itemlist1.add(success);



                    adapter2 = new ArrayAdapter<>(Profil.this,  R.layout.str1, itemlist1);
                    listViewl1.setAdapter(adapter2);
                }
//                Toast.makeText(Profil.this, success, Toast.LENGTH_LONG).show();
//

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




//        adapter = new MyAdapter(Profil.this, (ArrayList) itemlist,img);
//
//        l1.setAdapter(adapter);


//        // FloatingActionButton fab = findViewById(R.id.fab);
//        mail = findViewById(R.id.mail);
//        name = findViewById(R.id.name);
//        oran=findViewById(R.id.oran);
//
//
//        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference(USER);
//        DatabaseReference userRef = rootRef.child(USER);
//        String userKey = user.getUid();
//        String keyId=rootRef.getKey();
//       Toast.makeText(Profil.this, userKey, Toast.LENGTH_LONG).show();
//
//        ValueEventListener eventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    String username = ds.child("username").getValue(String.class);
//                    String email = ds.child(userKey).child("email").getValue(String.class);
//                    String orana = ds.child("oran").getValue(String.class);
//
//                    name.setText(username);
//                    mail.setText(email);
//                    oran.setText(orana);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        };
//        userRef.child(userKey).addValueEventListener(eventListener);


//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showEditProfileDialog();
//            }
//
//            private void showEditProfileDialog() {
//                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                photoPickerIntent.setType("image/*");
//                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
//            }
//
//
//
//        });
//
//
    }
}

//
//    class MyAdapter extends ArrayAdapter<String> {
//
//        Context context;
//        ArrayList<String> rTitle;
//        String rDescription[];
//        int rImgs[];
//
//        MyAdapter (Context c, ArrayList title, int[] imgs) {
//            super(c, R.layout.str, R.id.textView1, title);
//            this.context = c;
//            this.rTitle = title;
//            this.rImgs = imgs;
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View str = layoutInflater.inflate(R.layout.str, parent, false);
//            ImageView images = str.findViewById(R.id.image);
//            TextView myTitle = str.findViewById(R.id.textView1);
//
//
//            // now set our resources on views
//            images.setImageResource(rImgs[position]);
//            myTitle.setText(rTitle.get(position));
//
//
//
//
//
//            return str;
//        }
//    }












