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
        listaProductos.add(new Producto("Bebidas", "Te", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Del valle", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Fanta", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Fresca", 10, 23));
    }

    public ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }


}
