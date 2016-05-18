package controller;


import android.widget.Toast;
import java.util.ArrayList;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import model.Empleado;
import persistencia.EmpleadoBD;

/**
 * Created by root_user on 19/04/16.
 */
public class ControladorAdministrador {
    /*Atributos*/
    private ValidarUsuarioActivity vista;
    private ArrayList<Empleado> listaEmpleados;

    public ControladorAdministrador(ValidarUsuarioActivity vista, ArrayList<Empleado> listaEmpleados) {
        this.vista = vista;
        this.listaEmpleados = listaEmpleados;
    }

    public int verificarUsuario() {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();

        int i = 0;
        if(listaEmpleados.size() == 0){
            Toast toast = Toast.makeText(vista,"La lista está vacía",Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            for(i=0;i<listaEmpleados.size();i++) {
                if (listaEmpleados.get(i).getUsuario() == vistaUsuario && listaEmpleados.get(i).getClave() == vistaClave) {
                    Toast toast = Toast.makeText(vista,"Validación correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    return 1;
                }
            }
        }
        Toast toast = Toast.makeText(vista,"Validación incorrecta",Toast.LENGTH_SHORT);
        toast.show();
        return 0;
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
