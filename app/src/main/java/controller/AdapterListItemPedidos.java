package controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import comprafacil.myapp.root.comprafacil.R;
import model.ListItemPedidos;
import model.Producto;

/**
 * Created by leyva on 18/05/2016.
 */
public class AdapterListItemPedidos extends BaseAdapter {

    private Activity activity;
    private ArrayList<Producto> listaProductos;

    public AdapterListItemPedidos(Activity activity, ArrayList<Producto> listaProductos){
        this.activity = activity;
        this.listaProductos = listaProductos;

        if(listaProductos.size() == 0){
            Toast toast = Toast.makeText(activity,"La lista está vacia",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {

        View vi = contentView;

        if(contentView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.list_item_pedidos, null);
        }

        Producto producto = listaProductos.get(position);

        TextView textViewNombreProducto = (TextView) vi.findViewById(R.id.textView_NombreProducto);
        TextView textViewCategoriaProducto = (TextView) vi.findViewById(R.id.textView_CategoriaProducto);
        TextView textViewCantidadProductos = (TextView) vi.findViewById(R.id.textView_CantidadProductos);
        Button buttonConfirmar = (Button) vi.findViewById(R.id.button_Confirmar);

        textViewNombreProducto.setText(producto.getNombre());
        textViewCategoriaProducto.setText(producto.getCategoria());
        textViewCantidadProductos.setText(producto.getCantidad());

        return vi;
    }
}
