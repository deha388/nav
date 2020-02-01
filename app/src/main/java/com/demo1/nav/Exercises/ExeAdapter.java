package com.demo1.nav.Exercises;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.demo1.nav.R;
import java.util.ArrayList;


public class ExeAdapter extends RecyclerView.Adapter<Example_Exe> implements Filterable {
    Context context;
    ArrayList<model> models,filterList;
    CustomFilter filter;

    public ExeAdapter(Context context,ArrayList<model> models){
        this.context=context;
        this.models=models;
        this.filterList=models;
    }



    @NonNull
    @Override
    public Example_Exe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,null);



        return new Example_Exe(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Example_Exe holder, int position) {
        holder.MimageView.setImageResource(models.get(position).getImg());
        holder.MtextView.setText(models.get(position).getTitle());
        holder.MtextView2.setText(models.get(position).getDes());

//
//        holder.setClickListener(new ClickListener() {
//            @Override
//            public void onClickListner(View v, int position) {
//
//                String tit=models.get(position).getTitle();
//                String des=models.get(position).getDes();
//                BitmapDrawable bitmapDrawable=(BitmapDrawable)holder.MimageView.getDrawable();
//                Bitmap bitmap=bitmapDrawable.getBitmap();
//                ByteArrayOutputStream stream=new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
//                byte[] bytes=stream.toByteArray();
//
//                Intent intent=new Intent(context, Workout.class);
//                context.startActivity(intent);
//
//
//            }
//        });

        holder.setClickListener(new ClickListener() {
            @Override
            public void onClickListner(View v, int position) {
                if(models.get(position).getTitle().equals("Chest")) {
                    //setFragment(new BenchFragment());
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=FJ-93QIK1Ek"));
                    context.startActivity(intent);
                }
                else if (models.get(position).getTitle().equals("Back")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=NoRkALo4AMQ"));
                    context.startActivity(intent);

                }
                else if (models.get(position).getTitle().equals("Shoulder")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=S3RNB1jjbC8&list=PLtw1ru96ZqxdRFbVMZWixWAP5CBmVPZaP&index=10"));
                    context.startActivity(intent);

                }
                else if (models.get(position).getTitle().equals("Leg")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=vsA-2XtAeio&list=PLtw1ru96ZqxdRFbVMZWixWAP5CBmVPZaP&index=12"));
                    context.startActivity(intent);

                }
                else if (models.get(position).getTitle().equals("Arm")){
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v=yRECvTS0CWY&list=PLtw1ru96ZqxdRFbVMZWixWAP5CBmVPZaP&index=9"));
                    context.startActivity(intent);

                }
            }
        });



    }
        private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.b, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    @Override
    public Filter getFilter() {
        if (filter==null){
            filter=new CustomFilter(filterList,this);
        }
        return filter;
    }
}




