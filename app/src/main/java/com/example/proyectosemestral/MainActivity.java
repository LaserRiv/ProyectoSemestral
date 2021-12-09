package com.example.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] opciones = {"Presentación", "Sensor 1 Temperatura", "Sensor 2 Proximidad"};
    String[] msg = {"Presentación", "Sensor 1 Temperatura", "Sensor 2 Proximidad"};
    private Button button;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opciones);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                changeActivity(pos);
            }
        });
    }

    private void changeActivity(int pos) {
        if(pos == 0){
            Intent intent = new Intent(this, Presentacion.class);
            startActivity(intent);
        }
        else if(pos == 1){
            Intent intent = new Intent(this, Sensor1.class);
            startActivity(intent);
        }
        else if(pos == 2){
            Intent intent = new Intent(this, Sensor2.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        pos = position;
        Toast.makeText(getApplicationContext(),  msg[position]  , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}