package com.example.pablo.pymtrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.pymtrack.Modelo.PymDataBaseHelper;
import com.example.pablo.pymtrack.Modelo.Usuario;


public class RegistroActivity extends AppCompatActivity {

    PymDataBaseHelper helper = new PymDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


    }

    public void registrarUsuario(View view){
        String correo=((EditText)findViewById(R.id.correo)).getText().toString();
        String contraseña=((EditText)findViewById(R.id.contraseña)).getText().toString();

        if(correo.compareTo("")!=0 && contraseña.compareTo("")!=0){
            Usuario usuario = new Usuario(correo,contraseña);
            helper.ingresarUsuario(helper.getWritableDatabase(),usuario);

            Toast toast=Toast.makeText(this,"Cuenta creada exitosamente!",Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }else {
            Toast toast=Toast.makeText(this,"Faltan ingresar datos!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
