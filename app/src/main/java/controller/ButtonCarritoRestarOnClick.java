package controller;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
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
    private ArrayAdapter<Producto> adaptador;

    public ButtonCarritoRestarOnClick(int position,TextView cantidad,ArrayList<Producto> listaProducto,Context context,ArrayAdapter<Producto> adaptador){
        this.position = position;
        this.cantidad = cantidad;
        this.listaProducto = listaProducto;
        this.context = context;
        this.adaptador = adaptador;
    }

    @Override
    public void onClick(View v) {
        int totalProductos = listaProducto.get(position).getCantidad();

        if(totalProductos == 1){
            listaProducto.remove(position);
            adaptador.notifyDataSetChanged();
        }
        else{
            listaProducto.get(position).setCantidad(totalProductos - 1);
            cantidad.setText(String.valueOf(totalProductos - 1));
        }

    }
}
