package com.example.akshaybhandari.blooddonation;

import android.content.Context;
import android.net.Uri;
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


public class sendDonor extends Fragment {
  db db1;
  EditText e1,e2,e3;
  String hospid1;
  Button b1;
  int bno,pno;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_send_donor, container, false);
        e1=(EditText)view.findViewById(R.id.hosp);
        e2=(EditText)view.findViewById(R.id.bloodno);
        e3=(EditText)view.findViewById(R.id.plateletno);
        db1=new db(getContext(),"",null,1);
        b1=(Button)view.findViewById(R.id.sendDonor);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hospid1=e1.getText().toString();
                bno=Integer.parseInt(e2.getText().toString());
                pno=Integer.parseInt(e3.getText().toString());
                if(bno>0){
                db1.giveBloodDonor(hospid1,bno);
                Toast.makeText(getContext(),"Blood Donor sent",Toast.LENGTH_SHORT);}
                else
                {
                    Toast.makeText(getContext(),"Enter valid no",Toast.LENGTH_LONG).show();
                }
                if(pno>0){
                db1.givePlateletDonor(hospid1,pno);
                    Toast.makeText(getContext(),"Platelet Donor sent",Toast.LENGTH_SHORT);}
                else
                {
                    Toast.makeText(getContext(),"Enter valid no",Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }


}
