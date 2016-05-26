package controller;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
    private TextView textViewTotalCompra;

    public ButtonCarritoEliminarOnClick(int position,ArrayList<Producto> listaProductos,ArrayAdapter<Producto> adaptador, ArrayAdapter<Producto> adaptador2,TextView textViewTotalCompra){
        this.position = position;
        this.listaProductos = listaProductos;
        this.adaptador = adaptador;
        this.adaptador2 = adaptador2;
        this.textViewTotalCompra = textViewTotalCompra;
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

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductos.size();i++){

            int cantidad = listaProductos.get(i).getCantidad();
            float precio = listaProductos.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));
    }
}
