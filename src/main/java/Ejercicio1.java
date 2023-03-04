import java.util.Random;

/*Crea una clase modelizando un dado para jugar. Esta clase tiene:

dos atributos de instancia: uno que permite conocer el número de caras que tiene el dado y otro para almacenar la última cara que se extrajo;

dos constructores: uno que recibe como argumento el número de caras para el dado a crear y el otro, sin argumentos, que crea un clásico dado de seis caras;

métodos getter para los dos atributos;

un método setter, solo para cambiar el número de caras;

un método de instancia que permite simular la tirada de los dados, devolviendo el valor extraído aleatoriamente por los dados.

Escribir un algoritmo principal usando esta clase para crear tres dados: uno tiene seis caras, otro tiene diez caras y el último tiene doce caras. Los tres dados se lanzan hasta que la suma de los dados sea mayor o igual a veinte.*/
public class Ejercicio1 {
    private int caras;
    private int caraExtraida;

    public Ejercicio1(){
        this.caras = 6;
        this.caraExtraida = 0;
    }

    public Ejercicio1(int caras){
        this.caras = caras;
        this.caraExtraida = 0;
    }

    public int roll(){
        Random rand = new Random();
        this.caraExtraida = rand.nextInt(this.caras) + 1;
        return this.caraExtraida;
    }

    public void setCaras(int caras){
        this.caras = caras;
    }

    public int getCaras(){
        return this.caras;
    }

    public int getCaraExtraida(){
        return this.caraExtraida;
    }

    public static void main(String[] args) {
        Ejercicio1 dado1 = new Ejercicio1();
        Ejercicio1 dado2 = new Ejercicio1(10);
        Ejercicio1 dado3 = new Ejercicio1(12);
        int suma = 0;
        while(suma < 20){
            suma = dado1.roll() + dado2.roll() + dado3.roll();
            System.out.println("Suma: " + suma);
        }
    }


}
