package com.example.baker.atelier1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    EditText txtPrice;
    Switch switchTaxe;
    Button btnSubmit;
    NumberPicker nbPickTip;
    Spinner spinLangue;
    NumberPicker npickFriend;
    Intent startbuttonintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtPrice = (EditText) findViewById(R.id.txtPrice);
        switchTaxe = (Switch) findViewById(R.id.switchTaxe);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        nbPickTip = (NumberPicker) findViewById(R.id.npickTip);
        nbPickTip.setMinValue(5);
        nbPickTip.setMaxValue(25);
        nbPickTip.setWrapSelectorWheel(false);
        npickFriend = (NumberPicker) findViewById(R.id.npickFriends);
        npickFriend.setMinValue(1);
        npickFriend.setMaxValue(25);
        npickFriend.setWrapSelectorWheel(false);
        spinLangue = (Spinner) findViewById((R.id.spinLangue));
        spinLangue.setGravity(8);
        String[] langue = {"English", "Francais"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, langue);
        spinLangue.setAdapter(stringArrayAdapter);
    }

    @Override public void onClick(View v)
    {
        //int price = Integer.parseInt(txtPrice.getText().toString());

        boolean taxe = switchTaxe.isChecked();
        int tip = nbPickTip.getValue();
        int nbPep = npickFriend.getValue();

        float each =0;
        float totalWTip =0;
        float tipAmount =0;
        float total =0;

        if(!txtPrice.getText().toString().isEmpty())
        {
            total = Float.parseFloat(txtPrice.getText().toString());
            if(taxe)
            {
                total = total + (total * 0.15f);
            }
            tipAmount = total * ((float)tip / 100f) - total;
            totalWTip = total + tipAmount;
            each = total / nbPep;
        }
        else
            Toast.makeText(getApplicationContext(), "translation_error",Toast.LENGTH_SHORT).show();

        //total = Float.parseFloat("5.5");
        float round = (float)Math.round(total * 100f) / 100f;

        Toast.makeText(getApplicationContext(),Float.toString(total + tipAmount) ,Toast.LENGTH_SHORT).show();

        startbuttonintent = new Intent(this, SecondActivity.class);
        startbuttonintent.putExtra("TOTAL",total);
        startbuttonintent.putExtra("TAXE",taxe);
        startbuttonintent.putExtra("TIP",tip);
        startbuttonintent.putExtra("NBPEP",nbPep);
        startbuttonintent.putExtra("RESULT",total + tipAmount);
        startActivity(startbuttonintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
