package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import model.Producto;

public class ModificarInventario extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_inventario);

        listaProductos = new ArrayList<>();
        listaProductos = getPedidos();

        AdaptadorSeries adaptador = new AdaptadorSeries(this);
        ListView listView1 = (ListView) findViewById(R.id.listView_ModificarInventario);
        listView1.setAdapter(adaptador);
    }

    public ArrayList<Producto> getPedidos(){
        listaProductos.add(new Producto("Bebidas","Coca cola",11,8));
        listaProductos.add(new Producto("Bebida", "Pepsi",10,20));
        listaProductos.add(new Producto("Dulces", "Rockaleta", 5, 15));
        listaProductos.add(new Producto("Dulces", "TupsiPop", 4, 10));
        listaProductos.add(new Producto("Sabritas", "Doritos", 13, 18));
        return listaProductos;
    }


    class AdaptadorSeries extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.list_item_gestionar_inventario, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_gestionar_inventario, null);

            EditText categoria = (EditText) item.findViewById(R.id.editText_Categoria);
            categoria.setText(String.valueOf(listaProductos.get(position).getCategoria()));

            EditText nombre = (EditText) item.findViewById(R.id.editText_Producto);
            nombre.setText(String.valueOf(listaProductos.get(position).getNombre()));

            EditText precio = (EditText) item.findViewById(R.id.editText_Precio);
            precio.setText(String.valueOf(listaProductos.get(position).getPrecio()));

            EditText cantidad = (EditText) item.findViewById(R.id.editText_Cantidad);
            cantidad.setText(String.valueOf(listaProductos.get(position).getCantidad()));

          return (item);
        }
    }
}
