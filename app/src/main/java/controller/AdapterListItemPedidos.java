package controller;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemPedidos listItemPedidos = new ListItemPedidos(activity, listaProductos.get(position));
        return listItemPedidos;
    }
}
