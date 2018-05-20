package com.example.zy5545269.seapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdvisorAdapter extends ArrayAdapter<Advisor> {
    private int resourceId;

    public AdvisorAdapter(Context context, int textViewResourceId, List<Advisor> objects)
    {
        super(context,textViewResourceId,objects);
        this.resourceId = textViewResourceId;
    }

    class ViewValue
    {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftAdvisor;
        TextView RightUser;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Advisor advisor = getItem(position);
        View view;
        ViewValue viewvalue;

        if(convertView == null)
        {
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewvalue = new ViewValue();
            viewvalue.rightLayout= (LinearLayout)view.findViewById(R.id.right_layout);
            viewvalue.leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
            viewvalue.leftAdvisor =(TextView)view.findViewById(R.id.tv_receive);
            viewvalue.RightUser = (TextView)view.findViewById(R.id.tv_send);
            view.setTag(viewvalue);
        }
        else{
            view = convertView;
            viewvalue = (ViewValue)view.getTag();
        }

        if(advisor.getType() == Advisor.TYPE_RECEIVED)
        {
            viewvalue.leftLayout.setVisibility(View.VISIBLE);
            viewvalue.rightLayout.setVisibility(View.GONE);
            viewvalue.leftAdvisor.setText(advisor.getContent());
        }
        else if(advisor.getType() == Advisor.TYPE_SEND)
        {
            viewvalue.rightLayout.setVisibility(View.VISIBLE);
            viewvalue.leftLayout.setVisibility(View.GONE);
            viewvalue.RightUser.setText(advisor.getContent());
        }


        return view;
    }

}
