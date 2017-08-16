package com.example.toshiba.discountalertproject17;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        loginFragment logFragment = new loginFragment(this);
        fragmentManager.beginTransaction().add(R.id.fragmentcontainer, logFragment).commit();
    }
}
