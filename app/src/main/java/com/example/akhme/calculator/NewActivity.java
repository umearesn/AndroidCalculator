package com.example.akhme.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.Activity;

public class NewActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        Intent intentFromFirstPage = getIntent();
        TextView table = findViewById(R.id.result);
        table.setText(intentFromFirstPage.getStringExtra("cur_res"));

        Button btnToCalc = (Button) findViewById(R.id.goToCalculator);
        btnToCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView table = findViewById(R.id.table);
                //Context appContext = getApplicationContext();
                Intent intentToCalc = new Intent(NewActivity.this, MainActivity.class);
                //intentToCalc.putExtra("disp_res", table.getText().toString());
                startActivity(intentToCalc);
            }
        });

    }

}
