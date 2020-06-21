package com.example.akshaybhandari.blooddonation;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class casehistory extends Fragment {
    TableLayout t1;
    db db1;
    String id,name,mobno1,treatment,bloodtype;
    int age,bno,pno;
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_casehistroy, container, false);
        t1=(TableLayout)view.findViewById(R.id.casetable);
        db1=new db(getContext(),"",null,1);
        getDetails();
        return view;
    }
@TargetApi(Build.VERSION_CODES.M)
@RequiresApi(api = Build.VERSION_CODES.M)
public void getDetails()
{

    Cursor cr=db1.getAllCases();
    if(cr.getCount()==0)
    {
        Toast.makeText(getContext(),"NOT FOUND",Toast.LENGTH_LONG).show();
    }
    else
    {
        while(cr.moveToNext()) {
            TableRow tr=new TableRow(getActivity());
            id = cr.getString(0);
            name = cr.getString(1);
            mobno1 = cr.getString(2);
            age = cr.getInt(3);
            treatment=cr.getString(4);
            bno = cr.getInt(5);
            pno = cr.getInt(6);
            bloodtype=cr.getString(7);

            String bno1=Integer.toString(bno);
            String pno1=Integer.toString(pno);
            String age1=Integer.toString(age);
            TextView tv0=new TextView(getContext());
            TextView tv1=new TextView(getContext());
            TextView tv2=new TextView(getContext());
            TextView tv3=new TextView(getContext());
            TextView tv4=new TextView(getContext());
            TextView tv5=new TextView(getContext());
            TextView tv6=new TextView(getContext());
            TextView tv7=new TextView(getContext());
            tv0.setText(id);
            tv1.setText(name);
            tv2.setText(mobno1);
            tv3.setText(age1);
            tv4.setText(treatment);
            tv5.setText(bno1);
            tv6.setText(pno1);
            tv7.setText(bloodtype);
            tv0.setGravity(Gravity.CENTER);
            tv1.setGravity(Gravity.CENTER);
            tv2.setGravity(Gravity.CENTER);
            tv3.setGravity(Gravity.CENTER);
            tv4.setGravity(Gravity.CENTER);
            tv5.setGravity(Gravity.CENTER);
            tv6.setGravity(Gravity.CENTER);
            tv7.setGravity(Gravity.CENTER);
            tv0.setPadding(10,10,10,10);
            tv1.setPadding(10,10,10,10);
            tv2.setPadding(10,10,10,10);
            tv3.setPadding(10,10,10,10);
            tv4.setPadding(10,10,10,10);
            tv5.setPadding(10,10,10,10);
            tv6.setPadding(10,10,10,10);
            tv7.setPadding(10,10,10,10);
            tv0.setTextColor(Color.BLACK);
            tv1.setTextColor(Color.BLACK);
            tv2.setTextColor(Color.BLACK);
            tv3.setTextColor(Color.BLACK);
            tv4.setTextColor(Color.BLACK);
            tv5.setTextColor(Color.BLACK);
            tv6.setTextColor(Color.BLACK);
            tv7.setTextColor(Color.BLACK);
            tr.addView(tv0);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            tr.addView(tv5);
            tr.addView(tv6);
            tr.addView(tv7);
            t1.addView(tr);

        }
    }
}
}
