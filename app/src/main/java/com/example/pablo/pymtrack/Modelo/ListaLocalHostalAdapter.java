package com.example.pablo.pymtrack.Modelo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pablo.pymtrack.R;

import java.util.List;

/**
 * Created by Pablo on 11/12/2017.
 */

public class ListaLocalHostalAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<Integer> imagen;
    private final List<String> nombre;
    private final List<String> direccion;
    private final List<String> horario;

    public ListaLocalHostalAdapter(Activity context, List<Integer> imagen, List<String> nombre, List<String> direccion, List<String> horario) {
        super(context, R.layout.activity_lista_locales_hostal,nombre);
        this.context = context;
        this.imagen = imagen;
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
    }

    public View getView(int posicion, View view, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_lista_locales_hostal,null,true);

        ImageView img=(ImageView) rowView.findViewById(R.id.imagen_local_hostal);
        TextView txtNombre=(TextView) rowView.findViewById(R.id.nombre_local_hostal);
        TextView txtDireccion=(TextView) rowView.findViewById(R.id.direccion_local_hostal);
        TextView txtHorario=(TextView) rowView.findViewById(R.id.horario_local_hostal);

        img.setImageResource(imagen.get(posicion));
        txtNombre.setText(nombre.get(posicion));
        txtDireccion.setText(direccion.get(posicion));
        txtHorario.setText(horario.get(posicion));

        return rowView;

    }
}
