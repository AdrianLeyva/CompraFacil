package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import comprafacil.myapp.root.comprafacil.GestionarInventario;
import model.Producto;
import persistencia.EmpleadosSQLiteOpenHelper;
import persistencia.InventarioSQLiteOpenHelper;

/**
 * Created by leyva on 27/05/2016.
 */
public class ControladorInventario {
    private ArrayList<Producto> listaProductos;
    private Context vista;

    public ControladorInventario(Context vista){
        this.vista = vista;
    }

    public ArrayList<Producto> getInventario(){
        listaProductos = new ArrayList<>();
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(vista,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from productos",null);
        while (fila.moveToNext()){
            Producto producto = new Producto(fila.getString(0),fila.getString(1),fila.getFloat(2),fila.getInt(3));
            listaProductos.add(producto);
        }
        return listaProductos;
    }

    public void agregarNuevoProducto(String categoria,String nombre,float precio, int cantidad){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(vista,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("categoria",categoria);
        registro.put("nombre",nombre);
        registro.put("precio",precio);
        registro.put("cantidad",cantidad);
        bd.insert("productos",null,registro);
        bd.close();
    }

    public void eliminarProducto(GestionarInventario vista, ArrayList<Producto> lista, int position){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(vista,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("productos", null, null);
        ContentValues registro = new ContentValues();
        for(int i =0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("categoria",lista.get(i).getCategoria());
            registro.put("precio",lista.get(i).getPrecio());
            registro.put("cantidad",lista.get(i).getCantidad());
            bd.insert("productos",null,registro);
        }
        bd.close();
    }

    public void restablecerInventario(){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(vista,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("productos", null, null);
    }

    public void actualizarInventario(ArrayList<Producto> lista){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(vista,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("productos",null,null);

        ContentValues registro = new ContentValues();
        for(int i=0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("categoria",lista.get(i).getCategoria());
            registro.put("precio",lista.get(i).getPrecio());
            registro.put("cantidad",lista.get(i).getCantidad());
            bd.insert("productos",null,registro);
        }
        bd.close();
    }
}
