package com.example.catchlogly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MainInterface extends AppCompatActivity {

    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);


        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);

        // Show the first fragment by default when the app opens
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, /*new FirstFragment()*/ new DeskFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new DeskFragment();
                        break;
                    case 1:
                        fragment = new BinderFragment();
                        break;
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.framelayout, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Handle tab unselected
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Handle tab reselected
            }
        });








    }








}