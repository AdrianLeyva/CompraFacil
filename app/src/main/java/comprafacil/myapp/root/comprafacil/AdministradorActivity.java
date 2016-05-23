package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import model.Producto;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdministradorActivity extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_administrador);


        listaProductos = new ArrayList<Producto>();
        listaProductos = getPedidos();


        AdaptadorSeries adaptador = new AdaptadorSeries(this);
        ListView listView1 = (ListView) findViewById(R.id.listView_Pedidos);
        listView1.setAdapter(adaptador);

     /*   ListView listViewPedidos = (ListView) findViewById(R.id.listView_Pedidos);
        listaProductos = getPedidos();
        AdapterListItemPedidos adaptador = new AdapterListItemPedidos(this, listaProductos);
        listViewPedidos.setAdapter(adaptador);
*/

        /*
        //Inicializa el listView con los pedidos actuales
        list = (ListView) findViewById(R.id.listView_Pedidos);
        adapter = new AdapterListItemPedidos(this, getPedidos());
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        */
    }
    public void cerrarSesion(View view){
        finish();
    }

    public ArrayList<Producto> getPedidos(){
        listaProductos.add(new Producto("Bebidas","Coca cola",4));
        listaProductos.add(new Producto("Bebida", "Pepsi",2));
        listaProductos.add(new Producto("Dulces", "Rockaleta",4));
        listaProductos.add(new Producto("Dulces", "TupsiPop",1));
        listaProductos.add(new Producto("Sabritas", "Doritos",2));
        return listaProductos;
    }

    public void abrirConsultarInventario(View view){
        Intent i = new Intent(this, ConsultaInventarioActivity.class);
        startActivity(i);

    }



    class AdaptadorSeries extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.list_item_pedidos, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_pedidos, null);

            int lastPosition = listaProductos.size() - 1;
            if(position == 0){

                TextView categoria = (TextView) item.findViewById(R.id.textView_CategoriaProducto);
                categoria.setVisibility(categoria.VISIBLE);
                categoria.setText("PEDIDO NUMERO #0000");
            }
            else if (position == lastPosition) {

                Button buttonConfirmar = (Button) item.findViewById(R.id.button_ConfirmarPedido);
                buttonConfirmar.setVisibility(buttonConfirmar.VISIBLE);

            }
            else if(position>0 && position<lastPosition){

                TextView categoria = (TextView) item.findViewById(R.id.textView_CategoriaProducto);
                categoria.setVisibility(categoria.VISIBLE);
                categoria.setText(listaProductos.get(position).getCategoria());

                TextView nombre = (TextView) item.findViewById(R.id.textView_NombreProducto);
                nombre.setVisibility(nombre.VISIBLE);
                nombre.setText(listaProductos.get(position).getNombre());

                TextView cantidad = (TextView) item.findViewById(R.id.textView_CantidadProductos);
                cantidad.setVisibility(cantidad.VISIBLE);
                cantidad.setText(String.valueOf(listaProductos.get(position).getCantidad()));
            }
            return (item);
        }
    }
}