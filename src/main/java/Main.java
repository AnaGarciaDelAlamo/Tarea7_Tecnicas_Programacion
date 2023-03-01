import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int option =0;
        try (Scanner sc = new Scanner(System.in)){
            do{
                menuPrincipal();
                try{
                    option = sc.nextInt();
                }catch(InputMismatchException ex){
                    sc.next();
                    option = -1;
                }
                switch (option){
                    case 0:
                        System.out.println("Adiós");
                        return;
                    case 1:
                        Ejercicio1 ejercicio1 = new Ejercicio1();
                        System.out.println(ejercicio1.tirarDado());
                        break;
                        case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;

                }
            }while(option >= 0 || option < 5);

        }catch (InputMismatchException ex){
            System.out.println("Error en el dato introducido");
        }

    }

    public static void menuPrincipal(){
        System.out.println("Elige una opción: ");
        System.out.println("0. Salir");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
    }
}
