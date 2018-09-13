package com.example.pablo.pymtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pablo.pymtrack.Modelo.ListaLocalHostalAdapter;
import com.example.pablo.pymtrack.Modelo.PymDataBaseHelper;

public class ListaHostalActivity extends AppCompatActivity {

    PymDataBaseHelper helper = new PymDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_hostal);

        final ListView lista=(ListView)findViewById(R.id.lista_locales_hostal);

        ListaLocalHostalAdapter hostalAdapter=new ListaLocalHostalAdapter(this,helper.listaImgHostal(helper.getReadableDatabase()),
                helper.listaNombreHostal(helper.getReadableDatabase()),helper.listaDireccionHostal(helper.getReadableDatabase()),
                helper.listaHorarioHostal(helper.getReadableDatabase()));

        lista.setAdapter(hostalAdapter);
    }

    public void mapaHostalOnClick(View view){
        Intent intent=new Intent(this,HostalMapsActivity.class);
        startActivity(intent);
    }
}
