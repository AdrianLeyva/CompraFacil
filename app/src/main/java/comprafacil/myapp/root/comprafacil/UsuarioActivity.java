package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import controller.ButtonCarritoAgregarOnClick;
import controller.ButtonCarritoEliminarOnClick;
import controller.ButtonCarritoRestarOnClick;
import model.Producto;
import persistencia.ProvisionalInventario;

public class UsuarioActivity extends AppCompatActivity {
    //Variables
    private ArrayList<Producto> listaProductos;
    private AdaptadorCarrito adaptador;
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        ProvisionalInventario provisionalInventario = new ProvisionalInventario();
        listaProductos = provisionalInventario.getListaProductos();
        adaptador = new AdaptadorCarrito(this);
        listView1 = (ListView) findViewById(R.id.listView_CarritoCompras);
        listView1.setAdapter(adaptador);
    }

    public void abrirCategoriaGenerica(View view){
        Intent i = new Intent(this, CategoriaGenericaActivity.class);
        startActivity(i);
    }

    private class AdaptadorCarrito extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorCarrito(AppCompatActivity context) {
            super(context, R.layout.list_item_carrito_compras, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_carrito_compras, null);

            TextView textViewNombre = (TextView) item.findViewById(R.id.textView_CarritoProducto);
            textViewNombre.setText(listaProductos.get(position).getNombre());

            TextView textViewCantidad = (TextView) item.findViewById(R.id.textView_CarritoCantidad);
            textViewCantidad.setText(String.valueOf(listaProductos.get(position).getCantidad()));

            TextView textViewPrecio = (TextView) item.findViewById(R.id.textView_CarritoPrecio);
            textViewPrecio.setText(String.valueOf(listaProductos.get(position).getPrecio()));

            Button buttonAgregar = (Button)item.findViewById(R.id.button_CarritoMas);
            buttonAgregar.setOnClickListener(new ButtonCarritoAgregarOnClick(position,textViewCantidad,listaProductos,appCompatActivity));

            Button buttonRestar = (Button)item.findViewById(R.id.button_CarritoMenos);
            buttonRestar.setOnClickListener(new ButtonCarritoRestarOnClick(position,textViewCantidad,listaProductos,appCompatActivity,adaptador));

            Button buttonEliminar = (Button)item.findViewById(R.id.button_CarritoEliminar);
            buttonEliminar.setOnClickListener(new ButtonCarritoEliminarOnClick(position,listaProductos,adaptador));
            return (item);
        }
    }

}
