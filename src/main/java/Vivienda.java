import java.util.Scanner;

public class Vivienda extends Inmueble {
    public static Scanner sc = new Scanner(System.in);
    public static float ivaVivienda = 0.10f;
    private int numHabit;
    private String descripcion;

    //constructores
    public Vivienda() {
    }

    public Vivienda(int m2, int id, int precio, String poblacion, int numHabit, String descripcion) {
        super(m2, id, precio, poblacion);
        this.numHabit = numHabit;
        this.descripcion = descripcion;
    }

    //getters y setters

    public static float getIvaVivienda() {
        return ivaVivienda;//solo sale get, porque al ser estatico solo se puede acceder, no se peude modificar
    }

    public int getNumHabit() {
        return numHabit;
    }

    //cambio el setter para que cada vez que quiera modificar numHab pase ese control y no sea 0 o menor.
    public void setNumHabit(int numHabit) {
        /*control para que esten obligados a escribir minimo 1 habitacion, al igual que el control del precio, se implementa en el setter
         *ya que este dato lo recogeremos del usuario y lo añadiremos*/
        while (numHabit <= 0) {
            System.out.println("Debe escribir mínimo 1 habitación:");
            numHabit = sc.nextInt();
        }
        this.numHabit = numHabit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "Vivienda de " + numHabit + " habitaciones, con descripcion " + descripcion + " y " + this.calcularPrecioCompraventa() + " €";
    }

    //metodos

    /*Método solicitarDatos. (0,5 puntos) Este método aparecerá en las tres clases, en cada una de las clases solicitará
     *los datos correspondientes a la propia clase completando la información de la instancia que esté haciendo uso de este método.*/
    @Override
    public void solicitarDatos() {
        super.solicitarDatos();
        System.out.println("Escribe la descripción de la vivienda:");
        this.setDescripcion(sc.nextLine());
        System.out.println("Escribe el número de habitaciones de la vivienda:");
        this.setNumHabit(sc.nextInt());
        sc.nextLine();//necesario despues de los nextInt para que no te salte
        System.out.println("Has añadido: " + super.toString() + this.toString());
    }

    /*Añadir Vivienda.(1 punto) Llamará al método solicitar Datos y devolverá una vivienda que se añadirá a la lista de inmuebles.
     *Este método pertenece a la clase Vivienda.*/
    public static Vivienda addVivienda() {
        Vivienda nuevaVivienda = new Vivienda();
        nuevaVivienda.solicitarDatos();
        return nuevaVivienda;
        //se añadirá a la lista al gestionar la inmobiliaria, ya que tenemos allí la lista de cada inmobiliaria inicializada
    }

    /*En el caso de la clase Vivienda los impuestos vendrán dados por el cálculo: precio * IVA que es de un 10%,
    después del cálculo imprimirá los datos de la vivienda y a continuación el importe de compraventa.
     */
    @Override
    public String calcularPrecioCompraventa() {
        return ("precio de compra de "+ (this.getPrecio() +(this.getPrecio()* ivaVivienda)));
    }
}
