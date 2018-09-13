package com.example.pablo.pymtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IndexCategoriasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_categorias);

    }

    public void hostalOnClik(View view){
        Intent intent = new Intent(this,ListaHostalActivity.class);
        startActivity(intent);
    }

    public void sushiOnClik(View view){
        Intent intent = new Intent(this,ListaSushiActivity.class);
        startActivity(intent);
    }

    public void cambiarDatosOnClick(View view){
        Intent intent=new Intent(this,CambiarDatosActivity.class);
        startActivity(intent);
    }
}
