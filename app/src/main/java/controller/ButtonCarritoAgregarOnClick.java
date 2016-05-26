package controller;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 25/05/2016.
 */
public class ButtonCarritoAgregarOnClick implements View.OnClickListener {
    private int position;
    private TextView cantidad;
    private ArrayList<Producto> listaProducto;
    private Context context;
    private TextView textViewTotalCompra;

    public ButtonCarritoAgregarOnClick(int position,TextView cantidad,ArrayList<Producto> listaProducto,Context context,TextView textViewTotalCompra){
        this.position = position;
        this.cantidad = cantidad;
        this.listaProducto = listaProducto;
        this.context = context;
        this.textViewTotalCompra = textViewTotalCompra;
    }

    @Override
    public void onClick(View v) {

        int totalProductos = listaProducto.get(position).getCantidad();
        listaProducto.get(position).setCantidad(totalProductos + 1);
        cantidad.setText(String.valueOf(totalProductos + 1));

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProducto.size();i++){

            int cantidad = listaProducto.get(i).getCantidad();
            float precio = listaProducto.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));

    }
}
