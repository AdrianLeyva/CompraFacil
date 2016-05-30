package controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import comprafacil.myapp.root.comprafacil.GestionarEmpleadosActivity;
import model.Empleado;
import persistencia.EmpleadosSQLiteOpenHelper;
import persistencia.ProvisionalEmpleadosBD;
import java.util.ArrayList;

/**
 * Created by kevin gamboa on 24/04/16.
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

    public ArrayList<Empleado> getEmpleados(GestionarEmpleadosActivity vista){
        ArrayList<Empleado> lista = new ArrayList<>();
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(vista,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery("select * from empleados",null);
        while (fila.moveToNext()){
            Empleado empleado = new Empleado(fila.getString(0),fila.getString(1),fila.getString(2),fila.getString(3));
            lista.add(empleado);
        }
        bd.close();
        return lista;
    }

    public void actualizarEmpleados(ArrayList<Empleado> lista,GestionarEmpleadosActivity vista){
       // persistenciaEmpleados.actualizarPersistencia(listaEmpleados);
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(vista,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("empleados",null,null);

        ContentValues registro = new ContentValues();
        for(int i =0;i<lista.size();i++){
            registro.put("nombre",lista.get(i).getNombre());
            registro.put("puesto",lista.get(i).getPuesto());
            registro.put("usuario",lista.get(i).getUsuario());
            registro.put("clave",lista.get(i).getClave());
            bd.insert("empleados",null,registro);
        }
        bd.close();
    }

    public void agregarNuevoEmpleado(GestionarEmpleadosActivity vista,String nombre,String puesto,String usuario,String clave){
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(vista,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("nombre",nombre);
        registro.put("puesto",puesto);
        registro.put("usuario",usuario);
        registro.put("clave",clave);
        bd.insert("empleados",null,registro);
        bd.close();
    }

    public void restablecerEmpleados(ArrayList<Empleado> lista,GestionarEmpleadosActivity vista){
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(vista,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("empleados",null,null);
        bd.close();
    }

    public int getPuestoEmpleado(int position, ArrayList<Empleado> listaEmpleados ){
        String puesto;
        int positionPuesto;

        puesto = listaEmpleados.get(position).getPuesto().toString();

        if (puesto == "Administrador"){ positionPuesto = 1;}
        if (puesto == "Cajero"){positionPuesto = 0;}
        else positionPuesto = 0;

        return positionPuesto;
    }
}
