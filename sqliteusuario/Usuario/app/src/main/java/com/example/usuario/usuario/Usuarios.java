package com.example.usuario.usuario;
import android.database.sqlite.SQLiteDatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Usuario on 11/10/2016.
 */
public class Usuarios {

    String nombre="", usuario="", tipo="",mensaje="",pass="", id="";


    Base da; SQLiteDatabase bd;

    public Usuarios(Context con) {
        da = new Base(con);
        bd = da.getWritableDatabase();
    }

    public void ver(String a) {

        Cursor fila = bd.rawQuery("select * from usu where usuario='"+a+"'", null);

        if (fila.moveToFirst()) {
            id =fila.getString(0);
            nombre = fila.getString(1);
            usuario  = fila.getString(2);
            pass  = fila.getString(3);
            tipo = String.valueOf(fila.getInt(4));
        } else {
mensaje ="No existe usuario";
        }

    }

    public void insertar()
    {
        bd.execSQL("insert into usu(nombre,usuario,clave,tipo)values('"+nombre+"','"+usuario+"','"+pass+"',"+tipo+")");

    }


    public void modificar()
    {
        String st ="update usu set nombre = '"+nombre+"',usuario ='"+usuario+"',clave ='"+pass+"',tipo ="+tipo+" where id = "+id+"";
       bd.execSQL(st);
      mensaje="Informacion procesada";

    }

    public void eliminar()
    {
        String st="delete from usu where id = "+id+"";
        bd.execSQL(st);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}