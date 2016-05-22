package model;

/**
 * Created by root_user on 19/04/16.
 */
public class Producto {

    /*Atributos*/
    private String categoria;
    private String nombre;
    private String precio;
    private String cantidad;

    public Producto(String categoria, String nombre, String precio, String cantidad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String categoria, String nombre, String cantidad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
/*
    public Producto(String categoria, String nombre, String precio) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }
*/
    public Producto(String categoria, String nombre) {
        this.categoria = categoria;
        this.nombre = nombre;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String   getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
