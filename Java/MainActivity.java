package com.cookandroid.opensw_3team_cafereviewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; //하단바
    private FragmentManager fm;
    private FragmentTransaction ft;
    private home home;
    private map map;
    private set set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);            //툴바 이름 삭제


        bottomNavigationView = findViewById(R.id.battomMavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_map:
                        setFrag(1);
                        break;
                    case R.id.action_set:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        home = new home();
        map = new map();
        set = new set();
        setFrag(0); //첫화면

    }


   //프레그먼트 교체
    private  void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, home);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.main_frame, map);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.main_frame, set);
                ft.commit();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_categorie, menu);
        return true;
    }


    //리뷰 작성이 눌렸을 경우
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id == R.id.review){

            Intent reviewit = new Intent(MainActivity.this, ReviewReport.class);
            startActivity(reviewit);

        }

        return super.onOptionsItemSelected(item);
    }


}