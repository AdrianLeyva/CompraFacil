package controller;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import comprafacil.myapp.root.comprafacil.GestionarInventario;
import model.Producto;

/**
 * Created by leyva on 24/05/2016.
 */
public class ButtonEliminarOnClick implements View.OnClickListener {
    int position;
    ArrayList<Producto> listaProductos;
    Context context;
    ArrayAdapter<Producto> adaptador;
    GestionarInventario vista;

    public ButtonEliminarOnClick(int position,ArrayList<Producto> listaProductos,Context context,ArrayAdapter<Producto> adaptador,GestionarInventario vista){
        this.position = position;
        this.listaProductos = listaProductos;
        this.context = context;
        this.adaptador = adaptador;
        this.vista = vista;
    }

    @Override
    public void onClick(View v) {
        listaProductos.remove(position);
        ControladorInventario controladorInventario = new ControladorInventario(vista);
        controladorInventario.eliminarProducto(vista, listaProductos, position);
        adaptador.notifyDataSetChanged();
    }
}
