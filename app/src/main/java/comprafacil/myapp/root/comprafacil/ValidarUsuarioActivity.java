package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.util.ArrayList;

import controller.ControladorAdministrador;
import model.Administrador;
import model.Empleado;
import persistencia.EmpleadoBD;

public class ValidarUsuarioActivity extends AppCompatActivity implements View.OnClickListener {
    //Atributos
    private EditText usuario;
    private EditText clave;
    private Button botonValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_usuario);
        usuario = (EditText) findViewById(R.id.editText_usuario);
        clave = (EditText) findViewById(R.id.editText_contraseña);
        botonValidar = (Button) findViewById(R.id.button_validarUsuario);
        botonValidar.setOnClickListener(this);
        iniciarBaseDatos();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_validarUsuario){

            ControladorAdministrador controladorAdministrador = new ControladorAdministrador(this);
            if(controladorAdministrador.verificarUsuario() == 1){
                Intent i = new Intent(this, AdministradorActivity.class);
                startActivity(i);
            }
        }
    }

    public String getUsuario(){
        String var = usuario.getText().toString();
        return var;
    }

    public String getClave(){
        String var = clave.getText().toString();
        return var;
    }

    public void iniciarBaseDatos(){
        Empleado emp1 = new Empleado("Adrian","Cajero","adrian","leyva");
        Empleado emp2 = new Empleado("Kevin","Cajero","kevin","gamboa");
        Empleado emp3 = new Empleado("Daniel","Cajero","daniel","baas");

        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);

        EmpleadoBD baseDatos = new EmpleadoBD();
        baseDatos.setBaseDatos(listaEmpleados);
    }
}
