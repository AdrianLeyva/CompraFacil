package controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import comprafacil.myapp.root.comprafacil.AdministradorActivity;
import model.Producto;
import persistencia.PedidosSQLiteOpenHelper;

/**
 * Created by leyva on 29/05/2016.
 */
public class ControladorPedidos {
    private Context vista;
    public ControladorPedidos(Context vista){
        this.vista = vista;
    }

    public ArrayList<Producto> getPedidos(){
        ArrayList<Producto> listaPedidos = new ArrayList<>();
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from pedidos",null);
        while(fila.moveToNext()){
            Producto producto = new Producto(fila.getString(0),fila.getString(1),fila.getFloat(2),fila.getInt(3));
            listaPedidos.add(producto);
        }
        bd.close();
        return listaPedidos;
    }

    public void agregarProducto(ArrayList<Producto> lista){
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("pedidos",null,null);
        ContentValues registro = new ContentValues();
        for(int i=0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("categoria",lista.get(i).getCategoria());
            registro.put("precio",lista.get(i).getPrecio());
            registro.put("cantidad",lista.get(i).getCantidad());
            bd.insert("pedidos",null,registro);
        }
        bd.close();
    }

    public void restarProducto(ArrayList<Producto> lista){
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("pedidos",null,null);
        ContentValues registro = new ContentValues();
        for(int i=0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("categoria",lista.get(i).getCategoria());
            registro.put("precio",lista.get(i).getPrecio());
            registro.put("cantidad",lista.get(i).getCantidad());
            bd.insert("pedidos",null,registro);
        }
        bd.close();
    }

    public void eliminarProducto(ArrayList<Producto> lista){
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("pedidos",null,null);
        ContentValues registro = new ContentValues();
        for(int i=0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("categoria",lista.get(i).getCategoria());
            registro.put("precio",lista.get(i).getPrecio());
            registro.put("cantidad",lista.get(i).getCantidad());
            bd.insert("pedidos",null,registro);
        }
        bd.close();
    }

    public void confirmarCompra(ArrayAdapter<Producto> adaptador,ArrayList<Producto> listaProductos,TextView textViewTotalCompra){
        listaProductos.clear();
        adaptador.notifyDataSetChanged();

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductos.size();i++){

            int cantidad = listaProductos.get(i).getCantidad();
            float precio = listaProductos.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));

        Toast toast = Toast.makeText(vista,"Compra realizada",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void cancelarCompra(ArrayAdapter<Producto> adaptador,ArrayList<Producto> listaProductos,TextView textViewTotalCompra){
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("pedidos", null, null);
        listaProductos.clear();
        adaptador.notifyDataSetChanged();

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductos.size();i++){

            int cantidad = listaProductos.get(i).getCantidad();
            float precio = listaProductos.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));

        Toast toast = Toast.makeText(vista,"Compra cancelada",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void confirmarPedido(AdministradorActivity vista,ArrayAdapter<Producto> adaptador,ArrayList<Producto> listaProductos){
        PedidosSQLiteOpenHelper admin = new PedidosSQLiteOpenHelper(vista,"compra_facil3",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("pedidos",null,null);
        listaProductos.clear();
        adaptador.notifyDataSetChanged();
        Toast toast = Toast.makeText(vista, "Pedido confirmado", Toast.LENGTH_SHORT);
        toast.show();
    }
}
