package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import controller.ControladorAdministrador;
import model.Empleado;
import persistencia.ProvisionalEmpleadosBD;

public class ValidarUsuarioActivity extends AppCompatActivity {
    //Atributos
    private EditText usuario;
    private EditText clave;
    private Empleado empleado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hace la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_validar_usuario);
        usuario = (EditText) findViewById(R.id.editText_usuario);
        clave = (EditText) findViewById(R.id.editText_contraseña);

    }


    public void onClick(View v) {
        if (v.getId() == R.id.button_validarUsuario) {

            ControladorAdministrador controladorAdministrador = new ControladorAdministrador(this);
            empleado = controladorAdministrador.verificarUsuario();
            if(empleado == null){
                Toast toast = Toast.makeText(this,"Validación incorrecta", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Toast toast = Toast.makeText(this,"Validación correcta", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(this,AdministradorActivity.class);
                i.putExtra("nombre",empleado.getNombre());
                i.putExtra("puesto",empleado.getPuesto());
                startActivity(i);
            }
/*
            ControladorAdministrador controladorAdministrador = new ControladorAdministrador(this);
            empleado = controladorAdministrador.verificarUsuario();
            if(empleado == null){
                Toast toast = Toast.makeText(this,"Validación incorrecta",Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Toast toast = Toast.makeText(this,"Validación correcta",Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(this, AdministradorActivity.class);
                startActivity(i);
            }
*/
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


}
