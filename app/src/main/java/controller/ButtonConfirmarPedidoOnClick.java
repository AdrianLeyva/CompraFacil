package controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import comprafacil.myapp.root.comprafacil.AdministradorActivity;
import model.Producto;
import persistencia.PedidosSQLiteOpenHelper;

/**
 * Created by leyva on 29/05/2016.
 */
public class ButtonConfirmarPedidoOnClick implements View.OnClickListener {
    private ArrayAdapter<Producto> adaptador;
    private ArrayList<Producto> listaProductos;
    private AdministradorActivity vista;

    public ButtonConfirmarPedidoOnClick(ArrayAdapter<Producto> adaptador,ArrayList<Producto> listaProductos,AdministradorActivity vista){
        this.adaptador = adaptador;
        this.listaProductos = listaProductos;
        this.vista = vista;
    }
    @Override
    public void onClick(View v) {
        ControladorPedidos controladorPedidos = new ControladorPedidos(vista);
        controladorPedidos.confirmarPedido(vista,adaptador,listaProductos);
    }
}
