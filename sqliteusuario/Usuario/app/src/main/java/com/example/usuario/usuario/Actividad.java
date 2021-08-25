package com.example.usuario.usuario;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Actividad extends AppCompatActivity {

//Defino las variables en este caso la caja de texto y una variable string para almacenarla
EditText t1;
String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);

//Casteo de la variable e inicializacion
        t1 =(EditText)findViewById(R.id.editText);
    }


//Metodo para buscar un usuario
    public void ver(View v)
    {
	//Captura del contenido de la caja de texto 
	usuario=t1.getText().toString();

	//Instanciamos la clase usuario para utilizar sus metodos
	//dado que esta clase espera un context le mandamos this	
        Usuarios us = new Usuarios(this);

	//Entramos al metodo ver de la clase Usuario y le mandamos lo capturado
        us.ver(usuario);

	//captura del mensaje
        String a = us.getMensaje();

//Si no hay mensaje
if(TextUtils.isEmpty(a))
{

//Declaracion de intent
    Intent tn = new Intent(getApplicationContext(),Logueo.class);

//Usando la clase Usuario obtenemos los datos
    tn.putExtra("nombre",us.getNombre());
    tn.putExtra("usuario",us.getUsuario());
    tn.putExtra("clave",us.getPass());
    tn.putExtra("tipo",us.getTipo());
    tn.putExtra("id",us.getId());

//Los mandamos a la clase logueo
    startActivity(tn);
}
else
{
    Toast.makeText(this,us.getMensaje(),Toast.LENGTH_SHORT).show();
}


     

    }




}
