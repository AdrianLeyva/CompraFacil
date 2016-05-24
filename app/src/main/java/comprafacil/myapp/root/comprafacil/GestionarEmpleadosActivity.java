package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import persistencia.ProvisionalEmpleadosBD;
import model.Empleado;
import controller.ControladorEmpleado;

public class GestionarEmpleadosActivity extends AppCompatActivity {
    private ArrayList<Empleado> listaEmpleado;
    private ControladorEmpleado controladorEmpleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gestionar_empleados);

        //Se extra la lista de empleados desde la base de datos.
        controladorEmpleado = new ControladorEmpleado();
        listaEmpleado = new ArrayList<Empleado>();
        listaEmpleado = controladorEmpleado.getListaEmpleados();


    }


   private class AdaptadorEmpleado extends ArrayList<Empleado> {
        private AppCompatActivity appCompatActivity;

       /* AdaptadorEmpleado(AppCompatActivity context){
            super(context, R.layout., listaProductos);
            appCompatActivity = context;
        }
       */
    }

}
