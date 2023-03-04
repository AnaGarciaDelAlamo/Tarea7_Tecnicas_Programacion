import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {
    private final int TAMAÑO = 10;
    private final char AGUA = '.';
    private final char BARCO = 'B';
    private final char TOCADO = 'X';
    private final char HUNDIDO = 'H';
    private char[][] tablaUsuario;
    private char[][] tablaOrdenador;
    private Random random;

    public Ejercicio4(){
        tablaUsuario = new char[TAMAÑO][TAMAÑO];
        tablaOrdenador = new char[TAMAÑO][TAMAÑO];
        random = new Random();

        for (int fila = 0; fila < TAMAÑO; fila++){
            for(int columna = 0; columna < TAMAÑO; columna++){
                tablaUsuario[fila][columna] = AGUA;
                tablaOrdenador[fila][columna] = AGUA;
            }
        }
    }

    public void depositarBarcoUsuario(int fila, int columna){
        tablaUsuario[fila][columna] = BARCO;
    }

    public void depositarBarcoMAquina(){
        int fila = random.nextInt(TAMAÑO);
        int columna = random.nextInt(TAMAÑO);

        while(tablaOrdenador[fila][columna] != AGUA){
            fila = random.nextInt(TAMAÑO);
            columna = random.nextInt(TAMAÑO);
        }
        tablaOrdenador[fila][columna] = BARCO;
    }

    public boolean dispararUsuario(int fila, int columna){
        if(tablaOrdenador[fila][columna] == BARCO){
            tablaOrdenador[fila][columna] = TOCADO;
            if (barcoHundido(tablaOrdenador)){
                return true;
            }
        }else{
            tablaOrdenador[fila][columna] = AGUA;
        }
        return false;
    }

    public boolean dispararMaquina(){
        int fila = random.nextInt(TAMAÑO);
        int columna = random.nextInt(TAMAÑO);

        while(tablaUsuario[fila][columna] == TOCADO || tablaUsuario[fila][columna] == HUNDIDO){
            fila = random.nextInt(TAMAÑO);
            columna = random.nextInt(TAMAÑO);
        }
        if (tablaUsuario[fila][columna] == BARCO){
            tablaUsuario[fila][columna] = TOCADO;
            if (barcoHundido(tablaUsuario)){
                return true;
            }

        }else{
            tablaUsuario[fila][columna] = AGUA;
        }
        return false;
    }

    public boolean barcoHundido(char[][] tabla){
        for (int fila = 0; fila < TAMAÑO; fila++){
            for(int columna = 0; columna < TAMAÑO; columna++){
                if(tabla[fila][columna] == BARCO){
                    return false;
                }
            }
        }
        return true;
    }

    public void visualizacionUsuario(){
        System.out.println("  ");
        for (int columna = 0; columna < TAMAÑO; columna++){
            System.out.print(columna + " ");
        }
        System.out.println();
        for(int fila = 0; fila < TAMAÑO; fila++){
            System.out.println(fila + " ");
            for(int columna = 0; columna < TAMAÑO; columna++){
                char celda = tablaUsuario[fila][columna];
                if(celda == BARCO){
                    System.out.print(AGUA + " ");
                }else{
                    System.out.print(celda + " ");
                }
            }
            System.out.println();
        }

    }

    public void visualizacionOrdenador(){
        System.out.println("  ");
        for (int columna = 0; columna < TAMAÑO; columna++){
            System.out.print(columna + " ");
        }
        System.out.println();
        for(int fila = 0; fila < TAMAÑO; fila++){
            System.out.println(fila + " ");
            for(int columna = 0; columna < TAMAÑO; columna++){
                char celda = tablaOrdenador[fila][columna];
                if(celda == BARCO){
                    System.out.print(AGUA + " ");
                }else{
                    System.out.print(celda + " ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicio4 juego = new Ejercicio4();
        System.out.println("Bienvenido a la última versión de microguerra de barcos");
        System.out.println("Introduce la fila donde quieres colocar el barco:");
        System.out.println("(0-9)");
        int fila = sc.nextInt();
        System.out.println("Introduce la columna donde quieres colocar el barco:");
        System.out.println("(0-9)");
        int columna = sc.nextInt();
        juego.depositarBarcoUsuario(fila, columna);
        juego.depositarBarcoMAquina();
        while (true){
            juego.visualizacionUsuario();
            juego.visualizacionOrdenador();
            System.out.println("Introduce la fila donde quieres disparar:");
            System.out.println("(0-9)");
            fila = sc.nextInt();
            System.out.println("Introduce la columna donde quieres disparar:");
            System.out.println("(0-9)");
            columna = sc.nextInt();
            boolean hundido = juego.dispararUsuario(fila, columna);
            if (hundido){
                System.out.println("Has hundido el barco");
                break;
            }
            System.out.println("Ahora le toca al ordenador");
            hundido = juego.dispararMaquina();
            if (hundido){
                System.out.println("El ordenador ha hundido tu barco");
                break;
            }
        }
        sc.close();
    }
}
