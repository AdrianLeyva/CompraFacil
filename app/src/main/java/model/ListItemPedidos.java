package model;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.widget.TextView;

import comprafacil.myapp.root.comprafacil.R;

/**
 * Created by leyva on 18/05/2016.
 */
public class ListItemPedidos extends LinearLayout {

    private Producto producto;
    private TextView textViewNombreProducto;
    private TextView textViewCategoriaProducto;
    private TextView textViewCantidadProductos;
    private Button buttonConfirmar;

    public ListItemPedidos(Context context, Producto producto) {
        super(context);
        this.producto = producto;
        inicializar();
    }

    private void inicializar() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.list_item_pedidos, this, true);

        textViewNombreProducto = (TextView) findViewById(R.id.textView_NombreProducto);
        textViewCategoriaProducto = (TextView) findViewById(R.id.textView_CategoriaProducto);
        textViewCantidadProductos = (TextView) findViewById(R.id.textView_CantidadProductos);
        buttonConfirmar = (Button) findViewById(R.id.button_Confirmar);

        textViewNombreProducto.setText(producto.getNombre());
        textViewCategoriaProducto.setText(producto.getCategoria());
        textViewCantidadProductos.setText(producto.getCantidad());
    }
}