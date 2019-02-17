package com.example.harsh.cktdesigning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ceampans extends AppCompatActivity {

    EditText R1,R2,RE,RC,C1,C2,CE,Vcc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceampans);

        R1= (EditText) findViewById(R.id.R1Box);
        R2= (EditText) findViewById(R.id.R2Box);
        RE= (EditText) findViewById(R.id.REBox);
        RC= (EditText) findViewById(R.id.RCBox);
        C1= (EditText) findViewById(R.id.C1Box);
        C2= (EditText) findViewById(R.id.C2Box);
        CE= (EditText) findViewById(R.id.CEBox);
        Vcc= (EditText) findViewById(R.id.VccBox);

        R1.setText(getIntent().getStringExtra("R1"));
        R2.setText(getIntent().getStringExtra("R2"));
        RE.setText(getIntent().getStringExtra("RE"));
        RC.setText(getIntent().getStringExtra("RC"));
        C1.setText(getIntent().getStringExtra("C1"));
        C2.setText(getIntent().getStringExtra("C2"));
        CE.setText(getIntent().getStringExtra("CE"));
        Vcc.setText(getIntent().getStringExtra("Vcc"));
    }

    }

