package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ModoUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_usuario);
    }

    public void abrirModoAdministrador(View view){
        Intent i = new Intent(this, ValidarUsuarioActivity.class);
        startActivity(i);
    }

    public void abrirModoClientes(View view){
    /*    Intent i = new Intent(this, Cliente.class);
        startActivity(i);
    */
    }
}
