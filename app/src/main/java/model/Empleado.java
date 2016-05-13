package model;

/**
 * Created by root_user on 19/04/16.
 */
public class Empleado {

    /*Atributos*/
    private String nombre;
    private String puesto;
    private String usuario;
    private String clave;

    public Empleado(String nombre,String puesto, String usuario, String clave) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
