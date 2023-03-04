import java.util.Scanner;

/*En esta nueva versión de la micro guerra de barcos (un único barco de una sola celda), se usa el paradigma de programación orientada a objetos.

Cree una clase Cuadricula que tenga:

un atributo de instancia de tipo tabla de 10 × 10 casillas;

las constantes que estime necesarias;

un constructor sin argumentos, que permite inicializar el tablero del juego con agua por todas partes;

un método de instancia depositarBarco(), que toma como argumentos las coordenadas de la caja donde colocar el barco;

un método de instancia disparar(), que recibe como argumentos las coordenadas de disparo y devuelve verdadero si se ha hundido el barco;

un método de instancia visualizacion(), que muestra el tablero de juego de la guerra de barcos.

Escribe un algoritmo usando la clase Cuadricula, que permite a un jugador jugar a la micro guerra de barcos.*/

public class Ejercicio3 {
private final int TAMAÑO = 10;
private final char AGUA = '.';
private final char BARCO = 'B';
private final char TOCADO = 'X';
private final char HUNDIDO = 'H';
private char[][] tabla;

public Ejercicio3(){
    tabla = new char[TAMAÑO][TAMAÑO];
    for(int fila = 0; fila < TAMAÑO; fila++){
        for(int columna = 0; columna < TAMAÑO; columna++){
            tabla[fila][columna] = AGUA;
        }
    }
}

public void depositarBarco(int fila, int columna){
    tabla[fila][columna] = BARCO;
}

public boolean disparar(int fila, int columna){
    if(tabla[fila][columna] == BARCO){
        tabla[fila][columna] = TOCADO;
        if(barcoHundido()){
            return true;
        }
    }else{
        tabla[fila][columna] = AGUA;
    }
    return false;
}

public boolean barcoHundido(){
    for(int fila = 0; fila <TAMAÑO; fila++){
        for(int columna = 0; columna < TAMAÑO; columna++){
            if(tabla[fila][columna] == BARCO){
                return false;
            }
        }
    }
    return true;
}

public void visualizacion(){
    System.out.println("  ");
    for(int columna = 0; columna < TAMAÑO; columna++){
        System.out.print(columna + " ");
    }
    System.out.println();
    for(int fila = 0; fila < TAMAÑO; fila++){
        System.out.println(fila + " ");
        for(int columna = 0; columna < TAMAÑO; columna++){
            char celda = tabla[fila][columna];
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
    Ejercicio3 juego = new Ejercicio3();
        System.out.println("Bienvenido a la micro guerra de barcos");
        System.out.println("Introduce la fila donde quieres colocar el barco");
        System.out.println("Fila (0-9): ");
        int fila = sc.nextInt();
        System.out.println("Columna (0-9): ");
        int columna = sc.nextInt();
        juego.depositarBarco(fila, columna);
        while(true){
            juego.visualizacion();
            System.out.println("Introduzca las coordenadas donde desea disparar");
            System.out.println("Fila (0-9): ");
            fila = sc.nextInt();
            System.out.println("Columna (0-9): ");
            columna = sc.nextInt();
            boolean hundido = juego.disparar(fila, columna);
            if(hundido){
                System.out.println("Has hundido el barco");
                juego.visualizacion();
                break;
            }
        }
        sc.close();

    }
}
