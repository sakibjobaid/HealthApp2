package com.example.asus.healthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

public class MealClass extends AppCompatActivity {

    ListView lst;
    String [] foodname={"Rice","Apple","Sweet"};
    String [] foodDesc={"500 cal","200 cal","100 cal"};
    String [] amount={"200gm","50 gm","20gm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.meal);

        int id= getIntent().getIntExtra("viewid",-1);
        switch (id)
        {
            case R.id.breakfasT:  this.setTitle("Breakfast"); break;
            case R.id.luncH:  this.setTitle("Lunch"); break;
            case R.id.dinneR:  this.setTitle("Dinner"); break;
            case R.id.morningsnackS:  this.setTitle("Morning Snacks"); break;
            case R.id.eveningsnackS:  this.setTitle("Evening Snacks");break;
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        lst= (ListView) findViewById(R.id.listview);
        ListViewData lvd= new ListViewData(this,foodname,foodDesc,amount);
        lst.setAdapter(lvd);

    }
}
