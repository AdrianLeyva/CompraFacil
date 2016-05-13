package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

    @Override
    public void onClick(View v) {

    }

    public String getUsuario(){
        String var = usuario.getText().toString();
        return var;
    }

    public String getClave(){
        String var = clave.getText().toString();
        return var;
    }
}
