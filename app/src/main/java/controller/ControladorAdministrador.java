package controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import model.Empleado;
import persistencia.Conexion;
import persistencia.EmpleadosSQLiteOpenHelper;
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
        Empleado empleado = null;
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(vista,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String usuario = vista.getUsuario();
        String clave = vista.getClave();
        Cursor fila = bd.rawQuery("select * from empleados",null);
        while (fila.moveToNext()){
            if(usuario.compareTo(fila.getString(2)) == 0 && clave.compareTo(fila.getString(3)) == 0){
                empleado = new Empleado(fila.getString(0),fila.getString(1),fila.getString(2),fila.getString(3));
                bd.close();
                return empleado;
            }
        }
        bd.close();
        return empleado;
    }

/*ProvisionalEmpleadosBD provisionalEmpleadosBD = new ProvisionalEmpleadosBD();
        listaEmpleados = new ArrayList<>();
        listaEmpleados = provisionalEmpleadosBD.getListaEmpleado();

        for(int i=0;i<listaEmpleados.size();i++){
            if(listaEmpleados.get(i).getUsuario().compareTo(vista.getUsuario())== 0 && listaEmpleados.get(i).getClave().compareTo(vista.getClave()) == 0){
                empleado = new Empleado(listaEmpleados.get(i).getNombre(),listaEmpleados.get(i).getPuesto());
                return empleado;
            }
        }
        return empleado;
        */

}
