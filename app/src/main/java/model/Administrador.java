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

    public Administrador(String nombre, String puesto, String usuario, String clave){
        super(nombre,puesto,usuario,clave);
    }

    public Administrador(String nombre, String puesto, String usuario, String clave, Empleado empleado){
       super(nombre,puesto,usuario,clave);
        this.empleado = empleado;
    }


}
