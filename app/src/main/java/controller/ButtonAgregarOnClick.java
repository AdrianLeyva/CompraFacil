package controller;


import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import comprafacil.myapp.root.comprafacil.R;
import model.Producto;

/**
 * Created by leyva on 24/05/2016.
 */
public class ButtonAgregarOnClick implements View.OnClickListener {
    private int position;
    private EditText cantidad;
    private ArrayList<Producto> listaProducto;
    private Context context;

    public ButtonAgregarOnClick(int position,EditText cantidad,ArrayList<Producto> listaProducto,Context context){
        this.position = position;
        this.cantidad = cantidad;
        this.listaProducto = listaProducto;
        this.context = context;
    }
    @Override
    public void onClick(View v) {

        int totalProductos = listaProducto.get(position).getCantidad();

        if (cantidad.getText().toString() == "") {
            listaProducto.get(position).setCantidad(totalProductos + 1);
            cantidad.setHint(String.valueOf(totalProductos + 1));
        }
        else{
            int cantidadEditText = Integer.valueOf(cantidad.getText().toString());
            int total = totalProductos + cantidadEditText;
            listaProducto.get(position).setCantidad(total);
            cantidad.setHint(String.valueOf(total));
        }

        Toast toast = Toast.makeText(context,"Funciona",Toast.LENGTH_SHORT);
        toast.show();
    }
}
