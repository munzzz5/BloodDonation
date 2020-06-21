package com.example.akshaybhandari.blooddonation;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;


public class searchDonor extends Fragment {
EditText e1;
RadioButton c1,c2,c3,c4,c5,c6,c7;
Button b1;
db db1;
String bloodgp;
String days;
TableLayout t1;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search_donor, container, false);
        b1=(Button)view.findViewById(R.id.search);
        t1=(TableLayout)view.findViewById(R.id.donorsearchtable);
        e1=(EditText)view.findViewById(R.id.bdgroup);
        c1=(RadioButton) view.findViewById(R.id.mon);
        c2=(RadioButton)view.findViewById(R.id.tue);
        c3=(RadioButton)view.findViewById(R.id.wed);
        c4=(RadioButton)view.findViewById(R.id.thur);
        c5=(RadioButton)view.findViewById(R.id.fri);
        c6=(RadioButton)view.findViewById(R.id.sat);
        c7=(RadioButton)view.findViewById(R.id.sun);
        db1=new db(getContext(),"",null,1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;
                bloodgp = e1.getText().toString();
                Cursor cr = db1.getDonorsBlood(bloodgp);

                if (cr.getCount() == 0) {
                    Toast.makeText(getContext(), "NOT FOUND", Toast.LENGTH_LONG).show();
                } else {
                    while (cr.moveToNext()) {
                        TableRow tr = new TableRow(getActivity());
                        int id = cr.getInt(0);
                        String name = cr.getString(1);

                        int age = cr.getInt(2);
                        String mobno1 = cr.getString(3);

                        String id1 = Integer.toString(id);
                        String age1 = Integer.toString(age);
                        TextView tv0 = new TextView(getContext());
                        TextView tv1 = new TextView(getContext());
                        TextView tv2 = new TextView(getContext());
                        TextView tv3 = new TextView(getContext());
                        tv0.setText(id1);
                        tv1.setText(name);
                        tv2.setText(age1);
                        tv3.setText(mobno1);
                        tv0.setTextColor(Color.BLACK);
                        tv1.setTextColor(Color.BLACK);
                        tv2.setTextColor(Color.BLACK);
                        tv3.setTextColor(Color.BLACK);

                        tv0.setPadding(10, 10, 10, 10);
                        tv1.setPadding(10, 10, 10, 10);
                        tv2.setPadding(10, 10, 10, 10);
                        tv3.setPadding(10, 10, 10, 10);

                        tr.addView(tv0);
                        tr.addView(tv1);
                        tr.addView(tv2);
                        tr.addView(tv3);

                        t1.addView(tr);

                    }


                }
            }
        });
        return view;
    }


}
