package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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

        //Realiza el proceso del adaptador, para mandarle la vista de los elementos
        AdaptadorEmpleado adaptador = new AdaptadorEmpleado(this);
        ListView lv_Empleados = (ListView) findViewById(R.id.lv_elementos_gestionar_empleados);
        lv_Empleados.setAdapter(adaptador);


    }


   private class AdaptadorEmpleado extends ArrayAdapter<Empleado> {
        private AppCompatActivity appCompatActivity;

        AdaptadorEmpleado(AppCompatActivity context){
            super(context, R.layout.list_item_gestionar_empleados, listaEmpleado);
            appCompatActivity = context;
        }

       public View getView(int position, View convertView, ViewGroup parent){
           LayoutInflater inflater = appCompatActivity.getLayoutInflater();
           View item = inflater.inflate(R.layout.list_item_gestionar_empleados, null);

           TextView tvnombre_empleados = (TextView) item.findViewById(R.id.tv_nombre_empleados);
           tvnombre_empleados.setHint(listaEmpleado.get(position).getNombre());

           TextView tvpuesto_empleados = (TextView) item.findViewById(R.id.tv_puesto_empleado);
           tvpuesto_empleados.setHint(listaEmpleado.get(position).getPuesto());

           TextView tvusuario_empleados = (TextView) item.findViewById(R.id.tv_usuario_empleado);
           tvusuario_empleados.setHint(listaEmpleado.get(position).getUsuario());

           TextView tvcontraseña_empleados = (TextView) item.findViewById(R.id.et_contraseña_empleado);
           tvcontraseña_empleados.setHint(listaEmpleado.get(position).getClave());

           return (item);
       }

    }

}
