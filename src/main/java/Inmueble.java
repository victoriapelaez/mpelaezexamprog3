import java.util.ArrayList;
import java.util.Scanner;

public abstract class Inmueble {
    public static Scanner sc = new Scanner(System.in);
    private int m2, id;
    private int precio;
    private String poblacion;
    private static int ultId;//al igual que la practica anterior veo necesario que cada inmueble coja el código del anterior

    //constructor vacio
    public Inmueble() {
        id = ultId++;//añado como la practica anterior
    }

    //constructor con parametros
    public Inmueble(int m2, int id, int precio, String poblacion) {
        this.m2 = m2;
        id = ultId++;//lo cambio para que en conjunto con los otros cambios cambie el id cada vez que se crea uno
        this.precio = precio;
        this.poblacion = poblacion;
    }

    //getters y setters
    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        /*control para que el precio no pueda ser 0, lo implemento en el setter porque lo voy a ir introduciendo a medida que lo pidan y se
        irá modificando para cada uno.*/
        while (precio <= 0) {
            System.out.println("El precio debe ser superior a 0 €. Por favor escriba de nuevo un precio.");
            precio = sc.nextInt();
        }
        this.precio = precio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    //toString
    @Override
    public String toString() {
        return "un Inmueble de " + m2 + " m2, con precio coste de " + precio + " €, con poblacion en " + poblacion + " e identificador: " + id + ". ";
    }

    //metodos
    /*Buscar Vivienda. (1,5 puntos) Recibirá como parámetro una lista de Inmuebles(hecho) y solicitará al usuario un número de habitaciones.(hecho)
     *El método mostrará toda la información de todas aquellas Viviendas que cumplan con el criterio:  número de habitaciones.
     *Este método pertenece a la clase Inmueble.(hecho)
     */
    public static void buscarVivienda(ArrayList<Inmueble> lista) {
        System.out.println("Escribe el número de habitaciones que deseas:");
        int numHabit = sc.nextInt();
        System.out.println("Estan son las viviendas encontradas según sus elecciones:");
        for (int i = 0; i < lista.size(); i++) {
            /*Al igual que la practica anterior, que usabamos el instance of para seleccionar el tipo de tarjeta,
             * aqui lo usamos para que de la lista de inmuebles selecciones viviendas y miramos si coincide el numero
             * de habitaciones dado con el numero de habitaciones que tiene*/
            if (lista.get(i) instanceof Vivienda) {
                if (((Vivienda) lista.get(i)).getNumHabit() == numHabit) {
                    System.out.println(i + 1 + ") " + (lista.get(i)).toString());
                }
            }
        }
    }

    /*Buscar Terreno. (1,5 puntos) Recibirá como parámetro una lista de Inmuebles(hecho) y solicitará al usuario un tipo de calificación
     *(rústico, urbano y urbanizable)(hecho). El método mostrará toda la información del primer terreno que cumpla con la calificación
     * buscada (rústico, urbano y urbanizable)(hecho). Este método pertenece a la clase Inmueble.(hecho)
     */
    public static void buscarTerreno(ArrayList<Inmueble> lista) {
        System.out.println("Al seleccionar el tipo de calificacion se le mostrará el primer inmueble de ese tipo.");
        System.out.println("Introduce el tipo de calificación del suelo: ");
        System.out.println("0- RUSTICO");
        System.out.println("1- URBANO");
        System.out.println("2- URBANIZABLE");
        int numCalificacion = sc.nextInt();

        int inicial = 0;
        boolean encontrado = false;
        while ((inicial < lista.size()) && (!encontrado)) {
            /*Al igual que la practica anterior, que usabamos el instance of para seleccionar el tipo de tarjeta,
             * aqui lo usamos para que de la lista de inmuebles selecciones terrenos y comparamos de la misma manera que las
             * habitaciones pero con la calificacion*/
            if (lista.get(inicial) instanceof Terreno) {
                if (((Terreno) lista.get(inicial)).getTipoCalificacion().ordinal() == numCalificacion) {
                    encontrado = true;
                    System.out.println("Terreno encontrado: " + (lista.get(inicial)).toString());
                }
            }
            inicial++;
        }
        if (!encontrado) {
            System.out.println("NO SE HA ENCONTRADO NINGÚN TERRENO CON LA CALIFICACIÓN SOLICITADA.");
            System.out.println("---------------------------------------------------------------------");
        }
    }

    /*Calcular PrecioCompraventa. (1 punto). Este método será de obligada implementación por las clases herederas(hecho),
    ya que el precio de compraventa es su precio+impuestos y los impuestos varían según el tipo de Inmueble.
    Este método se llamará desde el método toString de las diferentes clases implicadas, así mostrará el precio de
    compraventa según sea Vivienda o Terreno.
     */
    //metodo abstracto para que hereden las hijas y se calcule alli
    public abstract String calcularPrecioCompraventa();

    /*Método solicitarDatos. (0,5 puntos) Este método aparecerá en las tres clases(hecho con @override), en cada una de las clases solicitará
     *los datos correspondientes(hecho los de cada una) a la propia clase completando la información de la instancia que esté haciendo uso de este método.*/
    //método para solicitar datos que servirá en las clases hijas pero se sobreescribirá con lo que pide cada una
    public void solicitarDatos() {
        System.out.println("Escriba los m2:");
        this.setM2(sc.nextInt());
        System.out.println("Escriba el precio:");
        this.setPrecio(sc.nextInt());
        sc.nextLine();
        System.out.println("Escriba la población:");
        this.setPoblacion(sc.nextLine());
    }


}
