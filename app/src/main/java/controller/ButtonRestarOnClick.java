package controller;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 24/05/2016.
 */
public class ButtonRestarOnClick implements View.OnClickListener {
    private int position;
    private EditText cantidad;
    private ArrayList<Producto> listaProducto;
    private Context context;

    public ButtonRestarOnClick(int position,EditText cantidad,ArrayList<Producto> listaProducto,Context context){
        this.position = position;
        this.cantidad = cantidad;
        this.listaProducto = listaProducto;
        this.context = context;
    }
    @Override
    public void onClick(View v) {
        int totalProductos = listaProducto.get(position).getCantidad();

        if ((cantidad.getText().toString().equals(""))) {
            if(totalProductos>0){
                listaProducto.get(position).setCantidad(totalProductos - 1);
                cantidad.setHint(String.valueOf(totalProductos - 1));
            }
            else {
                Toast toast = Toast.makeText(context,"No puede eliminar más productos de los que tiene", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else{
            if(Integer.valueOf(cantidad.getText().toString())>totalProductos){
                Toast toast = Toast.makeText(context,"No puede eliminar más productos de los que tiene", Toast.LENGTH_SHORT);
                toast.show();
            }
            else {
                int cantidadEditText = Integer.valueOf(cantidad.getText().toString());
                int total = totalProductos - cantidadEditText;
                listaProducto.get(position).setCantidad(total);
                cantidad.setHint(String.valueOf(total));
                cantidad.setText("");
            }

        }
    }
}
