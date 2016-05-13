package controller;

import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

import model.Administrador;
import model.Empleado;
import model.Producto;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;

/**
 * Created by root_user on 19/04/16.
 */
public class ControladorAdministrador {
    /*Atributos*/
    private Administrador administrador;
    private ValidarUsuarioActivity vista;

    public ControladorAdministrador(Administrador administrador, ValidarUsuarioActivity vista) {
        this.administrador = administrador;
        this.vista = vista;
    }

    public int verificarUsuario(){

        String modeloUsuario = administrador.getUsuario();
        String vistaUsuario = vista.getUsuario();
        String modeloClave = administrador.getClave();
        String vistaClave = vista.getClave();


        if (modeloUsuario.compareTo(vistaUsuario) == 0 && modeloClave.compareTo(vistaClave) == 0){
            Toast.makeText(vista, "Validación correcta", Toast.LENGTH_SHORT).show();
            return 1;
        }
        else{
            Toast.makeText(vista,"Validación incorrecta", Toast.LENGTH_SHORT).show();
            return 0;
        }

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
