public class Ejercicio1 {
    /*Crea una clase modelizando un dado para jugar. Esta clase tiene:

dos atributos de instancia: uno que permite conocer el número de caras que tiene el dado y otro para almacenar la última cara que se extrajo;

dos constructores: uno que recibe como argumento el número de caras para el dado a crear y el otro, sin argumentos, que crea un clásico dado de seis caras;

métodos getter para los dos atributos;

un método setter, solo para cambiar el número de caras;

un método de instancia que permite simular la tirada de los dados, devolviendo el valor extraído aleatoriamente por los dados.

Escribir un algoritmo principal usando esta clase para crear tres dados: uno tiene seis caras, otro tiene diez caras y el último tiene doce caras. Los tres dados se lanzan hasta que la suma de los dados sea mayor o igual a veinte.*/
    private int numeroCaras;
    private int ultimaCara;

    public Ejercicio1(int numeroCaras) {
        this.numeroCaras = numeroCaras;
    }

    public Ejercicio1() {
        this.numeroCaras = 6;
    }

    public int getNumeroCaras() {
        return numeroCaras;
    }

    public int getUltimaCara() {
        return ultimaCara;
    }

    public void setNumeroCaras(int numeroCaras) {
        this.numeroCaras = numeroCaras;
    }

    public int tirarDado() {
        ultimaCara = (int) (Math.random() * numeroCaras + 1);
        return ultimaCara;
    }

}
