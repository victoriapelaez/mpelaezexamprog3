import java.util.Scanner;

public class Terreno extends Inmueble {
    private Calificacion tipoCalificacion;
    public static float ivaRustico = 0.04f;
    public static float ivaUrbano = 0.06f;
    public static float ivaUrbanizable = 0.08f;

    //constructores
    public Terreno() {
    }

    public Terreno(int m2, int id, int precio, String poblacion, Calificacion tipoCalificacion) {
        super(m2, id, precio, poblacion);
        this.tipoCalificacion = tipoCalificacion;
    }

    //getters y setters
    public Calificacion getTipoCalificacion() {
        return tipoCalificacion;
    }

    public void setTipoCalificacion(Calificacion tipoCali) {
        this.tipoCalificacion = tipoCali;
    }

    /*Es necesario modificar el setter de tipoCalificacion para que segun lo que se elija, vaya directamente a la opcion
     * del enum, que son como constantes, y añada ese dato solicitado*/
    public void setTipoCalificacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tipo de calificación del suelo, para ello escribe el número elegido: ");
        System.out.println("1- RUSTICO");
        System.out.println("2- URBANO");
        System.out.println("3- URBANIZABLE");
        int numCalificacion = sc.nextInt();

        switch (numCalificacion) {
            case 1:
                this.tipoCalificacion = Calificacion.RUSTICO;
                break;
            case 2:
                this.tipoCalificacion = Calificacion.URBANO;
                break;
            case 3:
                this.tipoCalificacion = Calificacion.URBANIZABLE;
                break;
            default:
                System.out.println("El tipo de suelo introducido es incorrecto");
                break;
        }
    }

    //metodos de solo consulta para los atributos estaticos, ya que no se pueden modificar
    public static float getIvaRustico() {
        return ivaRustico;
    }

    public static float getIvaUrbano() {
        return ivaUrbano;
    }

    public static float getIvaUrbanizable() {
        return ivaUrbanizable;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + " Terreno de tipo de Calificacion: " + tipoCalificacion + " y " + this.calcularPrecioCompraventa();
    }


//metodos

    /*Método solicitarDatos. (0,5 puntos) Este método aparecerá en las tres clases, en cada una de las clases solicitará
     *los datos correspondientes a la propia clase completando la información de la instancia que esté haciendo uso de este método.*/
    @Override
    public void solicitarDatos() {
        super.solicitarDatos();
        this.setTipoCalificacion();
        System.out.println("Has añadido " + this.toString());
    }

    /*Añadir Terreno. (1 punto) Llamará al método solicitar Datos (aparece en el punto F) y
     *devolverá un terreno que se añadirá a la lista de inmuebles. Este método pertenece a la clase Terreno.*/
    public static Terreno añadirTerreno() {
        Terreno nuevoTerreno = new Terreno();
        nuevoTerreno.solicitarDatos();
        return nuevoTerreno;
        //se añadirá a la lista al gestionar la inmobiliaria, ya que tenemos allí la lista de cada inmobiliaria inicializada
    }
/*Aunque la practica ponga precio * iva yo considero que hay que hacer precio+precio*iva por ser mas logico*/
    @Override
    public String calcularPrecioCompraventa() {
        String resultado;
        switch (this.getTipoCalificacion().ordinal()) {
            case 0:
                resultado = " Precio de compra de la vivienda= "
                        + (this.getPrecio() +(this.getPrecio()* ivaRustico)) + " €";
                break;
            case 1:
                resultado = " Precio de compra de la vivienda= "
                        + (this.getPrecio() +(this.getPrecio()* ivaUrbano)) + " €";
                break;
            case 2:
                resultado = " Precio de compra de la vivienda= "
                        + (this.getPrecio() +(this.getPrecio()* ivaUrbanizable)) + " €";
                break;
            default:
                resultado = ("No se ha podido calcular.");
                break;
        }
        return resultado;
    }
}
