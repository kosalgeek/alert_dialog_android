package com.kosalgeek.alertdialogselectionoptions;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity 
        implements View.OnClickListener, View.OnLongClickListener {

    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn1.setOnLongClickListener(this);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "Button 3",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1){
            Toast.makeText(this, "Button 1", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.btn2){
            Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onLongClick(View v) {
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        //Options conflict with message. So to use options, disable setMessage()
        //msg.setMessage("Are you OK?");

        msg.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        msg.setNegativeButton("Cancel", null);
        msg.setIcon(android.R.drawable.btn_star_big_on);
        msg.setTitle("My title");

        CharSequence[] option = new CharSequence[]{"I'm Well", "Not Well", "I'm Sick"};

        msg.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    Log.i("MainActivity", "which = " + which);
                    btn1.setText("I'm Well");
                }
                else if(which == 1){
                    Log.i("MainActivity", "which = " + which);
                    btn1.setTextSize(20);
                }
                else if(which == 2){
                    Log.i("MainActivity", "which = " + which);
                }
            }
        });

        msg.show();

        return true;
    }
}
