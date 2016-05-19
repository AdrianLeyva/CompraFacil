package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import controller.AdapterListItemPedidos;
import model.Producto;

public class AdministradorActivity extends AppCompatActivity {

    private AdapterListItemPedidos adapter;
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_administrador);

        //Inicializa el listView con los pedidos actuales
        list = (ListView) findViewById(R.id.listView_Pedidos);
        adapter = new AdapterListItemPedidos(this, getPedidos());
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void cerrarSesion(View view){
        finish();
    }

    public ArrayList<Producto> getPedidos(){
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto pedido1 = new Producto("bebidas","coca cola,",2);
        Producto pedido2 = new Producto("botanas","doritos",1);
        Producto pedido3 = new Producto("Dulces","Rockaleta",4);
        listaProductos.add(pedido1);
        listaProductos.add(pedido2);
        listaProductos.add(pedido3);

        return listaProductos;
    }
}
