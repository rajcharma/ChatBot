package com.example.zy5545269.seapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdvisorAdapter extends ArrayAdapter<Advisor> {
    private int resourceId;

    public AdvisorAdapter(Context context, int textViewResourceId, List<Advisor> objects)
    {
        super(context,textViewResourceId,objects);
        this.resourceId = textViewResourceId;
    }

    class ViewValue()
    {
        TextView leftAdvisor;
        TextView RightUser;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Advisor advisor = getItem(position);
        View view;
        ViewValue viewvalue;



        return view;
    }

}
