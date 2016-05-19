package model;

/**
 * Created by root_user on 19/04/16.
 */
public class Producto {

    /*Atributos*/
    private String categoria;
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto(String categoria, String nombre, float precio, int cantidad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto(String categoria, String nombre, int cantidad) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Producto(String categoria, String nombre, float precio) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
