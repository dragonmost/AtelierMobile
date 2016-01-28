package com.example.baker.atelier1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        float total = extras.getFloat("TOTAL");
        boolean taxe = extras.getBoolean("TAXE");
        float tip = extras.getFloat("TIP");
        int nbPep = extras.getInt("NBPEP");
        float result = extras.getFloat("RESULT");
    }
}
