package comprafacil.myapp.root.comprafacil;

/**
 * Created by kevin gamboa on 24/04/16.
 */

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
import java.util.ArrayList;
import model.Producto;
import controller.ControladorProducto;

public class ConsultaInventarioActivity extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    private ControladorProducto controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_consulta_inventario);

        //Se extrae la lista de los productos desde la persistencia.
        controlador = new ControladorProducto();
        listaProductos = new ArrayList<Producto>();
        listaProductos = controlador.getProductosPersistencia();

        //Realiza el proceso del adaptador, para mandarle la vista de los elementos
        AdaptadorInventario adaptador = new AdaptadorInventario(this);
        ListView lv_Inventario = (ListView) findViewById(R.id.lv_elementos_inventario);
        lv_Inventario.setAdapter(adaptador);
    }




private class AdaptadorInventario extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorInventario(AppCompatActivity context) {
            super(context, R.layout.list_item_consulta_inventario, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_consulta_inventario, null);

            TextView tvnombre_inventario = (TextView) item.findViewById(R.id.elemento_inventario_nombre);
            tvnombre_inventario.setText(listaProductos.get(position).getNombre());

            TextView tvcategoria_inventario = (TextView) item.findViewById(R.id.elemento_inventario_categoria);
            tvcategoria_inventario.setText(listaProductos.get(position).getCategoria());

            TextView tvcantidad_inventario = (TextView) item.findViewById(R.id.elemento_inventario_cantidad);
            tvcantidad_inventario.setText(String.valueOf(listaProductos.get(position).getCantidad()));

            TextView tvprecio_inventario = (TextView) item.findViewById(R.id.elemento_inventario_precio);
            tvprecio_inventario.setText("$ " + String.valueOf(listaProductos.get(position).getPrecio()));

            return (item);
        }
    }

}
