package model;

/**
 * Created by root_user on 19/04/16.
 */
public class Cajero extends Empleado {
    /*Atributos*/
    private String nombre;
    private String puesto;
    private String usuario;
    private String clave;

    public Cajero(String nombre, String puesto,String usuario, String clave){
        super(nombre,puesto,usuario,clave);
    }

}
