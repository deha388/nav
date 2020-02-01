package com.demo1.nav.Workout.Split;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.demo1.nav.Main.Home;
import com.demo1.nav.R;
import com.demo1.nav.Workout.Split.Beginner.Beginner;

public class split extends AppCompatActivity {

    String[] liste={"Beginner1","Beginner2","Beginner3","Intermediate1","Intermediate2","Intermediate3",
            "Advanced1","Advanced2","Advanced3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);


        ListView list = (ListView) findViewById(R.id.listview);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, liste);

        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                if(position==0){

                    Intent intent=new Intent(v.getContext(), Beginner.class);
                    startActivityForResult(intent,0);

                }
                else if(position==1){
                Intent intent=new Intent(v.getContext(),Home.class);
                startActivityForResult(intent,0);

            }
            }
        });










    }
}













