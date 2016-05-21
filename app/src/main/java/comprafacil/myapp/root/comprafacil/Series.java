package comprafacil.myapp.root.comprafacil;

/**
 * Created by kevingamboa17 on 16/05/16.
 */
public class Series {

    private String nombre;
    private String puesto;
    private String genero;
    private String variable1 = "hola 1";
    private String variable2 = "hola 2";

    public Series(String nombre, String puesto, String genero) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }


    public String getPuesto() {
        return puesto;
    }


    public String getGenero() {
        return genero;
    }


    public String getVariable1() {
        return variable1;
    }

    public String getVariable2() {
        return variable2;
    }
}
