package controller;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 24/05/2016.
 */
public class ButtonEliminarOnClick implements View.OnClickListener {
    int position;
    ArrayList<Producto> listaProductos;
    Context context;
    ArrayAdapter<Producto> adaptador;

    public ButtonEliminarOnClick(int position,ArrayList<Producto> listaProductos,Context context,ArrayAdapter<Producto> adaptador){
        this.position = position;
        this.listaProductos = listaProductos;
        this.context = context;
        this.adaptador = adaptador;
    }

    @Override
    public void onClick(View v) {
        listaProductos.remove(position);
        adaptador.notifyDataSetChanged();
    }
}
