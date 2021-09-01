import java.util.ArrayList;

public class Inmobiliaria {

    private ArrayList<Inmueble> listaInmueble = new ArrayList<>();
    private String nombreInmob, codInmobiliaria;

    //constructor vacio
    public Inmobiliaria() {
    }

    //constructor con parametros
    public Inmobiliaria(ArrayList<Inmueble> listaInmueble, String nombreInmob, String codInmobiliaria) {
        this.listaInmueble = listaInmueble;
        this.nombreInmob = nombreInmob;
        this.codInmobiliaria = codInmobiliaria;
    }

    //getters y setters
    public ArrayList<Inmueble> getListaInmueble() {
        return listaInmueble;
    }

    public void setListaInmueble(ArrayList<Inmueble> listaInmueble) {
        this.listaInmueble = listaInmueble;
    }

    public String getNombreInmob() {
        return nombreInmob;
    }

    public void setNombreInmob(String nombreInmob) {
        this.nombreInmob = nombreInmob;
    }

    public String getCodInmobiliaria() {
        return codInmobiliaria;
    }

    public void setCodInmobiliaria(String codInmobiliaria) {
        this.codInmobiliaria = codInmobiliaria;
    }

    //toString
    @Override
    public String toString() {
        return "Inmobiliaria: lista de Inmuebles: " + listaInmueble + ", nombre de Inmobiliaria: " + nombreInmob + ", con código:" + codInmobiliaria + ".";
    }

}
