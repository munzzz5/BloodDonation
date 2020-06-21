package com.example.akshaybhandari.blooddonation;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class donordetails extends Fragment {

TableLayout t1;
db db1;
String name,bloodtype,mobno1,daysfree;
int id,age;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_donordetails, container, false);
        db1=new db(getContext(),"",null,1);
        t1=(TableLayout)view.findViewById(R.id.donortable);
        getDetails();
        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void getDetails()
    {

        Cursor cr=db1.getAllDonors();
        if(cr.getCount()==0)
        {
            Toast.makeText(getContext(),"NOT FOUND",Toast.LENGTH_LONG).show();
        }
        else
        {
            while(cr.moveToNext()) {
                TableRow tr=new TableRow(getActivity());
                id = cr.getInt(0);
                name = cr.getString(1);
                bloodtype = cr.getString(2);
                age = cr.getInt(3);
                mobno1 = cr.getString(4);
                daysfree = cr.getString(5);
                String id1=Integer.toString(id);
                String age1=Integer.toString(age);
                TextView tv0=new TextView(getContext());
                TextView tv1=new TextView(getContext());
                TextView tv2=new TextView(getContext());
                TextView tv3=new TextView(getContext());
                TextView tv4=new TextView(getContext());
                TextView tv5=new TextView(getContext());
                tv0.setText(id1);
                tv1.setText(name);
                tv2.setText(age1);
                tv3.setText(bloodtype);
                tv4.setText(mobno1);
                tv5.setText(daysfree);
                tv0.setTextColor(Color.BLACK);
                tv1.setTextColor(Color.BLACK);
                tv2.setTextColor(Color.BLACK);
                tv3.setTextColor(Color.BLACK);
                tv4.setTextColor(Color.BLACK);
                tv5.setTextColor(Color.BLACK);
                tv0.setPadding(10,10,10,10);
                tv1.setPadding(10,10,10,10);
                tv2.setPadding(10,10,10,10);
                tv3.setPadding(10,10,10,10);
                tv4.setPadding(10,10,10,10);
                tv5.setPadding(10,10,10,10);
                tr.addView(tv0);
                tr.addView(tv1);
                tr.addView(tv2);
                tr.addView(tv3);
                tr.addView(tv4);
                tr.addView(tv5);
                t1.addView(tr);

            }
        }
    }

}
