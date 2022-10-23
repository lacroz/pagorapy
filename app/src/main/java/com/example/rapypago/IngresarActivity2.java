package com.example.rapypago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IngresarActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar2);
    }

    public void btnIniciarSesion(View view){

        Usuario auxUsuario = new Usuario();
        MantenedorUsuario auxMantenedor = new MantenedorUsuario(IngresarActivity2.this);

        EditText auxIniciarRut = findViewById(R.id.editTextRutIngresar);
        EditText auxIniciarContraseña = findViewById(R.id.editTextTextContraseñaIngresar);

        int id = Integer.parseInt(auxIniciarRut.getText().toString());
        String password = auxIniciarContraseña.getText().toString();


        //Funciona pero NO en su totalidad, el if me tiene webiado
        if (auxMantenedor.verificarUsuario(id,password) == true){
            Intent intent = new Intent(IngresarActivity2.this, MenuSesionActivity3.class);
            startActivity(intent); //Con esto abrimos la otra ventana.
        }else{
            Intent intent = new Intent(IngresarActivity2.this, IngresarActivity2.class);
            startActivity(intent); //Con esto abrimos la otra ventana.
            mensaje("No son correctas las etiquetas.");
        }

    }

    public void mensaje(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }


}