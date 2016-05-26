package comprafacil.myapp.root.comprafacil;

/**
 * Created by kevin gamboa on 23/04/16.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ModoUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hace la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_modo_usuario);
    }

    public void abrirModoAdministrador(View view){
        Intent i = new Intent(this, ValidarUsuarioActivity.class);
        startActivity(i);
    }

    public void abrirModoClientes(View view){
        Intent i = new Intent(this, UsuarioActivity.class);
        startActivity(i);



    }
}
