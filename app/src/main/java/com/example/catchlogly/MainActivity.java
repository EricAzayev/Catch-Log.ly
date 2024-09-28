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

    public void intoCatch(View V) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("label", "Catch.ly");
        startActivity(intent);


    }
    public void intoLog(View V) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("label", "Log.ly");
        startActivity(intent);
    }

    public void catchOff(View V){
        Switch catchChip = (Switch) findViewById(R.id.dis_catch);
        Button enterCatch = (Button) findViewById(R.id.enter_catch);

        if(enterCatch.isEnabled()){
            enterCatch.setEnabled(false);
            catchChip.setText("Enable");
        }
        else{
            enterCatch.setEnabled(true);
            catchChip.setText("Disable");
        }
    }

    public void logOff(View V){
        Switch logSwitch = (Switch) findViewById(R.id.dis_log);
        Button enterLog = (Button) findViewById(R.id.enter_log);

        if(enterLog.isEnabled()){
            enterLog.setEnabled(false);
            logSwitch.setText("Enable");
        }
        else{
            enterLog.setEnabled(true);
            logSwitch.setText("Disable");
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



//    public void intoCatch(View V) { // into catch activity
//        DeskFragment deskFragment = new DeskFragment();
//        Bundle args = new Bundle();
//        args.putString("title", "Catch.ly");
//        deskFragment.setArguments(args); // Set arguments to the fragment
//
//        // Replace the current fragment with DeskFragment
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.tab1, deskFragment) // Use the appropriate container ID
//                .addToBackStack(null) // Optional: to add this transaction to the back stack
//                .commit();
//    }
//
//    public void intoLog(View V) { // into log activity
//        DeskFragment deskFragment = new DeskFragment();
//        Bundle args = new Bundle();
//        args.putString("title", "Log.ly");
//        deskFragment.setArguments(args); // Set arguments to the fragment
//
//        // Replace the current fragment with DeskFragment
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.tab2, deskFragment) // Use the appropriate container ID
//                .addToBackStack(null) // Optional
//                .commit();
//    }
}