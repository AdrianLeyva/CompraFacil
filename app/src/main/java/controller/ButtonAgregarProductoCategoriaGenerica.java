package controller;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by kevingamboa17 on 25/05/16.
 */
public class ButtonAgregarProductoCategoriaGenerica implements View.OnClickListener {
    private int position;
    private ArrayList<Producto> listaCategoria;
    private ArrayList<Producto> listaProductoCarrito;
    private Context context;
    private ArrayAdapter<Producto> adaptador;
    private int h=0;
    private int bandera;
    private String nombre;
    private TextView textViewTotalCompra;

    public ButtonAgregarProductoCategoriaGenerica(int position, ArrayList<Producto> listaProductoCarrito, Context context, ArrayList<Producto> listaCategoria, ArrayAdapter<Producto> adaptador,TextView textViewTotalCompra){
        this.position = position;
        this.listaProductoCarrito = listaProductoCarrito;
        this.listaCategoria = listaCategoria;
        this.context = context;
        this.adaptador = adaptador;
        this.bandera = 0;
        this.textViewTotalCompra = textViewTotalCompra;
    }

    @Override
    public void onClick(View v) {

        for (int i=0; i<listaProductoCarrito.size(); i++){
            this.nombre = listaProductoCarrito.get(i).getNombre().toString();


            if (listaProductoCarrito.get(i).getNombre().compareTo(listaCategoria.get(position).getNombre()) == 0 ){
                h = Integer.valueOf(listaProductoCarrito.get(i).getCantidad());
                h += 1;

                listaProductoCarrito.get(i).setCantidad(h);
                adaptador.notifyDataSetChanged();
                bandera = 1;
                break;
            }


        }
        if(bandera == 0){
            listaProductoCarrito.add(listaCategoria.get(position));
            adaptador.notifyDataSetChanged();
        }

        ControladorPedidos controladorPedidos = new ControladorPedidos(context);
        controladorPedidos.agregarProducto(listaProductoCarrito);

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductoCarrito.size();i++){

            int cantidad = listaProductoCarrito.get(i).getCantidad();
            float precio = listaProductoCarrito.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));

    }
}

