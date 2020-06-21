package com.example.akshaybhandari.blooddonation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1,b2;
        b1=(Button) findViewById(R.id.donor);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonorReg();
            }
        });
        b2=(Button) findViewById(R.id.admin);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdmin();
            }
        });
    }


    public void openDonorReg()
    {
        Intent intent=new Intent(login.this,donorReg.class);
        startActivity(intent);

    }
    public void openAdmin()
    {
        Intent intent=new Intent(login.this,admin.class);
        startActivity(intent);


    }
}
