package com.example.pablo.pymtrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pablo.pymtrack.Modelo.ListaLocalSushiAdapter;
import com.example.pablo.pymtrack.Modelo.PymDataBaseHelper;

public class ListaSushiActivity extends AppCompatActivity {

    PymDataBaseHelper helper = new PymDataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sushi);

        final ListView lista=(ListView)findViewById(R.id.lista_locales_sushi);

        ListaLocalSushiAdapter hostalAdapter=new ListaLocalSushiAdapter(this,helper.listaImgSushi(helper.getReadableDatabase()),
                helper.listaNombreSushi(helper.getReadableDatabase()),helper.listaDireccionSushi(helper.getReadableDatabase()),
                helper.listaHorarioSushi(helper.getReadableDatabase()));

        lista.setAdapter(hostalAdapter);
    }

    public void mapaSuchiOnClick(View view){
        Intent intent=new Intent(this,SuchiMapsActivity.class);
        startActivity(intent);
    }
}
