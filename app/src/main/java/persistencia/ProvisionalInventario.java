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
        listaProductos.add(new Producto("Bebidas", "Pepsi", 10, 20));
        listaProductos.add(new Producto("Bebidas", "Coca-Cola", 11, 20));
        listaProductos.add(new Producto("Bebidas", "Sprite", 15, 15));
        listaProductos.add(new Producto("Bebidas", "Manzana", 16, 17));
        listaProductos.add(new Producto("Bebidas", "Te", 17, 23));
        listaProductos.add(new Producto("Bebidas", "Del valle", 18, 30));
        listaProductos.add(new Producto("Bebidas", "Fanta", 19, 25));
        listaProductos.add(new Producto("Bebidas", "Fresca", 11, 26));

        listaProductos.add(new Producto("Galletas", "Conquistador", 10, 20));
        listaProductos.add(new Producto("Galletas", "Emperador", 12, 15));
        listaProductos.add(new Producto("Galletas", "Mamut", 5, 30));
        listaProductos.add(new Producto("Galletas", "Crackets", 10, 10));
        listaProductos.add(new Producto("Galletas", "Triki-Trakes", 18, 40));
        listaProductos.add(new Producto("Galletas", "Soles", 15, 50));
        listaProductos.add(new Producto("Galletas", "Senzo", 13, 20));
        listaProductos.add(new Producto("Galletas", "Globitos", 12, 25));

        listaProductos.add(new Producto("Sabritas", "Doritos", 10, 20));
        listaProductos.add(new Producto("Sabritas", "Chetos", 6, 25));
        listaProductos.add(new Producto("Sabritas", "Crujitos",9, 29));
        listaProductos.add(new Producto("Sabritas", "Rancheritos", 4, 30));
        listaProductos.add(new Producto("Sabritas", "Churrumaiz", 2, 40));
        listaProductos.add(new Producto("Sabritas", "Papas", 10, 50));
        listaProductos.add(new Producto("Sabritas", "Rufles", 13, 37));
        listaProductos.add(new Producto("Sabritas", "Takis", 11, 5));

        listaProductos.add(new Producto("Dulces", "Tutsipop", 2, 40));
        listaProductos.add(new Producto("Dulces", "Rockaleta", 4, 20));
        listaProductos.add(new Producto("Dulces", "Bubaloo", 1, 25));
        listaProductos.add(new Producto("Dulces", "Panditas", 5, 21));
        listaProductos.add(new Producto("Dulces", "Pelonpelorico", 7, 24));
        listaProductos.add(new Producto("Dulces", "Panzon", 9, 29));
        listaProductos.add(new Producto("Dulces", "Lunetas", 6, 10));
        listaProductos.add(new Producto("Dulces", "Trident", 5, 5));

        listaProductos.add(new Producto("Postres", "Flan", 5, 30));
        listaProductos.add(new Producto("Postres", "Pastel", 10, 40));
        listaProductos.add(new Producto("Postres", "Brownie", 15, 39));
        listaProductos.add(new Producto("Postres", "Hojaldra", 13, 20));
        listaProductos.add(new Producto("Postres", "Napolitano", 20, 15));
        listaProductos.add(new Producto("Postres", "Helado", 8, 45));
        listaProductos.add(new Producto("Postres", "Frape", 25, 10));
        listaProductos.add(new Producto("Postres", "Chesscake", 30, 25));

        listaProductos.add(new Producto("Botanas", "Charritos", 10, 20));
        listaProductos.add(new Producto("Botanas", "Torritos", 15, 15));
        listaProductos.add(new Producto("Botanas", "Tostitos", 13, 18));
        listaProductos.add(new Producto("Botanas", "Nachos", 20, 30));
        listaProductos.add(new Producto("Botanas", "Chicharrones", 25, 40));
        listaProductos.add(new Producto("Botanas", "Cacahuates", 7, 50));
        listaProductos.add(new Producto("Botanas", "Pepitas", 5, 55));
        listaProductos.add(new Producto("Botanas", "Totopos", 22, 35));


    }

    public ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }


}
