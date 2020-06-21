package com.example.akshaybhandari.blooddonation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.app.FragmentManager;
import android.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


public class admin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    Fragment f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        drawer=(DrawerLayout) findViewById(R.id.adminDrawer);
        toggle=new ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navview=(NavigationView)findViewById(R.id.fnavLayout);
        navview.setNavigationItemSelectedListener(this);


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.addcase) {

            f1 = new addcase();
            Toast.makeText(this, "Add case", Toast.LENGTH_LONG).show();

            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.adminFragment, f1);
            ft.commit();

        } else if (menuItem.getItemId() == R.id.casehist) {

            f1 = new casehistory();
            Toast.makeText(this, "Case Histroy", Toast.LENGTH_LONG).show();
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.adminFragment, f1);
            ft.commit();
        } else if (menuItem.getItemId() == R.id.donordet) {

            f1 = new donordetails();
            Toast.makeText(this, "Donor Details", Toast.LENGTH_LONG).show();
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.adminFragment, f1);
            ft.commit();
        }
        else if (menuItem.getItemId() == R.id.handle) {

            f1 = new sendDonor();
            Toast.makeText(this, "Donor Details", Toast.LENGTH_LONG).show();
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.adminFragment, f1);
            ft.commit();
        }
        else if (menuItem.getItemId() == R.id.search) {

            f1 = new searchDonor();
            Toast.makeText(this, "Donor Details", Toast.LENGTH_LONG).show();
            FragmentManager fm = getFragmentManager();
            fm.popBackStack();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.adminFragment, f1);
            ft.commit();
        }


        return false;

        }


}
