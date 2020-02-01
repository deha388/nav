package com.demo1.nav.Exercises;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    ArrayList<model> filterList;
    ExeAdapter adapter;

    public CustomFilter(ArrayList<model> filterList,ExeAdapter adapter){
        this.filterList=filterList;
        this.adapter=adapter;
    }
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults=new FilterResults();
        if (constraint!=null&&constraint.length()>0){
            constraint=constraint.toString().toUpperCase();
            ArrayList<model>filterModels=new ArrayList<>();
            for (int i=0;i<filterList.size();i++){
                if(filterList.get(i).getTitle().toUpperCase().contains(constraint)){
                    filterModels.add(filterList.get(i));
                }
            }
            filterResults.count=filterModels.size();
            filterResults.values=filterModels;




        }
        else{
            filterResults.count=filterList.size();
            filterResults.values=filterList;

        }

        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.models=(ArrayList<model>) results.values;
        adapter.notifyDataSetChanged();

    }
}
