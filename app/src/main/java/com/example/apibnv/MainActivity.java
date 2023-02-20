package com.example.apibnv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    HomeFragment homeFragment = new HomeFragment();
    WaterFragment waterFragment = new WaterFragment();
    ForestFragment forestFragment = new ForestFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container , homeFragment).commit();

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , homeFragment).commit();
                        return true;
                    }
                    case R.id.water:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , waterFragment).commit();
                        return true;
                    }
                    case R.id.forest:
                    {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container , forestFragment).commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}