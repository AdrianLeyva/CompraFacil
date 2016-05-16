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
public class EmpleadoBD extends AsyncTask<Void,Void,Void>{

    private String servidor = "jdbc:mysql://localhost:3306/CompraFacil";
    private String usuario = "teamprogra";
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
    protected Void doInBackground(Void... params) {
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(servidor,usuario,clave);

            Statement st = con.createStatement();
            String sql = "select * from Empleados";

            final ResultSet rs = st.executeQuery(sql);

        }
        catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

        String vistaUsuario = vista.getUsuario();
        String vistaClave = vista.getClave();

        try {
            while (rs.next()) {
                if (vistaUsuario == rs.getString("Usuario") && vistaClave == rs.getString("Clave")) {
                    int flag = 1;
                    Toast toast = Toast.makeText(vista,"Validación correcta",Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                }
            }
        }

        catch (SQLException e) {
            Toast toast = Toast.makeText(vista,"Ha habido un error para enlazar la base de datos",Toast.LENGTH_SHORT);
            toast.show();
        }

        Toast toast = Toast.makeText(vista,"Validación incorrecta",Toast.LENGTH_SHORT);
        toast.show();
        int flag = 0;

        super.onPostExecute(result);
    }

    public int getFlag(){
        return flag;
    }

}
