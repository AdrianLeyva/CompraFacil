package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.Empleado;
import model.Producto;

/**
 * Created by root_user on 6/05/16.
 */
public class InventarioBD implements Serializable {
    //Atributos
    private ArrayList<Producto> productosBD;
    //Metodos
    public ArrayList<Producto> getBaseDatos(){
        try {
            FileInputStream door = new FileInputStream("productos_bd.ser");
            ObjectInputStream reader = new ObjectInputStream(door);
            productosBD = new ArrayList<Producto>();
            productosBD = (ArrayList<Producto>)reader.readObject();
            reader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return productosBD;
    }

    public void setBaseDatos(ArrayList<Producto> productosBD){
        try {
            FileOutputStream file = new FileOutputStream("productos_bd.ser");
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(productosBD);
            obj.close();
        }
        catch (IOException e){

        }
    }
}
