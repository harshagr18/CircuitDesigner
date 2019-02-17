package com.example.harsh.cktdesigning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleStage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_stage);


        Button CsAmp = (Button) findViewById(R.id.CsAmp);
        CsAmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Cslaunch = new Intent(SingleStage.this, csamplifier.class);
                startActivity(Cslaunch);
            }
        });


        Button CeAmp = (Button) findViewById(R.id.CeAmp);
        CeAmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Celaunch = new Intent(SingleStage.this, ceamplifier.class);
                startActivity(Celaunch);
            }
        });

    }
}
