package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;

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
import android.widget.Toast;

import java.util.ArrayList;

import controller.AdapterListItemPedidos;
import model.Producto;

public class AdministradorActivity extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;

    public AdministradorActivity(){
        listaProductos = getPedidos();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try{
            super.onCreate(savedInstanceState);

            //Hacer la actividad FULLSCREEN
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_administrador);

            ListView listViewPedidos = (ListView) findViewById(R.id.listView_Pedidos);
            AdapterListItemPedidos adaptador = new AdapterListItemPedidos(this, listaProductos);
            listViewPedidos.setAdapter(adaptador);
        }
        catch (Exception e){
            if(listaProductos.size() == 0){
                Toast toast = Toast.makeText(this,"La lista está vacía",Toast.LENGTH_SHORT);
                toast.show();
            }
        }


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
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Producto pedido1 = new Producto("bebidas","coca cola,",2);
        Producto pedido2 = new Producto("botanas","doritos",1);
        Producto pedido3 = new Producto("Dulces","Rockaleta",4);
        lista.add(pedido1);
        lista.add(pedido2);
        lista.add(pedido3);
        return lista;
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
}