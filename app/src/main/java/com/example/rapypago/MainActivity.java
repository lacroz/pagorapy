package com.example.rapypago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnIgnresar(View view){
        Intent intent = new Intent(MainActivity.this, IngresarActivity2.class);
        startActivity(intent); //Con esto abrimos la otra ventana.
    }

    public void btnRegistarse (View view){
        Intent intent2 = new Intent(MainActivity.this, RegistrarseActivity2.class);
        startActivity(intent2);
    }

    public void btnConsulta (View view){
        Intent intent3 = new Intent(MainActivity.this, ConsultasActivity2.class);
        startActivity(intent3);
    }
}