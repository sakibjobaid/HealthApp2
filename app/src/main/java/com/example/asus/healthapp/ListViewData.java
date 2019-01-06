package com.example.asus.healthapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewData extends ArrayAdapter<String> {

    //region Description
    private String [] foodname={"Rice","Apple"};
    private String [] foodDesc={"500 cal","200 cal"};
    private String [] amount={"200gm","50 gm"};
    private Activity context;
    //endregion
    public ListViewData(Activity context, String [] foodname,String [] foodDesc, String [] amount)
    {
        super(context,R.layout.listview_layout,foodname);
        this.amount=amount;
        this.context=context;
        this.foodDesc=foodDesc;
        this.foodname=foodname;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View res= convertView;
        viewHolder vhold=null;
        if(res==null)
        {
            LayoutInflater lf= context.getLayoutInflater();
            res = lf.inflate(R.layout.listview_layout,null,true);
            vhold= new viewHolder(res);
            res.setTag(vhold);
        }
        else
        {
            vhold=(viewHolder)res.getTag();
        }
        vhold.food.setText(foodname[position]);
        vhold.amt.setText(amount[position]);
        vhold.des.setText(foodDesc[position]);
        return res;
    }
    class  viewHolder
    {
        TextView food,des,amt;
        viewHolder(View v)
        {
            food= (TextView)v.findViewById(R.id.Name);
            des= (TextView)v.findViewById(R.id.Desc);
            amt= (TextView)v.findViewById(R.id.Amount);
        }
    }
}
