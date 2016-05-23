package persistencia;

import java.sql.*;
/**
 * Created by leyva on 22/05/2016.
 */
public class Conexion {
    public Conexion(){

    }
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/compra_facil","root","");
        }catch (SQLException ex){
        }catch (Exception e){
        }
        return con;
    }
}
