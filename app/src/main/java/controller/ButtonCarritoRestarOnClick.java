package controller;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 25/05/2016.
 */
public class ButtonCarritoRestarOnClick implements View.OnClickListener {
    private int position;
    private TextView cantidad;
    private ArrayList<Producto> listaProducto;
    private Context context;

    public ButtonCarritoRestarOnClick(int position,TextView cantidad,ArrayList<Producto> listaProducto,Context context){
        this.position = position;
        this.cantidad = cantidad;
        this.listaProducto = listaProducto;
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        int totalProductos = listaProducto.get(position).getCantidad();

        if(totalProductos == 1){
            listaProducto.remove(position);
        }
        else{
            listaProducto.get(position).setCantidad(totalProductos - 1);
            cantidad.setText(String.valueOf(totalProductos - 1));
        }

    }
}
