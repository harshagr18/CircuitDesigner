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
            Intent LaunchSingle = new Intent(MainActivity.this, SingleStage.class);
            startActivity(LaunchSingle);
            }
        });


        Button MultiStage = (Button) findViewById(R.id.MultiStage);
        MultiStage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LaunchMulti = new Intent(MainActivity.this, MultiStage.class);
                startActivity(LaunchMulti);
            }
        });
    }
}
