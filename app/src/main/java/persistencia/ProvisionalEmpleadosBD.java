package persistencia;

/**
 * Created by kevingamboa17 on 24/05/16.
 */

import java.util.ArrayList;

import model.Empleado;


public class ProvisionalEmpleadosBD {
    private ArrayList<Empleado> listaEmpleado;

    public ProvisionalEmpleadosBD(){
        listaEmpleado = new ArrayList<Empleado>();
        listaEmpleado.add(new Empleado("Kevin Gamboa", "Gerente", "kevin", "gamboa"));
        listaEmpleado.add(new Empleado("Adrian Leyva", "Administrador", "adrian", "leyva"));
        listaEmpleado.add(new Empleado("Daniel Baas", "Gerente", "daniel", "baas"));

    }

    public ArrayList<Empleado> getListaEmpleado(){
        return listaEmpleado;
    }

    public void actualizarPersistencia(ArrayList<Empleado> listaEmpleado){

    }

}
