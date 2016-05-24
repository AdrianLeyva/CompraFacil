package controller;

import model.Empleado;
import persistencia.ProvisionalEmpleadosBD;
import java.util.ArrayList;

/**
 * Created by root_user on 24/04/16.
 */
public class ControladorEmpleado {
    private ArrayList<Empleado> listaEmpleados;
    private ProvisionalEmpleadosBD persistenciaEmpleados;

    public ControladorEmpleado(){
        //Se crea el objeto de persistencia.
        persistenciaEmpleados = new ProvisionalEmpleadosBD();
    }

    // Se obtiene la lista de los empleados de la base de datos.
    public ArrayList<Empleado> getListaEmpleados(){
        listaEmpleados= persistenciaEmpleados.getListaEmpleado();

        return listaEmpleados;
    }
}
