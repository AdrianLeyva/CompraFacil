package comprafacil.myapp.root.comprafacil;

/**
 * Created by kevin gamboa on 21/05/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import controller.EditTextClaveEmpleadoWatcher;
import controller.EditTextNombreEmpleadosWatcher;
import controller.EditTextPuestoEmpleadoWatcher;
import controller.EditTextUsuarioEmpleadoWatcher;
import model.Empleado;
import controller.ControladorEmpleado;

public class GestionarEmpleadosActivity extends AppCompatActivity {
    private ArrayList<Empleado> listaEmpleado;
    private AdaptadorEmpleado adaptador;
    private ControladorEmpleado controladorEmpleado;
    private Spinner spinnerPuesto;
    private Spinner spinnerPuesto2;
    private String [] puestos = {"Cajero", "Administrador"};
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
        listaEmpleado = controladorEmpleado.getEmpleados(this);

        //Creando el adaptador del segundo spinner de los puestos disponibles
   //     spinnerPuesto2 = (Spinner) findViewById(R.id.spinnerPuestoEmpleado2);
     //   ArrayAdapter<String> adaptadorPuestos2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, puestos);
       // spinnerPuesto2.setAdapter(adaptadorPuestos2);


        //Realiza el proceso del adaptador, para mandarle la vista de los elementos
        adaptador = new AdaptadorEmpleado(this);
        ListView lv_Empleados = (ListView) findViewById(R.id.lv_elementos_gestionar_empleados);
        lv_Empleados.setAdapter(adaptador);

        //Creando el adaptador del spinner de los puestos disponibles
        spinnerPuesto = (Spinner) findViewById(R.id.spinnerPuestoEmpleado);
        ArrayAdapter<String> adaptadorPuestos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, puestos);
        spinnerPuesto.setAdapter(adaptadorPuestos);




    }

    public void restablecerEmpleados(View view){
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        controladorEmpleado.restablecerEmpleados(listaEmpleado,this);
        listaEmpleado.clear();
        adaptador.notifyDataSetChanged();
    }

    public void actualizarEmpleados(View view){
        controladorEmpleado.actualizarEmpleados(listaEmpleado,this);
        Toast toast = Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT);
        toast.show();
    }


    public int agregarNuevoEmpleado(View view){
        EditText editTextNombre = (EditText)findViewById(R.id.editText_NombreEmpleado);
        EditText editTextPuesto = (EditText)findViewById(R.id.editText_Puesto);
        EditText editTextUsuario = (EditText)findViewById(R.id.editText_usuario_empleado);
        EditText editTextContraseña = (EditText)findViewById(R.id.editText_contraseña_empleado);

        String nombre = editTextNombre.getText().toString();
        String puesto = spinnerPuesto.getSelectedItem().toString();
        String usuario = editTextUsuario.getText().toString();
        String contraseña = editTextContraseña.getText().toString();



        for(int i=0;i<listaEmpleado.size();i++){
            if(listaEmpleado.get(i).getNombre().compareTo(nombre) == 0){
                Toast toast = Toast.makeText(this,"Ya existe registro de este empleado",Toast.LENGTH_SHORT);
                toast.show();

                return 0;
            }
        }
        listaEmpleado.add(new Empleado(nombre, puesto, usuario, contraseña));
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        controladorEmpleado.agregarNuevoEmpleado(this,nombre,puesto,usuario,contraseña);
        adaptador.notifyDataSetChanged();
        return 0;
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

           EditText tvnombre_empleados = (EditText) item.findViewById(R.id.tv_nombre_empleados);
           tvnombre_empleados.setHint(listaEmpleado.get(position).getNombre());
           tvnombre_empleados.addTextChangedListener(new EditTextNombreEmpleadosWatcher(position,listaEmpleado,tvnombre_empleados,appCompatActivity));


           EditText tvpuesto_empleados = (EditText) item.findViewById(R.id.editText_Puesto);
           tvpuesto_empleados.setHint(listaEmpleado.get(position).getPuesto());
           tvpuesto_empleados.addTextChangedListener(new EditTextPuestoEmpleadoWatcher(position, listaEmpleado, tvpuesto_empleados, appCompatActivity));


           EditText tvusuario_empleados = (EditText) item.findViewById(R.id.tv_usuario_empleado);
           tvusuario_empleados.setHint(listaEmpleado.get(position).getUsuario());
           tvusuario_empleados.addTextChangedListener(new EditTextUsuarioEmpleadoWatcher(position,listaEmpleado, tvusuario_empleados, appCompatActivity));

           EditText tvcontraseña_empleados = (EditText) item.findViewById(R.id.et_contraseña_empleado);
           tvcontraseña_empleados.setHint(listaEmpleado.get(position).getClave());
           tvcontraseña_empleados.addTextChangedListener(new EditTextClaveEmpleadoWatcher(position, listaEmpleado, tvcontraseña_empleados, appCompatActivity));

           return (item);
       }

    }

}
