package comprafacil.myapp.root.comprafacil;

/**
 * Created by kevin gamboa on 23/04/16.
 */

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import persistencia.EmpleadosSQLiteOpenHelper;
import persistencia.InventarioSQLiteOpenHelper;

public class ModoUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hace la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_modo_usuario);
        //restablecerTablaInventario();
        //restablecerTablaEmpleados();
        //inicializarEmpleadosBD();
    }
//metodos
    public void abrirModoAdministrador(View view){
        Intent i = new Intent(this, ValidarUsuarioActivity.class);
        startActivity(i);
    }

    public void abrirModoClientes(View view){
        Intent i = new Intent(this, UsuarioActivity.class);
        startActivity(i);
    }

    public void inicializarEmpleadosBD(){
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(this,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombre","Adrian");
        registro.put("puesto","Administrador");
        registro.put("usuario", "adrian");
        registro.put("clave","leyva");
        bd.insert("empleados",null,registro);

        ContentValues registro2 = new ContentValues();
        registro2.put("nombre","Kevin");
        registro2.put("puesto","cajero");
        registro2.put("usuario", "kevin");
        registro2.put("clave","gamboa");
        bd.insert("empleados",null,registro2);

        ContentValues registro3 = new ContentValues();
        registro3.put("nombre","Daniel");
        registro3.put("puesto","cajero");
        registro3.put("usuario", "daniel");
        registro3.put("clave","baas");
        bd.insert("empleados",null,registro3);

        ContentValues registro4 = new ContentValues();
        registro4.put("nombre","Edgar");
        registro4.put("puesto","cajero");
        registro4.put("usuario", "edgar");
        registro4.put("clave","cambranes");
        bd.insert("empleados",null,registro4);

        bd.close();
    }

    public void inicializarInventarioBD(){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(this,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombre","Pepsi");
        registro.put("categoria","Bebidas");
        registro.put("precio",12);
        registro.put("cantidad",20);
        bd.insert("productos",null,registro);

        ContentValues registro2 = new ContentValues();
        registro2.put("nombre","Emperador");
        registro2.put("categoria","Galletas");
        registro2.put("precio",12);
        registro2.put("cantidad",20);
        bd.insert("productos",null,registro2);

        ContentValues registro3 = new ContentValues();
        registro3.put("nombre","Rockaleta");
        registro3.put("categoria","Dulces");
        registro3.put("precio",12);
        registro3.put("cantidad",20);
        bd.insert("productos",null,registro3);

        ContentValues registro4 = new ContentValues();
        registro4.put("nombre","Papas");
        registro4.put("categoria","Botanas");
        registro4.put("precio",12);
        registro4.put("cantidad",20);
        bd.insert("productos",null,registro4);

        ContentValues registro5 = new ContentValues();
        registro5.put("nombre","Pay de queso");
        registro5.put("categoria","Postres");
        registro5.put("precio",12);
        registro5.put("cantidad",20);
        bd.insert("productos",null,registro5);

        ContentValues registro6 = new ContentValues();
        registro6.put("nombre","Doritos");
        registro6.put("categoria","Sabritas");
        registro6.put("precio",12);
        registro6.put("cantidad",20);
        bd.insert("productos",null,registro6);

        bd.close();
    }

    public void restablecerTablaInventario(){
        InventarioSQLiteOpenHelper admin = new InventarioSQLiteOpenHelper(this,"compra_facil2",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("productos",null,null);
        bd.close();
    }

    public void restablecerTablaEmpleados(){
        EmpleadosSQLiteOpenHelper admin = new EmpleadosSQLiteOpenHelper(this,"compra_facil",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        bd.delete("empleados",null,null);
        bd.close();
    }
}
