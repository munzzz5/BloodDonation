package com.example.akshaybhandari.blooddonation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class donorReg extends AppCompatActivity {
EditText e1,e2,e3,e4;
CheckBox c1,c2,c3,c4,c5,c6,c7;
Button b1;
db db1;
String daysfree="",name,blood,mobno;
int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_reg);
        b1=(Button)findViewById(R.id.regsubmit);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.mobno);
        e3=(EditText)findViewById(R.id.age);
        e4=(EditText)findViewById(R.id.bloodgroup);
        c1=(CheckBox)findViewById(R.id.mon);
        c2=(CheckBox)findViewById(R.id.tue);
        c3=(CheckBox)findViewById(R.id.wed);
        db1=new db(this,"",null,1);
        c4=(CheckBox)findViewById(R.id.thur);
        c5=(CheckBox)findViewById(R.id.fri);
        c6=(CheckBox)findViewById(R.id.sat);
        c7=(CheckBox)findViewById(R.id.sun);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=e1.getText().toString();
                blood=e4.getText().toString();
                mobno=e2.getText().toString();
                age=Integer.parseInt(e3.getText().toString());
                if(c1.isChecked())
                {
                    daysfree+="Monday/";
                }
                if(c2.isChecked())
                {
                    daysfree+="Tuesday/";
                }
                if(c3.isChecked())
                {
                    daysfree+="Wednesday/";
                }
                if(c4.isChecked())
                {
                    daysfree+="Thursday/";
                }
                if(c5.isChecked())
                {
                    daysfree+="Friday/";
                }
                if(c6.isChecked())
                {
                    daysfree+="Saturday/";
                }
                if(c7.isChecked())
                {
                    daysfree+="Sunday/";
                }
                db1.insertDonor(name,blood,age,mobno,daysfree,0);
                Toast.makeText(getBaseContext(),"Donor Added",Toast.LENGTH_LONG).show();
            }
        });

    }
}
