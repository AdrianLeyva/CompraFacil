package controller;

import java.util.ArrayList;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import model.Empleado;
import persistencia.Conexion;
import persistencia.ProvisionalEmpleadosBD;

/**
 * Created by root_user on 19/04/16.
 */
public class ControladorAdministrador {
    /*Atributos*/
    private ValidarUsuarioActivity vista;
    private Conexion conexion;
    private ArrayList<Empleado> listaEmpleados;
    private Empleado empleado;

    public ControladorAdministrador(ValidarUsuarioActivity vista) {
        this.vista = vista;
    }


    public Empleado verificarUsuario() {
        ProvisionalEmpleadosBD provisionalEmpleadosBD = new ProvisionalEmpleadosBD();
        listaEmpleados = new ArrayList<>();
        listaEmpleados = provisionalEmpleadosBD.getListaEmpleado();

        for(int i=0;i<listaEmpleados.size();i++){
            if(listaEmpleados.get(i).getUsuario().compareTo(vista.getUsuario())== 0 && listaEmpleados.get(i).getClave().compareTo(vista.getClave()) == 0){
                empleado = new Empleado(listaEmpleados.get(i).getNombre(),listaEmpleados.get(i).getPuesto());
                return empleado;
            }
        }
        return empleado;
    }

        /*
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

*/

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
