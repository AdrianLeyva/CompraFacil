package comprafacil.myapp.root.comprafacil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import model.Producto;
import persistencia.ProvisionalInventario;

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
import java.util.ArrayList;

public class AdministradorActivity extends AppCompatActivity {
    private ArrayList<Producto> listaProductos;
    private TextView textViewNombre;
    private TextView textViewPuesto;
    private  Button buttonModificarEmpleados;
    private Button buttonModificarInventario;
    private String administrador = "Administrador";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //Hacer la actividad FULLSCREEN
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_administrador);

        buttonModificarEmpleados = (Button)findViewById(R.id.button_Gestionar_Empleados);
        buttonModificarInventario = (Button)findViewById(R.id.button_Modificar_Inventario);


        String nombre = getIntent().getStringExtra("nombre");
        String puesto = getIntent().getStringExtra("puesto");

        if(puesto.compareTo(administrador)==0){
            buttonModificarEmpleados.setEnabled(true);
            buttonModificarInventario.setEnabled(true);
        }
        else{
            buttonModificarEmpleados.setEnabled(false);
            buttonModificarInventario.setEnabled(false);
        }

        textViewNombre = (TextView)findViewById(R.id.textView_Nombre_Usuario);
        textViewNombre.setText(nombre);

        textViewPuesto = (TextView)findViewById(R.id.textView_Puesto_Usuario);
        textViewPuesto.setText(puesto);

        listaProductos = new ArrayList<>();
        ProvisionalInventario provisionalInventario = new ProvisionalInventario();
        listaProductos = provisionalInventario.getListaProductos();


        AdaptadorSeries adaptador = new AdaptadorSeries(this);
        ListView listView1 = (ListView) findViewById(R.id.listView_Pedidos);
        listView1.setAdapter(adaptador);

    }
    public void cerrarSesion(View view){
        finish();
    }


    public void abrirConsultarInventario(View view){
        Intent i = new Intent(this, ConsultaInventarioActivity.class);
        startActivity(i);

    }

    public void abrirModificarInventario(View view){
        Intent i = new Intent(this, GestionarInventario.class);
        startActivity(i);
    }

    public void abrirGestionarEmpleado(View view){
        Intent i = new Intent(this, GestionarEmpleadosActivity.class);
        startActivity(i);
    }



    class AdaptadorSeries extends ArrayAdapter<Producto> {

        AppCompatActivity appCompatActivity;

        AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.list_item_pedidos, listaProductos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_pedidos, null);

            int lastPosition = listaProductos.size() - 1;
            if(position == 0){

                TextView categoria = (TextView) item.findViewById(R.id.textView_CategoriaProducto);
                categoria.setVisibility(categoria.VISIBLE);
                categoria.setText("PEDIDO NUMERO #0000");
            }
            else if (position == lastPosition) {

                Button buttonConfirmar = (Button) item.findViewById(R.id.button_ConfirmarPedido);
                buttonConfirmar.setVisibility(buttonConfirmar.VISIBLE);

            }
            else if(position>0 && position<lastPosition){

                TextView categoria = (TextView) item.findViewById(R.id.textView_CategoriaProducto);
                categoria.setVisibility(categoria.VISIBLE);
                categoria.setText(listaProductos.get(position).getCategoria());

                TextView nombre = (TextView) item.findViewById(R.id.textView_NombreProducto);
                nombre.setVisibility(nombre.VISIBLE);
                nombre.setText(listaProductos.get(position).getNombre());

                TextView cantidad = (TextView) item.findViewById(R.id.textView_CantidadProductos);
                cantidad.setVisibility(cantidad.VISIBLE);
                cantidad.setText(String.valueOf(listaProductos.get(position).getCantidad()));
            }
            return (item);
        }
    }
}