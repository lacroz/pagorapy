package com.example.rapypago;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MantenedorUsuario extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "basedatos.db";
    private static final String TABLA_USUARIO = "CREATE TABLE Usuario (rut int PRIMARY KEY,nombres String, apellidos String, correo String,contraseña String, juegos String)";

    public MantenedorUsuario(Context context){
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db){
        db.execSQL(TABLA_USUARIO);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '"+ TABLA_USUARIO +"'");
    }

    //CRUD
    //Insertar Usuario
    public void insertarUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            String varSQL = "INSERT INTO Usuario" +
                            "(rut, nombres, apellidos, correo,contraseña,juegos) VALUES ('" +
                            usuario.getRut()+"' , '"+usuario.getNombres()+"' , '"+usuario.getApellidos()
                            +"' , '"+usuario.getCorreo() +" ' , '"+usuario.getContraseña()+ " ',' "
                            + usuario.getJuegos()+"');" ;
            db.execSQL(varSQL);
        }
        db.close();
    }

    //Actualizar Usuario
    public void actualizarrUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            String varSQL = "UPDATE Usuario " +
                            " SET " +
                            "Nombres = ' "+usuario.getNombres()+" '" +
                            "Apellidos = '"+usuario.getApellidos()+" '" +
                            "Correo = '"+usuario.getCorreo()+" '" +
                            "Contraseña = " +usuario.getContraseña()+" '"+
                            "WHERE rut = '"+usuario.getRut() +" ';";
            db.execSQL(varSQL);
        }
        db.close();
    }

    //eliminar Usuario
    public void eliminarUsuario(int rut){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            String varSQL = "DELETE FROM Usuario" +
                            "WHERE rut = '"+rut +" ';";
            db.execSQL(varSQL);
        }
        db.close();
    }

    //eliminar TODOS LOS Usuario
    public void eliminarTodosUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            String varSQL = "DELETE FROM Usuario; ";
            db.execSQL(varSQL);
        }
        db.close();
    }

    //Retornar Todos los Usuarios
    public List<Usuario> retornarUsuarios(){
        SQLiteDatabase db = getWritableDatabase();
        List<Usuario> auxListUsuario = new ArrayList<>();

        Cursor auxCursor = db.rawQuery("SELECT * FROM Usuario", null);

        auxCursor.moveToFirst(); //mover el cursor al inicio de la lista.

        do{
            Usuario auxUsuario = new Usuario();
            auxUsuario.setRut(auxCursor.getInt(0));
            auxUsuario.setNombres(auxCursor.getString(1));
            auxUsuario.setApellidos(auxCursor.getString(2));
            auxUsuario.setCorreo(auxCursor.getString(3));
            auxListUsuario.add(auxUsuario);

        }while(auxCursor.moveToNext()); //Se mueve al siguiente registro.
        auxCursor.close();
        db.close();
        return auxListUsuario;

    }

    //Buscar Usuarios
    public Usuario buscaUsuario (int rut){
        SQLiteDatabase db = getWritableDatabase();
        Usuario auxUsuario = new Usuario();

        Cursor auxCursor = db.rawQuery("SELECT * FROM Usuario " +
                "WHERE rut = + 'rut+';", null);

        try{

            auxCursor.moveToFirst(); //mover el cursor al inicio de la lista.
            auxUsuario.setRut(auxCursor.getInt(0));
            auxUsuario.setNombres(auxCursor.getString(1));
            auxUsuario.setApellidos(auxCursor.getString(2));
            auxUsuario.setCorreo(auxCursor.getString(3));

        }catch(Exception ex){
            auxUsuario.setRut(0);
            auxUsuario.setNombres("");
            auxUsuario.setApellidos("");
            auxUsuario.setCorreo("");
        }

        auxCursor.close();
        db.close();
        return auxUsuario;

    }

    public boolean verificarUsuario(int id, String password){
        SQLiteDatabase db = getWritableDatabase();
        Usuario auxUsuario = new Usuario();
        String validate;

        Cursor auxCursor = db.rawQuery("SELECT * FROM Usuario " +
                "WHERE rut = + 'id+';", null);
        try {
            auxCursor.moveToFirst(); //mover el cursor al inicio de la lista.
            auxUsuario.setRut(auxCursor.getInt(0));
            auxUsuario.setNombres(auxCursor.getString(1));
            auxUsuario.setApellidos(auxCursor.getString(2));
            auxUsuario.setCorreo(auxCursor.getString(3));
            auxUsuario.setContraseña(auxCursor.getString(4));
            auxUsuario.setJuegos(auxCursor.getString(5));

        }catch(Exception ex){
            auxUsuario.setRut(0);
            auxUsuario.setNombres("");
            auxUsuario.setApellidos("");
            auxUsuario.setCorreo("");
            auxUsuario.setContraseña("");
            auxUsuario.setJuegos("");
        }
        validate = auxUsuario.getContraseña();

        if(validate.equals(password)){
            auxCursor.close();
            db.close();
            return true;
        }else{
            auxCursor.close();
            db.close();
            return false;
        }

    }

}
