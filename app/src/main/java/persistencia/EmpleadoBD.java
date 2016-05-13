package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

import model.Empleado;

/**
 * Created by root_user on 6/05/16.
 */
public class EmpleadoBD implements Serializable {
    //Atributos
    private ArrayList<Empleado> bdEmpleados;

    public ArrayList<Empleado> getBaseDatos(){
        try {
            FileInputStream door = new FileInputStream("empleados_bd.ser");
            ObjectInputStream reader = new ObjectInputStream(door);
            bdEmpleados = new ArrayList<Empleado>();
            bdEmpleados = (ArrayList<Empleado>)reader.readObject();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return bdEmpleados;
    }

    public void setBaseDatos(ArrayList<Empleado> bdEmpleados){
        try {
            FileOutputStream file = new FileOutputStream("empleados_bd.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(bdEmpleados);
            obj.close();
        }
        catch (IOException e){

        }
    }

}
