package persistencia;

import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;
import model.Empleado;
import java.util.ArrayList;
/**
 * Created by root_user on 6/05/16.
 */
public class EmpleadoBD {

    private String servidor = "jdbc:mysql://localhost/compra_facil";
    private String usuario = "root";
    private String clave = "";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ValidarUsuarioActivity vista;

    public EmpleadoBD(ValidarUsuarioActivity vista){
        this.vista = vista;
    }

    public void getBaseDatos() {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();
        int flag = 0;

        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(servidor, usuario, clave);
            st = con.createStatement();
            rs = st.executeQuery("select * from empleados");

            while(rs.next()){
                Toast toast = Toast.makeText(vista,rs.getString("usuario"),Toast.LENGTH_SHORT);
                toast.show();
            }
            rs.close();
        }
        catch (SQLException e) {
            Toast toast = Toast.makeText(vista,"Falló la conexión",Toast.LENGTH_SHORT);
            toast.show();
        }
        catch (ClassNotFoundException e) {

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}