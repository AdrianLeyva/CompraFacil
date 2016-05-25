package controller;

import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 25/05/2016.
 */
public class ButtonCarritoEliminarOnClick implements View.OnClickListener {
    private int position;
    private ArrayList<Producto> listaProductos;
    private ArrayAdapter<Producto> adaptador;

    public ButtonCarritoEliminarOnClick(int position,ArrayList<Producto> listaProductos,ArrayAdapter<Producto> adaptador){
        this.position = position;
        this.listaProductos = listaProductos;
        this.adaptador = adaptador;
    }
    @Override
    public void onClick(View v) {
        listaProductos.remove(position);
        adaptador.notifyDataSetChanged();
    }
}
