package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import model.Empleado;
import persistencia.Conexion;

/**
 * Created by root_user on 19/04/16.
 */
public class ControladorAdministrador {
    /*Atributos*/
    private ValidarUsuarioActivity vista;
    private Conexion conexion;

    public ControladorAdministrador(ValidarUsuarioActivity vista) {
        this.vista = vista;
    }


    public Empleado verificarUsuario() {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();

        conexion = new Conexion();
        Empleado empleado = null;
        Connection baseDatos = conexion.getConexion();
        try {
            PreparedStatement ps = baseDatos.prepareStatement("select * from empleados where usuario=? and clave=?");
            ps.setString(1, vistaUsuario);
            ps.setString(2,vistaClave);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                empleado = new Empleado();
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setClave(rs.getString("clave"));
                return empleado;
            }
        }catch (Exception e){
        }
        return empleado;
    }



        // public void consultarInventario(ConsultaInventarioActivity vista){
        /*Aqui se deserealizará el objeto de productos y será asignado al arraylist*/
   /*     ArrayList<Producto> inventario;
    }*/

    /*public void registrarEmpleado(RegistroActivity vista){
        Empleado empleado = new  Empleado(vista.getNombre(),vista.getUsuario(),vista.getClave());
        //Aqui se deserealizará el objeto de empleado y será asignado al arraylist
        ArrayList<Empleado> empleados;
        empleados.add(empleado);
    }*/

    /*public void eliminarEmpleado(RegistroActivity vista){
        ArrayList<Empleado> empleados;
        //Aqui se deserealizará el objeto de empleado y será asignado al arraylist
        //Aqui se buscará en el arraylist el empleado seleccionado
        int index;
        empleados.remove(index);
    }*/

   /* public void modificarInventario(){
       //Abrir el activity Inventario
    }*/



}
