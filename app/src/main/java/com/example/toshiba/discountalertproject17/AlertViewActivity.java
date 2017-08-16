package com.example.toshiba.discountalertproject17;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AlertViewActivity extends AppCompatActivity {

    private Activity activity;
    private TextView bankname,discount,place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_view);
        bankname= (TextView) findViewById(R.id.bname);
        discount= (TextView) findViewById(R.id.discount);
        place = (TextView) findViewById(R.id.place);
        Intent intent = getIntent();
        bankname.setText(intent.getStringExtra("bname"));
        discount.setText(intent.getStringExtra("discount"));
        place.setText(intent.getStringExtra("place"));
    }
}
