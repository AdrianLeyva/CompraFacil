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

public class GestionarInventario extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    private AdaptadorSeries adaptador;
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionar_inventario);

        listaProductos = new ArrayList<>();
        listaProductos = getPedidos();

        adaptador = new AdaptadorSeries(this);
        listView1 = (ListView) findViewById(R.id.listView_ModificarInventario);
        listView1.setAdapter(adaptador);
    }

    public ArrayList<Producto> getPedidos(){
        listaProductos.add(new Producto("Bebidas", "Coca cola", 11, 8));
        listaProductos.add(new Producto("Bebida", "Pepsi", 10, 20));
        listaProductos.add(new Producto("Dulces", "Rockaleta", 5, 15));
        listaProductos.add(new Producto("Dulces", "TupsiPop", 4, 10));
        listaProductos.add(new Producto("Sabritas", "Doritos", 13, 18));
        return listaProductos;
    }

    public void agregarNuevoProducto(View view){
        EditText editTextNombre = (EditText)findViewById(R.id.editText_NombreProducto);
        EditText editTextCategoria = (EditText)findViewById(R.id.editText_CategoriaProducto);
        EditText editTextPrecio = (EditText)findViewById(R.id.editText_PrecioProducto);
        EditText editTextCantidad = (EditText)findViewById(R.id.editText_CantidadProducto);

        String nombre = editTextNombre.getText().toString();
        String categoria = editTextCategoria.getText().toString();
        float precio = Float.valueOf(editTextPrecio.getText().toString());
        int cantidad = Integer.valueOf(editTextCantidad.getText().toString());

        listaProductos.add(new Producto(categoria,nombre,precio,cantidad));
        adaptador.notifyDataSetChanged();
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
            categoria.setHint(String.valueOf(listaProductos.get(position).getCategoria()));

            EditText nombre = (EditText) item.findViewById(R.id.editText_Producto);
            nombre.setHint(String.valueOf(listaProductos.get(position).getNombre()));

            EditText precio = (EditText) item.findViewById(R.id.editText_Precio);
            precio.setHint(String.valueOf(listaProductos.get(position).getPrecio()));

            EditText cantidad = (EditText) item.findViewById(R.id.editText_Cantidad);
            cantidad.setHint(String.valueOf(listaProductos.get(position).getCantidad()));

          return (item);
        }
    }
}
