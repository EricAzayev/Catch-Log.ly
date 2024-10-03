package com.example.catchlogly;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
public class MainActivity2 extends AppCompatActivity {
    ViewPager2 viewPager;
    boolean inLogly = false;

    private ItemViewModel viewModel; //to share between Activity2 and Desk Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        String label = intent.getStringExtra("label");
        if(label.equals("Log.ly"))inLogly = true;

        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        viewModel.selectString(label); //one time pass to set hint


        TextView deskTitle = (TextView) findViewById(R.id.desk_title);
        deskTitle.setText(label);


        //find view by ids
        viewPager = findViewById(R.id.viewpager);
        //getSupportActionBar().hide();
        viewPager.setAdapter(new SliderAdapter(getSupportFragmentManager(), getLifecycle())); // Pass lifecycle
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                deskTitle.setText("");
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                deskTitle.setText(label);

            }
        });

        //on last screen change next button to finish / continue
    }
}
