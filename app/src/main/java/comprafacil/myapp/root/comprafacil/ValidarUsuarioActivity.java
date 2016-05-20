package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

import controller.ControladorAdministrador;
import model.Empleado;
import persistencia.EmpleadoBD;

public class ValidarUsuarioActivity extends AppCompatActivity {
    //Atributos
    private EditText usuario;
    private EditText clave;
    private Button botonValidar;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_usuario);
        usuario = (EditText) findViewById(R.id.editText_usuario);
        clave = (EditText) findViewById(R.id.editText_contraseña);

    }


    public void onClick(View v) {
        if (v.getId() == R.id.button_validarUsuario) {
            Intent i = new Intent(this, AdministradorActivity.class);
            startActivity(i);
        }

    }

    public String getUsuario() {
        String var = usuario.getText().toString();
        return var;
    }

    public String getClave() {
        String var = clave.getText().toString();
        return var;
    }

    public void iniciarBaseDatos(){

        Empleado emp1 = new Empleado("Adrian","Cajero","adrian","leyva");
        Empleado emp2 = new Empleado("Kevin","Cajero","kevin","gamboa");
        Empleado emp3 = new Empleado("Daniel","Cajero","daniel","baas");

        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);
    }

}
