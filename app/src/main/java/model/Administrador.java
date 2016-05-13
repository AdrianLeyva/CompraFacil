package model;
/**
 * Created by root_user on 19/04/16.
 */
public class Administrador extends Empleado {
    /*Atributos*/
    private String nombre;
    private String puesto;
    private String usuario;
    private String clave;
    private Empleado empleado;
    private Inventario inventario;

    public Administrador(String nombre, String puesto, String usuario, String clave){
        super(nombre,puesto,usuario,clave);
    }

    public Administrador(String nombre, String puesto, String usuario, String clave, Empleado empleado, Inventario inventario){
       super(nombre,puesto,usuario,clave);
        this.empleado = empleado;
        this.inventario = inventario;
    }


    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }


}
