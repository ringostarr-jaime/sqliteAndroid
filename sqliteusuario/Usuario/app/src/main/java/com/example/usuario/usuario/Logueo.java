package com.example.usuario.usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Logueo extends AppCompatActivity {

//Defino las variables 
    EditText t1, t2, t3;
    String tipo;
    String id;
    RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logueo);

//Casteo de la variable e inicializacion
        t1 = (EditText) findViewById(R.id.editText2);
        t2 = (EditText) findViewById(R.id.editText3);
        t3 = (EditText) findViewById(R.id.editText4);

        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        r3 = (RadioButton) findViewById(R.id.radioButton3);

//Creamos el bundle para obtener los datos
        Bundle bn = getIntent().getExtras();
        t1.setText(bn.getString("usuario"));
        t2.setText(bn.getString("clave"));
        t3.setText(bn.getString("nombre"));
        id = bn.getString("id");

        tipo = bn.getString("tipo");
        evaluartipo();

    }

    public void evaluartipo() {
        switch (tipo) {
            case "1":
                r1.setChecked(true);
                break;
            case "2":
                r2.setChecked(true);
                break;
            case "3":
                r3.setChecked(true);
                break;
        }

    }

    public void regresar(View v) {
        Intent tn = new Intent(this, Actividad.class);
        startActivity(tn);
    }


    public void modificar(View v) {
        if(!TextUtils.isEmpty(t1.getText().toString()) & !TextUtils.isEmpty(t2.getText().toString()) & !TextUtils.isEmpty(t3.getText().toString())) {
            Usuarios us = new Usuarios(this);
            us.setUsuario(t1.getText().toString());
            us.setPass(t2.getText().toString());
            us.setNombre(t3.getText().toString());
            us.setId(id);

            if (r1.isChecked()) {
                us.setTipo("1");
            }
            if (r2.isChecked()) {
                us.setTipo("2");
            }
            if (r3.isChecked()) {
                us.setTipo("3");
            }

            us.modificar();
            Toast.makeText(this, us.getMensaje(), Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"No puede ir ninguna caja de texto vacia",Toast.LENGTH_SHORT).show();
        }
    }

    public void inse(View v) {
        if(!TextUtils.isEmpty(t1.getText().toString()) & !TextUtils.isEmpty(t2.getText().toString()) & !TextUtils.isEmpty(t3.getText().toString())) {
            Usuarios us = new Usuarios(this);
            us.setNombre(t3.getText().toString());
            us.setUsuario(t1.getText().toString());
            us.setPass(t2.getText().toString());
            String tip = "";
            if (r1.isChecked()) {
                tip = "1";
            }
            if (r2.isChecked()) {
                tip = "2";
            }
            if (r3.isChecked()) {
                tip = "3";
            }

            us.setTipo(tip);
            us.insertar();
            Toast.makeText(this, "Informacion guardada " + us.getMensaje(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"No puede ir ninguna caja de texto vacia",Toast.LENGTH_SHORT).show();
        }
    }


    public void eliminar(View v) {
        Usuarios us = new Usuarios(this);
        us.setId(id);
        us.eliminar();
        Toast.makeText(this, "Informacion eliminada", Toast.LENGTH_SHORT).show();
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t1.requestFocus();
    }


    public void limpiar(View v)
    {
        t1.setText("");t2.setText("");t3.setText("");t1.requestFocus(); r1.setChecked(true);
    }

}
