package com.example.catchlogly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    boolean disableCatch;
    boolean disableLog;
    public void disableCatch(View V){
        Switch catchChip = (Switch) findViewById(R.id.dis_catch);



        if(disableCatch){
            disableCatch = false;
        }
        else{
            disableCatch = true;
        }
    }

    public void disableLog(View V){
        Switch logChip = (Switch) findViewById(R.id.dis_log);
        //TextView dis_log = (TextView) findViewById(R.id.dis_log);
        if(disableLog){
            disableLog = false;
            logChip.setText("Disable");

        }
        else{
            disableLog = true;
            logChip.setText("Enable");
        }
    }


//    public void intoCatch(View V){ //into catch activity
//        Intent i = new Intent(this, DeskFragment.class);
//        i.putExtra("title", "Catch.ly");
//        startActivity(i);
//    }
//    public void intoLog(View V){ //into log activity
//        Intent i = new Intent(this, DeskFragment.class);
//        i.putExtra("title", "Log.ly");
//        startActivity(i);
//    }

    public void intoCatch(View V) { // into catch activity
        DeskFragment deskFragment = new DeskFragment();
        Bundle args = new Bundle();
        args.putString("title", "Catch.ly");
        deskFragment.setArguments(args); // Set arguments to the fragment

        // Replace the current fragment with DeskFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tab1, deskFragment) // Use the appropriate container ID
                .addToBackStack(null) // Optional: to add this transaction to the back stack
                .commit();
    }

    public void intoLog(View V) { // into log activity
        DeskFragment deskFragment = new DeskFragment();
        Bundle args = new Bundle();
        args.putString("title", "Log.ly");
        deskFragment.setArguments(args); // Set arguments to the fragment

        // Replace the current fragment with DeskFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tab2, deskFragment) // Use the appropriate container ID
                .addToBackStack(null) // Optional
                .commit();
    }







}