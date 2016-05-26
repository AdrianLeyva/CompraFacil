package persistencia;

import java.util.ArrayList;
import model.Producto;


/**
 * Created by kevingamboa17 on 19/05/16.
 */
public class ProvisionalInventario {

    private ArrayList<Producto> listaProductos;

    public ProvisionalInventario() {
        listaProductos = new ArrayList<Producto>();
        listaProductos.add(new Producto("Bebidas", "Pepsi", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Coca", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Sprite", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Manzana", 10, 23));
        listaProductos.add(new Producto("Botanas", "Charritos", 10, 23));
        listaProductos.add(new Producto("Botanas", "Chicharrones", 10, 23));
        listaProductos.add(new Producto("Botanas", "Nachos", 10, 23));
        listaProductos.add(new Producto("Dulces", "Rockaleta", 10, 23));
        listaProductos.add(new Producto("Dulces", "Chicles", 10, 23));
        listaProductos.add(new Producto("Dulces", "Paletas", 10, 23));
        listaProductos.add(new Producto("Galletas", "Emperador", 10, 23));
        listaProductos.add(new Producto("Galletas", "Conquistador", 10, 23));
        listaProductos.add(new Producto("Galletas", "Soles", 10, 23));
        listaProductos.add(new Producto("Galletas", "Canelitas", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Doritos", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Rancheritos", 10, 23));
        listaProductos.add(new Producto("Postres", "Napolitano", 10, 23));
        listaProductos.add(new Producto("Postres", "Pastel", 10, 23));
        listaProductos.add(new Producto("Postres", "Helado", 10, 23));
    }

    public ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }


}
