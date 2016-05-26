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
    private ArrayAdapter<Producto> adaptador2;

    public ButtonCarritoEliminarOnClick(int position,ArrayList<Producto> listaProductos,ArrayAdapter<Producto> adaptador, ArrayAdapter<Producto> adaptador2){
        this.position = position;
        this.listaProductos = listaProductos;
        this.adaptador = adaptador;
        this.adaptador2 = adaptador2;
    }

    public ButtonCarritoEliminarOnClick(int position,ArrayList<Producto> listaProductos,ArrayAdapter<Producto> adaptador){
        this.position = position;
        this.listaProductos = listaProductos;
        this.adaptador = adaptador;
    }
    @Override
    public void onClick(View v) {
        listaProductos.remove(position);
        adaptador.notifyDataSetChanged();
        adaptador2.notifyDataSetChanged();
    }
}
