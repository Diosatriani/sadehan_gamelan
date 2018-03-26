package com.dio.satriani.sadehan_gamelan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.dio.satriani.sadehan_gamelan.Fragment.HomeFragment;
import com.dio.satriani.sadehan_gamelan.Fragment.MoreFragment;
import com.dio.satriani.sadehan_gamelan.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private BottomNavigationView.OnNavigationItemSelectedListener botnav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()){
                case R.id.navigasi_home:
                    transaction.replace(R.id.content, new HomeFragment()).commit();
//                    Intent profileActivity = new Intent(getApplicationContext(), HomeFragment.class);
//                    startActivity(profileActivity);
                    Toast.makeText(MainActivity.this, "Iso kudu ne", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.navigasi_favorite:
                    return true;

                case R.id.navigasi_camera:
                    return true;

                case R.id.navigasi_iklan:
                    return true;

                case R.id.navigasi_more:
                    transaction.replace(R.id.content, new MoreFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.navigasi);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);

        BottomNavigationView BNV = (BottomNavigationView) findViewById(R.id.navigasi);
        BNV.setOnNavigationItemSelectedListener(botnav);

    }
}
