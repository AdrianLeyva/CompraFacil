package controller;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Producto;

/**
 * Created by leyva on 24/05/2016.
 */
public class EditTextCategoriaWatcher implements TextWatcher {
    int position;
    private ArrayList<Producto> listaProductos;
    EditText categoria;
    Context context;

    public EditTextCategoriaWatcher(int position, ArrayList<Producto> listaProductos, EditText categoria,Context context){
        this.position = position;
        this.listaProductos = listaProductos;
        this.categoria = categoria;
        this.context = context;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        listaProductos.get(position).setCategoria(s.toString());

    }
}
