package com.example.rapypago;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarseActivity2 extends AppCompatActivity {

    Button registarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse2);

        registarUsuario = findViewById(R.id.buttonRegistrarUsuario);

        /**Con la siguiente linea de codigo, damos a entender que debe hacer
         * la maquina si apretamos el boton (Registrar Usuario).
         **/
        registarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText auxINTRut = findViewById(R.id.editTextRUT);
                EditText auxTxtNombres = findViewById(R.id.editTextTextNombres);
                EditText auxTxtApellidos = findViewById(R.id.editTextTextApellidos);
                EditText auxTxtCorreo = findViewById(R.id.editTextTextEmail);
                EditText auxTxtContraseña = findViewById(R.id.editTextTextContraseña);
                EditText auxTxtValidar = findViewById(R.id.editTextTextValidar);
                EditText auxTxtJuegos = findViewById(R.id.editTextTextJuegos);

                String contraseña = auxTxtContraseña.getText().toString();
                String validar = auxTxtValidar.getText().toString();

                if (validadContraseña(contraseña,validar) == true){

                    try {
                        Usuario auxUsuario = new Usuario();
                        auxUsuario.setRut(Integer.parseInt(auxINTRut.getText().toString()));
                        auxUsuario.setNombres(auxTxtNombres.getText().toString());
                        auxUsuario.setApellidos(auxTxtApellidos.getText().toString());
                        auxUsuario.setCorreo(auxTxtCorreo.getText().toString());
                        auxUsuario.setContraseña(auxTxtContraseña.getText().toString());
                        auxUsuario.setJuegos(auxTxtJuegos.getText().toString());


                        MantenedorUsuario auxMantenedor = new MantenedorUsuario(RegistrarseActivity2.this);
                        auxMantenedor.insertarUsuario(auxUsuario);
                        mensaje("Datos guardados ");
                        auxINTRut.setText("");
                        auxTxtNombres.setText("");
                        auxTxtApellidos.setText("");
                        auxTxtCorreo.setText("");
                        auxTxtContraseña.setText("");
                        auxTxtValidar.setText("");
                        auxTxtJuegos.setText("");
                        auxINTRut.requestFocus();

                        Intent intent = new Intent(RegistrarseActivity2.this,MainActivity.class);
                        startActivity(intent);

                    } catch (Exception ex) {
                        mensaje("Datos NO guardados " + ex.getMessage());
                        Intent intent = new Intent(RegistrarseActivity2.this,MainActivity.class);
                        startActivity(intent);
                    }

                } else{
                    mensaje("Las contraseñas son distintas, verifiqué que sean iguales.");
                }

            }

        });

    }

    public void mensaje(String texto){

        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }

    public boolean validadContraseña (String password, String validate){
        EditText auxpassword = findViewById(R.id.editTextTextContraseña);
        EditText auxvalidate = findViewById(R.id.editTextTextValidar);

        password = auxpassword.getText().toString();
        validate = auxvalidate.getText().toString();

        if (password.equals(validate)) {
            return true;
        }else{
            return false;
        }
    }


  }
