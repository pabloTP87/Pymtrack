package com.example.pablo.pymtrack.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pablo.pymtrack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 09/12/2017.
 */

public class PymDataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "pyme.db";
    private static final int DB_VERSION = 1;

    public PymDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlUsuarios="CREATE TABLE USUARIOS("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "CORREO TEXT, CONTRASEÑA TEXT);";

        db.execSQL(sqlUsuarios);

        String sqlLocales="CREATE TABLE LOCALES("
                + "id_ INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NOMBRE TEXT, DIRECCION TEXT, HORARIO TEXT, DESCRIPCION TEXT, "
                + "CATEGORIA TEXT, IMAGEN INTEGER);";

        db.execSQL(sqlLocales);
        //Locales de comida
        ingresarLocales(db,new Local("Sushi Zone","Av. España nº 1212","12:00 - 24:00",
                "Sushi, comida china, mariscos.","restorant",R.drawable.localsushi1));
        ingresarLocales(db,new Local("Master china","Los Generales nº 343","00:00 - 23:59",
                "Comida china, japonesa y tailandesa","restorant",R.drawable.localsushi2));
        ingresarLocales(db,new Local("Sushi delicias","Las gaviotas nº 12","12:00 - 24:00",
                "Sushi espacial","restorant",R.drawable.localsushi3));

        //Locales Hostal
        ingresarLocales(db,new Local("Hostal Ovejero","Errazuriz nº 908","00:00 - 23:59",
                "Comodas habitaciones, con desayuno.","hospedaje",R.drawable.hostal1));
        ingresarLocales(db,new Local("Hostal Parra","Av. Libertad nº 5656","00:00 - 23:59",
                "Cinco estrellas","hospedaje",R.drawable.hostal2));
        ingresarLocales(db,new Local("Hostal Violeta","Santa Juana nº 3355","00:00 - 23:59",
                "El mejor servicio, wifi gratis","hospedaje",R.drawable.hostal3));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS USUARIOS");
        db.execSQL("DROP TABLE IF EXISTS LOCALES");

        onCreate(db);
    }
    // metodo para ingresar usuarios a la base de datos
    public void ingresarUsuario(SQLiteDatabase db,Usuario usuario){
        ContentValues valores=new ContentValues();
        valores.put("CORREO",usuario.getCorreo());
        valores.put("CONTRASEÑA",usuario.getContraseña());

        db.insert("USUARIOS",null,valores);
    }

    // metodo para ingresar locales a la base de datos
    public void ingresarLocales(SQLiteDatabase db, Local local){
        ContentValues valores = new ContentValues();
        valores.put("NOMBRE",local.getNombre());
        valores.put("DIRECCION",local.getDireccion());
        valores.put("HORARIO",local.getHorario());
        valores.put("DESCRIPCION",local.getDescripcion());
        valores.put("CATEGORIA",local.getCategoria());
        valores.put("IMAGEN",local.getImagen());

        db.insert("LOCALES",null,valores);
    }

    // metodo para validar al usuario en el login
    public String validarUsuario (SQLiteDatabase db, String correo){

        Cursor cursor=db.rawQuery("SELECT CORREO, CONTRASEÑA FROM USUARIOS",null);
        String txtCorreo;
        String txtContraseña="No encontrado";
        if (cursor.moveToFirst()){
            do{
                txtCorreo=cursor.getString(0);


                if (txtCorreo.equals(correo)){
                   txtContraseña=cursor.getString(1);
                   break;
                }

            }while (cursor.moveToNext());
        }
        return txtContraseña;
    }

    // metodos para Lista de locales hostal adapter

    public List<Integer> listaImgHostal(SQLiteDatabase db){

        List<Integer> listaImg = new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT IMAGEN FROM LOCALES WHERE CATEGORIA='hospedaje'",null);
        cursor.moveToFirst();

        do{
            listaImg.add(cursor.getInt(0));
        }while (cursor.moveToNext());

        return listaImg;
    }

    public List<String> listaNombreHostal(SQLiteDatabase db){
        List<String> listaNombres = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT NOMBRE FROM LOCALES WHERE CATEGORIA='hospedaje'",null);
        cursor.moveToFirst();

        do {
            listaNombres.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaNombres;
    }

    public List<String> listaDireccionHostal(SQLiteDatabase db){
        List<String> listaDireccion = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT DIRECCION FROM LOCALES WHERE CATEGORIA='hospedaje'",null);
        cursor.moveToFirst();

        do {
            listaDireccion.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaDireccion;
    }

    public List<String> listaHorarioHostal(SQLiteDatabase db){
        List<String> listaHorario = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT HORARIO FROM LOCALES WHERE CATEGORIA='hospedaje'",null);
        cursor.moveToFirst();

        do {
            listaHorario.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaHorario;
    }

    // metodos para Lista de locales se sushi adapter

    public List<Integer> listaImgSushi(SQLiteDatabase db){

        List<Integer> listaImg = new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT IMAGEN FROM LOCALES WHERE CATEGORIA='restorant'",null);
        cursor.moveToFirst();

        do{
            listaImg.add(cursor.getInt(0));
        }while (cursor.moveToNext());

        return listaImg;
    }

    public List<String> listaNombreSushi(SQLiteDatabase db){
        List<String> listaNombres = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT NOMBRE FROM LOCALES WHERE CATEGORIA='restorant'",null);
        cursor.moveToFirst();

        do {
            listaNombres.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaNombres;
    }

    public List<String> listaDireccionSushi(SQLiteDatabase db){
        List<String> listaDireccion = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT DIRECCION FROM LOCALES WHERE CATEGORIA='restorant'",null);
        cursor.moveToFirst();

        do {
            listaDireccion.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaDireccion;
    }

    public List<String> listaHorarioSushi(SQLiteDatabase db){
        List<String> listaHorario = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT HORARIO FROM LOCALES WHERE CATEGORIA='restorant'",null);
        cursor.moveToFirst();

        do {
            listaHorario.add(cursor.getString(0));
        }while (cursor.moveToNext());

        return listaHorario;
    }

    public String cambioContraseña(String correo, String clave){
        String mensaje="Contraseña actualizada";
        String sqlText="UPDATE USUARIOS SET CONTRASEÑA = ? "+
                "WHERE CORREO = ?";

        Object[] argumentos=new Object[]{correo,clave};

        try{
            getWritableDatabase().execSQL(sqlText,argumentos);
        }catch (SQLException e){
            mensaje="Error al cambiar la contraseña";
            return mensaje;
        }
        return mensaje;
    }
}
