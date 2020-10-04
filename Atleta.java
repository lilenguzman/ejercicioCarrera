package Ejercicio8;

public class Atleta extends Persona implements Runnable {

    private Testigo testigo;
    private int turno;

    public Atleta(Testigo tes, int turno, String nombre) {
        super(nombre);
        this.testigo = tes;
        this.turno=turno;
    }

    public void run() {
        testigo.correr(turno,nombre);
    }
}
