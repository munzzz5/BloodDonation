package com.example.akshaybhandari.blooddonation;

import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addcase extends Fragment {

EditText e1,e2,e3,e4,e5,e6,e7,e8;
Button b1;
db db1;
String hospid1,pname,mobno1,treatment1,bloodgroup1;
int age1,bno,pno;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_addcase, container, false);
        e1=(EditText)view.findViewById(R.id.name);
        db1=new db(getContext(),"",null,1);
        e2=(EditText)view.findViewById(R.id.mobno);
        e3=(EditText)view.findViewById(R.id.age);
        e4=(EditText)view.findViewById(R.id.hospId);
        e5=(EditText)view.findViewById(R.id.treatment);
        e6=(EditText)view.findViewById(R.id.bloodno);
        e7=(EditText)view.findViewById(R.id.plateletno);
        e8=(EditText)view.findViewById(R.id.bloodgroup);
        b1=(Button)view.findViewById(R.id.addcase);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hospid1=e4.getText().toString();
                pname=e1.getText().toString();
                mobno1=e2.getText().toString();
                treatment1=e5.getText().toString();
                bloodgroup1=e8.getText().toString();
                age1=Integer.parseInt(e3.getText().toString());
                bno=Integer.parseInt(e6.getText().toString());
                pno=Integer.parseInt(e7.getText().toString());
                db1.insertCase(hospid1,pname,mobno1,age1,treatment1,bno,pno,bloodgroup1);
                Toast.makeText(getContext(),"Case Added",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}