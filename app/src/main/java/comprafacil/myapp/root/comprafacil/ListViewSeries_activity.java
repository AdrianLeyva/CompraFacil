package comprafacil.myapp.root.comprafacil;
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewSeries_activity extends AppCompatActivity {
    private ArrayList<Series> listaSeries;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list__producto);

        listaSeries = new ArrayList<Series>();
        listaSeries.add(new Series("Game of Thrones", "La más chida", "drama" ));
        listaSeries.add(new Series("Vikings", "chida", "acción"));
        listaSeries.add(new Series("Walking Dead", "Muy chida", "Suspenso"));
        listaSeries.add(new Series("Suits", "Muy buena", "Abogados"));
        listaSeries.add(new Series("Breaking Bad", "muy lenta", "Drama"));

        AdaptadorSeries adaptador = new AdaptadorSeries(this);
        ListView listView1 = (ListView) findViewById(R.id.listView);
        listView1.setAdapter(adaptador);
    }


    class AdaptadorSeries extends ArrayAdapter<Series> {

        AppCompatActivity appCompatActivity;

        AdaptadorSeries(AppCompatActivity context) {
            super(context, R.layout.elementos_series, listaSeries);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.elementos_series, null);

            TextView textView1 = (TextView) item.findViewById(R.id.tvnombre);
            textView1.setText(listaSeries.get(position).getNombre());

            TextView textView2 = (TextView) item.findViewById(R.id.tvgenero);
            textView2.setText(listaSeries.get(position).getGenero());

            TextView textView3 = (TextView) item.findViewById(R.id.tvpuesto);
            textView3.setText(listaSeries.get(position).getPuesto());

            return (item);
        }
    }
}
*/