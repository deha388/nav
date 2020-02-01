package com.demo1.nav.Exercises;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo1.nav.R;


public class Example_Exe extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView MimageView;
    TextView MtextView ,MtextView2;
    ClickListener clickListener;
    public Example_Exe(@NonNull View itemView) {
        super(itemView);
        this.MimageView=itemView.findViewById(R.id.MimageView);
        this.MtextView=itemView.findViewById(R.id.MtextView);
        this.MtextView2=itemView.findViewById(R.id.MtextView2);

        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        this.clickListener.onClickListner(v, getLayoutPosition());

    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }
}
