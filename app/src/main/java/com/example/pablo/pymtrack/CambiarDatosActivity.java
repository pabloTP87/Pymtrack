package com.example.pablo.pymtrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.pymtrack.Modelo.PymDataBaseHelper;

public class CambiarDatosActivity extends AppCompatActivity {

    PymDataBaseHelper helper = new PymDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);
    }

    public void cambioContraseñaOnClick(View view){
        String mensaje;
        String correo=((EditText)findViewById(R.id.ingresoCorreo)).getText().toString();
        String clave=((EditText)findViewById(R.id.contraseñaNueva)).getText().toString();

        mensaje=helper.cambioContraseña(correo,clave);

        Toast toast=Toast.makeText(this,mensaje,Toast.LENGTH_SHORT);
        toast.show();
        finish();

    }
}
