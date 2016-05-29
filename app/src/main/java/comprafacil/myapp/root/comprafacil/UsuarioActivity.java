package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import controller.ButtonCarritoAgregarOnClick;
import controller.ButtonCarritoEliminarOnClick;
import controller.ButtonCarritoRestarOnClick;
import controller.ControladorPedidos;
import model.Producto;
import persistencia.ProvisionalInventario;

public class UsuarioActivity extends AppCompatActivity {
    //Variables
    private ArrayList<Producto> listaProductos;
    private AdaptadorCarrito adaptador;
    private ListView listView1;
    private TextView textViewTotalCompra;

    @Override
    protected void onResume() {
        super.onResume();
        listaProductos = new ArrayList<Producto>();
        ControladorPedidos controladorPedidos = new ControladorPedidos(this);
        listaProductos = controladorPedidos.getPedidos();
        adaptador = new AdaptadorCarrito(this);
        listView1 = (ListView) findViewById(R.id.listView_CarritoCompras);
        listView1.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductos.size();i++){

            int cantidad = listaProductos.get(i).getCantidad();
            float precio = listaProductos.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        textViewTotalCompra = (TextView)findViewById(R.id.textView_ValorTotalCompra);

        listaProductos = new ArrayList<Producto>();
        ControladorPedidos controladorPedidos = new ControladorPedidos(this);
        listaProductos = controladorPedidos.getPedidos();
        adaptador = new AdaptadorCarrito(this);
        listView1 = (ListView) findViewById(R.id.listView_CarritoCompras);
        listView1.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();

        //Calcular el precio total del carrito de compras
        float total = 0;
        for(int i=0;i<listaProductos.size();i++){

            int cantidad = listaProductos.get(i).getCantidad();
            float precio = listaProductos.get(i).getPrecio();

            total = (total) + cantidad*precio;
        }
        textViewTotalCompra.setText("$" + String.valueOf(total));
    }

    public void abrirCategoriaGenerica(View view){
        Intent i = new Intent(this, CategoriaGenericaActivity.class);
        startActivity(i);
    }

//Metodos de apertura Botoner Categorias.
    public void abrirBebidas(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","bebidas");


        startActivity(i);
    }

    public void abrirBotanas(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","botanas");


        startActivity(i);
    }

    public void abrirDulces(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","dulces");


        startActivity(i);
    }

    public void abrirSabritas(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","sabritas");


        startActivity(i);
    }

    public void abrirPostres(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","postres");


        startActivity(i);
    }

    public void abrirGalletas(View view){
        Intent i= new Intent(this, CategoriaGenericaActivity.class);

        i.putExtra("categoria","galletas");


        startActivity(i);
    }

    public void confirmarCompra(View view){
        ControladorPedidos controladorPedidos = new ControladorPedidos(this);
        controladorPedidos.confirmarCompra(adaptador,listaProductos,textViewTotalCompra);
    }

    public void cancelarCompra(View view){
        ControladorPedidos controladorPedidos = new ControladorPedidos(this);
        controladorPedidos.cancelarCompra(adaptador,listaProductos,textViewTotalCompra);
    }
// Fin de metodos de los botones.



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
            textViewPrecio.setText("$ " + String.valueOf(listaProductos.get(position).getPrecio()));

            Button buttonAgregar = (Button)item.findViewById(R.id.button_CarritoMas);
            buttonAgregar.setOnClickListener(new ButtonCarritoAgregarOnClick(position,textViewCantidad,listaProductos,appCompatActivity,textViewTotalCompra));

            Button buttonRestar = (Button)item.findViewById(R.id.button_CarritoMenos);
            buttonRestar.setOnClickListener(new ButtonCarritoRestarOnClick(position,textViewCantidad,listaProductos,appCompatActivity,adaptador,textViewTotalCompra));

            Button buttonEliminar = (Button)item.findViewById(R.id.button_CarritoEliminar);
            buttonEliminar.setOnClickListener(new ButtonCarritoEliminarOnClick(position,listaProductos,adaptador));
            return (item);
        }
    }

}
