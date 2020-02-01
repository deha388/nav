package com.demo1.nav.Exercises;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo1.nav.R;

import java.util.ArrayList;
public class Exercise extends AppCompatActivity {


     RecyclerView mRecyclerView;
     ExeAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ExeAdapter(this,getMylist());
        mRecyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
    private ArrayList<model> getMylist(){
        ArrayList<model> models =new ArrayList<>();
        model m=new model();
        m.setTitle("Chest");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe7);
        models.add(m);

        m=new model();
        m.setTitle("Chest");
        m.setDes("Incline Chest Press");
        m.setImg(R.drawable.exe7);
        models.add(m);

        m=new model();
        m.setTitle("Chest");
        m.setDes("Decline Chest Press");
        m.setImg(R.drawable.exe7);
        models.add(m);

        m=new model();
        m.setTitle("Back");
        m.setDes("Lat Pull Down");
        m.setImg(R.drawable.exe6);
        models.add(m);

        m=new model();
        m.setTitle("Back");
        m.setDes("Pull Over");
        m.setImg(R.drawable.exe6);
        models.add(m);

        m=new model();
        m.setTitle("Shoulder");
        m.setDes("Shoulder Press");
        m.setImg(R.drawable.exe2);
        models.add(m);

        m=new model();
        m.setTitle("Shoulder");
        m.setDes("Barbell Shoulder Press");
        m.setImg(R.drawable.exe2);
        models.add(m);

        m=new model();
        m.setTitle("Shoulder");
        m.setDes("Lateral Raises");
        m.setImg(R.drawable.exe3);
        models.add(m);

        m=new model();
        m.setTitle("Arm");
        m.setDes("Barbell Curl");
        m.setImg(R.drawable.exe3);
        models.add(m);

        m=new model();
        m.setTitle("Arm");
        m.setDes("Hammer Curl");
        m.setImg(R.drawable.exe3);
        models.add(m);

        m=new model();
        m.setTitle("Arm");
        m.setDes("EZ-Bar Reverse Curl");
        m.setImg(R.drawable.exe4);
        models.add(m);



        m=new model();
        m.setTitle("Leg");
        m.setDes("Squat");
        m.setImg(R.drawable.exe9);
        models.add(m);

        m=new model();
        m.setTitle("Chest");
        m.setDes("BenchPress");
        m.setImg(R.drawable.eee);
        models.add(m);

        m=new model();
        m.setTitle("Chest");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe8);
        models.add(m);

        m=new model();
        m.setTitle("Leg");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe8);
        models.add(m);

        m=new model();
        m.setTitle("Leg");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe2);
        models.add(m);

        m=new model();
        m.setTitle("Leg");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe5);
        models.add(m);

        m=new model();
        m.setTitle("Arm");
        m.setDes("BenchPress");
        m.setImg(R.drawable.exe9);
        models.add(m);

        m=new model();
        m.setTitle("Leg");
        m.setDes("BenchPress");
        m.setImg(R.drawable.eee);
        models.add(m);

        return models;

    }
}


