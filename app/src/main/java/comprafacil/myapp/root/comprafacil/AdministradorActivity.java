package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import comprafacil.myapp.root.comprafacil.Series;
import java.util.ArrayList;

import controller.AdapterListItemPedidos;
import model.Producto;

public class AdministradorActivity extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    private ArrayList<Series> listaSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_administrador);


        listaSeries = new ArrayList<Series>();
        listaSeries = getPedidos();


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

    public ArrayList<Series> getPedidos(){
        listaSeries.add(new Series("Game of Thrones", "La más chida", "drama" ));
        listaSeries.add(new Series("Vikings", "chida", "acción"));
        listaSeries.add(new Series("Walking Dead", "Muy chida", "Suspenso"));
        listaSeries.add(new Series("Suits", "Muy buena", "Abogados"));
        listaSeries.add(new Series("Breaking Bad", "muy lenta", "Drama"));
        return listaSeries;
    }
/*
    class AdaptadorSeries extends ArrayAdapter<Producto>{

        AppCompatActivity appCompatActivity;
        public AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.list_item_pedidos, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_pedidos, null);

            TextView textViewNombreProducto = (TextView) item.findViewById(R.id.textView_NombreProducto);
            TextView textViewCategoriaProducto = (TextView) item.findViewById(R.id.textView_CategoriaProducto);
            TextView textViewCantidadProductos = (TextView) item.findViewById(R.id.textView_CantidadProductos);
            Button buttonConfirmar = (Button) findViewById(R.id.button_Confirmar);

            textViewNombreProducto.setText(listaProductos.get(position).getNombre());
            textViewCategoriaProducto.setText(listaProductos.get(position).getCategoria());
            textViewCantidadProductos.setText(listaProductos.get(position).getCantidad());

            return (item);
        }
    }



*/

    class AdaptadorSeries extends ArrayAdapter<Series> {

        AppCompatActivity appCompatActivity;

        AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.elementos_series, listaSeries);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.elementos_series, null);

            TextView textView1 = (TextView) item.findViewById(R.id.tvnombre);
            textView1.setText(listaSeries.get(position).getNombre());

            TextView textView2 = (TextView) item.findViewById(R.id.tvgenero);
            textView2.setText(listaSeries.get(position).getGenero());

            TextView textView3 = (TextView) item.findViewById(R.id.tvpuesto);
            textView3.setText(listaSeries.get(position).getPuesto());

            return (item);
        }
    }
}