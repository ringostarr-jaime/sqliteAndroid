package com.example.usuario.usuario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Usuario on 11/10/2016.
 */
public class Base extends SQLiteOpenHelper {
    public Base(Context context) {
        super(context, "usuarios",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String st ="create table usu(id integer primary key autoincrement, nombre text not null, usuario text not null, clave text not null,tipo integer not null)";
        db.execSQL(st);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
