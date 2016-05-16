package controller;


import android.widget.Toast;
import java.sql.ResultSet;
import java.sql.SQLException;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import persistencia.EmpleadoBD;

/**
 * Created by root_user on 19/04/16.
 */
public class ControladorAdministrador {
    /*Atributos*/
    private ValidarUsuarioActivity vista;
    private EmpleadoBD baseDatos;

    public ControladorAdministrador(ValidarUsuarioActivity vista) {
        this.baseDatos = new EmpleadoBD(vista);
        this.vista = vista;
    }

    public int verificarUsuario() {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();
        return 1;
/*
        ResultSet rs = baseDatos.getBaseDatos();

        try {
            while (rs.next()) {
                if (vistaUsuario == rs.getString(3) && vistaClave == rs.getString(4)) {
                    int bandera = 1;
                    Toast toast = Toast.makeText(vista,"Validación correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    return bandera;
                }
            }
        } catch (SQLException e) {
            Toast toast = Toast.makeText(vista,"Ha habido un error para enlazar la base de datos",Toast.LENGTH_SHORT);
            toast.show();
        }
        Toast toast = Toast.makeText(vista,"Validación incorrecta",Toast.LENGTH_SHORT);
        toast.show();
        return 0;
        */
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
