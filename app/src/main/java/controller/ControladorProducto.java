package controller;


import java.util.ArrayList;
import model.Producto;
import persistencia.ProvisionalInventario;

/**
 * Created by kevingamboa17 on 19/05/16.
 */
public class ControladorProducto {

    private ArrayList<Producto> productosPersistencia;
    ProvisionalInventario persistencia;

    public ControladorProducto() {
        //creando el objeto persistencia
        persistencia = new ProvisionalInventario();
    }


    //extraer la lista de los productos
    public ArrayList<Producto> getProductosPersistencia() {

        productosPersistencia = persistencia.getListaProductos();

        return productosPersistencia;
    }
}