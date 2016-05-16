package persistencia;


import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.os.AsyncTask;
import comprafacil.myapp.root.comprafacil.ValidarUsuarioActivity;

/**
 * Created by root_user on 6/05/16.
 */
public class EmpleadoBD extends AsyncTask<String,Void,ResultSet>{

    private String servidor = "jdbc:mysql://127.0.0.1:3306/Empleados";
    private String usuario = "root";
    private String clave = "";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private ValidarUsuarioActivity vista;
    private int flag;

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


    @Override
    protected void onPostExecute(ResultSet result) {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();

        try {

            while (result.next()) {
                if (vistaUsuario == rs.getString("Usuario") && vistaClave == rs.getString("Clave")) {
                    Toast toast = Toast.makeText(vista,"Validación correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    flag = 1;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected ResultSet doInBackground(String... params) {
        try {
            Connection conn;
            Class.forName(driver);
            conn = DriverManager.getConnection(servidor, usuario, clave);

            Statement estado = conn.createStatement();
            String peticion = "select * from Empleados";
            ResultSet result = estado.executeQuery(peticion);
            return result;

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
    public int getFlag(){
        return flag;
    }
}
