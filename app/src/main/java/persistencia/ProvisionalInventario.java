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
        listaProductos.add(new Producto("Bebidas", "Cocadf", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Sprite", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Manzana", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Te", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Del valfdgle", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Fanta", 10, 23));
        listaProductos.add(new Producto("Bebidas", "Fresca", 10, 23));

        listaProductos.add(new Producto("Galletas", "Pepsi", 10, 23));
        listaProductos.add(new Producto("Galletas", "Codgdsca", 10, 23));
        listaProductos.add(new Producto("Galletas", "Sprite", 10, 23));
        listaProductos.add(new Producto("Galletas", "Mandgdsana", 10, 23));
        listaProductos.add(new Producto("Galletas", "Te", 10, 23));
        listaProductos.add(new Producto("Galletas", "Del valle", 10, 23));
        listaProductos.add(new Producto("Galletas", "Fanta", 10, 23));
        listaProductos.add(new Producto("Galletas", "Fresca", 10, 23));

        listaProductos.add(new Producto("Sabritas", "Pedgsdpsi", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Coca", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Sprite", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Masdganzana", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Te", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Del valle", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Fanta", 10, 23));
        listaProductos.add(new Producto("Sabritas", "Fresca", 10, 23));

        listaProductos.add(new Producto("Dulces", "Pepsi", 10, 23));
        listaProductos.add(new Producto("Dulces", "Coca", 10, 23));
        listaProductos.add(new Producto("Dulces", "Sprite", 10, 23));
        listaProductos.add(new Producto("Dulces", "Mandgzana", 10, 23));
        listaProductos.add(new Producto("Dulces", "Tdge", 10, 23));
        listaProductos.add(new Producto("Dulces", "Ddgsel valle", 10, 23));
        listaProductos.add(new Producto("Dulces", "Fanta", 10, 23));
        listaProductos.add(new Producto("Dulces", "Frsdsgesca", 10, 23));

        listaProductos.add(new Producto("Postres", "Pepdgssi", 10, 23));
        listaProductos.add(new Producto("Postres", "Cosdgca", 10, 23));
        listaProductos.add(new Producto("Postres", "Spsgrite", 10, 23));
        listaProductos.add(new Producto("Postres", "Madgsnzana", 10, 23));
        listaProductos.add(new Producto("Postres", "Te", 10, 23));
        listaProductos.add(new Producto("Postres", "Del valle", 10, 23));
        listaProductos.add(new Producto("Postres", "Fanta", 10, 23));
        listaProductos.add(new Producto("Postres", "Frdsgesca", 10, 23));

        listaProductos.add(new Producto("Botanas", "Pepsi", 10, 23));
        listaProductos.add(new Producto("Botanas", "Codgca", 10, 23));
        listaProductos.add(new Producto("Botanas", "Sprite", 10, 23));
        listaProductos.add(new Producto("Botanas", "Madgnzana", 10, 23));
        listaProductos.add(new Producto("Botanas", "Te", 10, 23));
        listaProductos.add(new Producto("Botanas", "Del valle", 10, 23));
        listaProductos.add(new Producto("Botanas", "Fadsnta", 10, 23));
        listaProductos.add(new Producto("Botanas", "Fresca", 10, 23));


    }

    public ArrayList<Producto> getListaProductos() {

        return listaProductos;
    }


}
