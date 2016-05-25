package controller;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Empleado;

/**
 * Created by kevingamboa17 on 24/05/16.
 */
public class EditTextNombreEmpleadosWatcher implements TextWatcher {
    int position;
    private ArrayList<Empleado> listaEmpleados;
    EditText categoria;
    Context context;

    public EditTextNombreEmpleadosWatcher(int position, ArrayList<Empleado> listaEmpleados, EditText categoria,Context context){
        this.position = position;
        this.listaEmpleados = listaEmpleados;
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
        listaEmpleados.get(position).setNombre(s.toString());
    }
}