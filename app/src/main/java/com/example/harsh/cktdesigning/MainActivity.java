package com.example.harsh.cktdesigning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button SingleStage = (Button) findViewById(R.id.SingleStage);

        SingleStage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent numbersIntent = new Intent(MainActivity.this, SingleStage.class);
            startActivity(numbersIntent);
            }
        });

    }
}
