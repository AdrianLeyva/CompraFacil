package comprafacil.myapp.root.comprafacil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import controller.ButtonAgregarProductoCategoriaGenerica;
import controller.ButtonCarritoAgregarOnClick;
import controller.ButtonCarritoEliminarOnClick;
import controller.ButtonCarritoRestarOnClick;
import controller.ControladorProducto;
import model.Producto;
import persistencia.ProvisionalInventario;

public class CategoriaGenericaActivity extends AppCompatActivity {
    //Variables
    private ArrayList<Producto> listaProductos;
    private ArrayList<Producto> listaProductosCarrito;
    private AdaptadorCategoriaGenerica adaptador;
    private AdaptadorCarrito adaptador2;
    private ListView listViewProductos;
    private ListView listView1;
    private String categoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_generica);

        categoria = getIntent().getStringExtra("categoria");


        listaProductos = extraerCategorias();
        adaptador = new AdaptadorCategoriaGenerica(this);
        listViewProductos = (ListView) findViewById(R.id.lv_categoria_generica);
        listViewProductos.setAdapter(adaptador);

        listaProductosCarrito = new ArrayList<Producto>();
        adaptador2 = new AdaptadorCarrito(this);
        listView1 = (ListView) findViewById(R.id.listView_CarritoCompras);
        listView1.setAdapter(adaptador2);
    }


    //Bloque Switch
    public ArrayList<Producto> extraerCategorias() {
        ArrayList<Producto> listaProductoBD;
        ArrayList<Producto> listaProductoCategoriaSelec = new ArrayList<Producto>();


        ControladorProducto controladorProducto = new ControladorProducto();
        listaProductoBD = controladorProducto.getProductosPersistencia();

        switch (categoria) {
            case "bebidas":

                for (int i = 0; i < listaProductoBD.size(); i++) {

                 if (listaProductoBD.get(i).getCategoria().compareTo("Bebidas") == 0) {
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));
                        listaProductoCategoriaSelec.get(i).setCantidad(1);

                    }


                }
                return listaProductoCategoriaSelec;

            case "botanas":
                for (int i = 0; i < listaProductoBD.size(); i++) {

                    if (listaProductoBD.get(i).getCategoria().compareTo("Botanas") == 0) {
                        listaProductoBD.get(i).setCantidad(1);
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));

                    }


                }
                return listaProductoCategoriaSelec;

            case "dulces":
                for (int i = 0; i < listaProductoBD.size(); i++) {

                    if (listaProductoBD.get(i).getCategoria().compareTo("Dulces") == 0) {
                        listaProductoBD.get(i).setCantidad(1);
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));


                    }


                }
                return listaProductoCategoriaSelec;

            case "postres":
                for (int i = 0; i < listaProductoBD.size(); i++) {

                    if (listaProductoBD.get(i).getCategoria().compareTo("Postres") == 0) {
                        listaProductoBD.get(i).setCantidad(1);
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));

                    }


                }
                return listaProductoCategoriaSelec;

            case "galletas":
                for (int i = 0; i < listaProductoBD.size(); i++) {

                    if (listaProductoBD.get(i).getCategoria().compareTo("Galletas") == 0) {
                        listaProductoBD.get(i).setCantidad(1);
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));

                    }


                }
                return listaProductoCategoriaSelec;

            case "sabritas":
                for (int i = 0; i < listaProductoBD.size(); i++) {

                    if (listaProductoBD.get(i).getCategoria().compareTo("Sabritas") == 0) {
                        listaProductoBD.get(i).setCantidad(1);
                        listaProductoCategoriaSelec.add(listaProductoBD.get(i));

                    }


                }
                return listaProductoCategoriaSelec;

            default:
                break;
        }

        return listaProductoCategoriaSelec;
    }

        class AdaptadorCategoriaGenerica extends ArrayAdapter<Producto> {

            AppCompatActivity appCompatActivity;

            AdaptadorCategoriaGenerica(AppCompatActivity context) {
                super(context, R.layout.list_item_categoria_generica, listaProductos);
                appCompatActivity = context;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = appCompatActivity.getLayoutInflater();
                View item = inflater.inflate(R.layout.list_item_categoria_generica, null);

                TextView textViewNombre = (TextView) item.findViewById(R.id.elemento_categoriagenerica_nombre);
                textViewNombre.setText(listaProductos.get(position).getNombre());

                TextView textViewPrecio = (TextView) item.findViewById(R.id.elemento_categoriagenerica_precio);
                textViewPrecio.setText("$ " +String.valueOf(listaProductos.get(position).getPrecio()));

                Button buttonAgregarProCategoria = (Button) item.findViewById(R.id.button_categoria_generica);
                buttonAgregarProCategoria.setOnClickListener(new ButtonAgregarProductoCategoriaGenerica(position, listaProductosCarrito, appCompatActivity, listaProductos, adaptador2));

                return (item);
            }
        }

        class AdaptadorCarrito extends ArrayAdapter<Producto> {

            AppCompatActivity appCompatActivity;

            AdaptadorCarrito(AppCompatActivity context) {
                super(context, R.layout.list_item_carrito_compras, listaProductosCarrito);
                appCompatActivity = context;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = appCompatActivity.getLayoutInflater();
                View item = inflater.inflate(R.layout.list_item_carrito_compras, null);

                TextView textViewNombre = (TextView) item.findViewById(R.id.textView_CarritoProducto);
                textViewNombre.setText(listaProductosCarrito.get(position).getNombre());

                TextView textViewCantidad = (TextView) item.findViewById(R.id.textView_CarritoCantidad);
                textViewCantidad.setText(String.valueOf(listaProductosCarrito.get(position).getCantidad()));

                TextView textViewPrecio = (TextView) item.findViewById(R.id.textView_CarritoPrecio);
                textViewPrecio.setText("$ " + String.valueOf(listaProductosCarrito.get(position).getPrecio()));

                Button buttonAgregar = (Button) item.findViewById(R.id.button_CarritoMas);
                buttonAgregar.setOnClickListener(new ButtonCarritoAgregarOnClick(position, textViewCantidad, listaProductosCarrito, appCompatActivity));

                Button buttonRestar = (Button) item.findViewById(R.id.button_CarritoMenos);
                buttonRestar.setOnClickListener(new ButtonCarritoRestarOnClick(position, textViewCantidad, listaProductosCarrito, appCompatActivity, adaptador2));

                Button buttonEliminar = (Button) item.findViewById(R.id.button_CarritoEliminar);
                buttonEliminar.setOnClickListener(new ButtonCarritoEliminarOnClick(position, listaProductosCarrito, adaptador2, adaptador));
                return (item);
            }
        }

    }



