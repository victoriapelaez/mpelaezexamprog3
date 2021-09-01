
//#Maria Victoria Pelaez Lozano - examen 1º DAW grupo Pong

import java.util.ArrayList;
import java.util.Scanner;

public class GestionInmobiliaria {
    public static Scanner sc = new Scanner(System.in); //lo genero al principio publico para tener acceso desde todos los métodos

    /*El programa principal (1 punto) incluido en la Clase GestionInmobiliaria,
    que se caracteriza por tener una lista de Inmobiliarias y el main con el que se gestionará el resto del programa.
    public static void main(String[] args) {
       iniciarInmobiliaria(listaInmobiliaria);
       Inmobiliaria inmobiliariaActiva=elegirInmobiliaria();
       menuPrincipalInmobiliaria(inmobiliariaActiva);
    }
    El main tendrá un menú que se llamará indefinidamente hasta que el usuario quiera salir de la aplicación.
    Hay que tener en cuenta que el menú trabaja con una inmobiliaria concreta y ofreciendo para ella todas las opciones
    que se detallan a continuación, por tanto es imprescindible saber primero con qué inmobiliaria trabajaremos (login).
    */
    public static void main(String[] args) {
        //considero necesario instanciar una Inmobiliaria para poder pasar por parámetro la lista de esa inmo, en el ejemplo no sale
        ArrayList<Inmobiliaria> listaInmobiliaria = new ArrayList<>();
        iniciarInmobiliaria(listaInmobiliaria);
        int codInmobiliaria = elegirInmobiliaria(listaInmobiliaria);
        menuPrincipalInmobiliaria(codInmobiliaria, listaInmobiliaria);
    }

    /*este método nos lo han proporcionado para la creación inicial de datos, solo modifique el nombre de algunas variables para
    entenderlo mejor*/
    public static void iniciarInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        Inmobiliaria inmobiliariaNueva;
        Terreno terrenoNuevo;
        Vivienda viviendaNueva;

        for (int i = 0; i < 4; i++) {
            inmobiliariaNueva = new Inmobiliaria();
            inmobiliariaNueva.setCodInmobiliaria("codInmob" + i);
            inmobiliariaNueva.setNombreInmob("nombreInmobiliaria" + 1);
            for (int j = 0; j < 4; j++) {
                terrenoNuevo = new Terreno();
                terrenoNuevo.setId(i + j);
                terrenoNuevo.setM2(j * 80);
                terrenoNuevo.setPoblacion("poblacion" + j);
                terrenoNuevo.setPrecio(30000 * (i + 1));
                terrenoNuevo.setTipoCalificacion(Calificacion.RUSTICO);
                inmobiliariaNueva.getListaInmueble().add(terrenoNuevo);

                viviendaNueva = new Vivienda();
                viviendaNueva.setId(i + j);
                viviendaNueva.setM2(j * 80);
                viviendaNueva.setPoblacion("poblacion" + j);
                viviendaNueva.setPrecio(30000 * (i + 1));
                viviendaNueva.setDescripcion("descripcion vivienda " + i);
                viviendaNueva.setNumHabit(i + j + 1);

                inmobiliariaNueva.getListaInmueble().add(viviendaNueva);
            }
            listaInmobiliaria.add(inmobiliariaNueva);

        }

    }

    public static void menuPrincipalInmobiliaria(int codInmobiliaria, ArrayList<Inmobiliaria> listaInmobiliaria) {
        boolean salir = false;
        int opcion;

        while (!salir && codInmobiliaria != -1) {
            System.out.println("-----------------------------------------------");
            System.out.println("---------------------MENÚ----------------------");
            System.out.println("-----------------------------------------------");
            System.out.println("1 - Añadir terreno");
            System.out.println("2 - Buscar terreno");
            System.out.println("3 - Añadir vivienda");
            System.out.println("4 - Buscar vivienda");
            System.out.println("5 - Salir");
            System.out.println("Escriba el número de la operación a realizar:");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha elegido la opción 1- Añadir terreno");
                    System.out.println("-----------------------------------------------");
                    listaInmobiliaria.get(codInmobiliaria).getListaInmueble().add(Terreno.añadirTerreno());
                    break;
                case 2:
                    System.out.println("Ha elegido la opción 2- Buscar terreno ");
                    System.out.println("-----------------------------------------------");
                    Inmueble.buscarTerreno(listaInmobiliaria.get(codInmobiliaria).getListaInmueble());

                    break;
                case 3:
                    System.out.println("Ha elegido la opción 3- Añadir vivienda");
                    System.out.println("-----------------------------------------------");
                    listaInmobiliaria.get(codInmobiliaria).getListaInmueble().add(Vivienda.addVivienda());
                    break;
                case 4:
                    System.out.println("Ha elegido la opción 4- Buscar vivienda");
                    System.out.println("-----------------------------------------------");
                    Inmueble.buscarVivienda(listaInmobiliaria.get(codInmobiliaria).getListaInmueble());
                    break;
                case 5:
                    salir = true;
                    System.out.println("Gracias por usar nuestro servicio. Hasta la próxima");
                    break;
                default:
                    System.out.println("No ha elegido ninguna opcion del menú.");
                    break;
            }

        }
    }

    /*El método elegirInmobiliaria del menú principal busca si el cif solicitado(hecho) al usuario dentro del mismo método coincide
     *con alguna de las inmobiliarias que tenemos en la listaInmobiliaria (array)(hecho), si coincide utilizaremos esa inmobiliaria
     *durante to do el programa. si no seguimos preguntando hasta que coincida, osea tendremos que comparar el cif introducido
     *con los cif existentes (más abajo tenéis la creación de un par).*/
    public static int elegirInmobiliaria(ArrayList<Inmobiliaria> lista) {
        System.out.println("Escribe el código de la inmobiliaria que deseas consultar: (codInmob0,codInmob1,codInmob2,codInmob3)");
        String codInmobiliaria = sc.nextLine();
        int i = 0, resultado = -1;
        boolean encontrado = false;

        while ((i < lista.size()) && (!encontrado)) {
            if (lista.get(i).getCodInmobiliaria().equals(codInmobiliaria)) {
                encontrado = true;
                resultado = i;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            System.out.println("NO SE HA ENCONTRADO NINGUNA INMOBILIARIA");
        }
        return resultado;
    }
}
