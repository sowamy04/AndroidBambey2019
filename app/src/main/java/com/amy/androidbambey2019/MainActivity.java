package com.amy.androidbambey2019;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivity", "Le bouton flotant est cliqué");
                Snackbar.make(view, "Le bouton flottant est cliqué", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        bouton = (Button) findViewById(R.id.button);
        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "Merci d'avoir cliqué");
                Toast.makeText(getApplicationContext(), "Le bouton est cliqué", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                Log.i("MainActivity", " " + intent);
                startActivity(intent);
            }
        });
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
            Log.i("MainActivity", "Bouton de paramettrage");
            Toast.makeText(getApplicationContext(), "Le bouton de paraméttrage est cliqué", Toast.LENGTH_LONG).show();
        }

        else  if (id == R.id.action_help){
            Log.i("MainActivity", "Bouton d'aide");
            Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(intent);
        }

        //return true;

        return super.onOptionsItemSelected(item);
    }


}
