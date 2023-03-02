import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
    Scanner sc = new Scanner(System.in);
    /*Para las necesidades de un sitio de venta online de libros de informática, ediciones ENI por ejemplo, se pide crear una clase que permita modelizar a un cliente. Todos los clientes tienen un nombre y se les debe asignar un número de cliente. También se pide escribir un algoritmo de prueba para capturar y mostrar clientes.*/
    private String nombre;
    private int numeroCliente;
    private static int contador = 0;

    ArrayList<Ejercicio2> clientes = new ArrayList<Ejercicio2>();

    public Ejercicio2(String nombre, ArrayList<Ejercicio2> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.numeroCliente = contador++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public ArrayList<Ejercicio2> getClientes() {
        for(int i =0; i < clientes.size(); i++){
            System.out.println(clientes.get(i).getNombre() + " " + clientes.get(i).getNumeroCliente());
        }
        return clientes;
    }

    public void setClientes(ArrayList<Ejercicio2> clientes) {
        this.clientes = clientes;
    }


    public static void main(String[] args) {
         List<Ejercicio2> clientes = new ArrayList<>();

        int option = 0;
        try(Scanner sc = new Scanner(System.in)){
            do{
                menuEjercicio();
                try{
                    option = sc.nextInt();
                }catch (InputMismatchException ex){
                    sc.next();
                    option = -1;
                }
                switch (option){
                    case 0:
                        System.out.println("Adiós");
                        return;
                    case 1:
                        System.out.println("Añadir cliente");
                        System.out.println("Introduce el nombre del cliente: ");
                        String nombre = sc.nextLine();
                        Ejercicio2 cliente = new Ejercicio2(nombre, new ArrayList<>());
                        clientes.add(cliente);
                        break;
                    case 2:
                        System.out.println("Mostar clientes");
                        for(int i = 0; i < clientes.size(); i++){
                            System.out.println(clientes.get(i).getNombre() + " " + clientes.get(i).getNumeroCliente());
                        }


                        break;
                }
            }while (option >=0 || option < 3);
        }catch (InputMismatchException ex){
            System.out.println("Error en el dato introducido");
        }

    }

    public static void menuEjercicio(){
        System.out.println("Elige una opción: ");
        System.out.println("0. Salir");
        System.out.println("1. Añadir cliente");
        System.out.println("2. Mostrar clientes");
    }



}
