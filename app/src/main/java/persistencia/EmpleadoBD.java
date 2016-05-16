package persistencia;

import android.sax.StartElementListener;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.transform.Result;

import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;

/**
 * Created by root_user on 6/05/16.
 */
public class EmpleadoBD{

    private String servidor = "jdbc:mysql://localhost:3306/Empleados";
    private String usuario = "root'@'localhost";
    private String clave = "";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private ValidarUsuarioActivity vista;

    public EmpleadoBD(ValidarUsuarioActivity vista){
        this.vista = vista;
    }


    public Connection getConexion(){
        return conexion;
    }

    public ResultSet getBaseDatos(){

        try {
            conexion = DriverManager.getConnection(servidor,usuario,clave);
        } catch (SQLException e){
            Toast toast = Toast.makeText(vista,"Validación correcta",Toast.LENGTH_SHORT);
            toast.show();
        }

        Connection con = getConexion();
        String sql = "select * from Empleados";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
        }

        catch (SQLException e){

        }
        return rs;
    }


}
