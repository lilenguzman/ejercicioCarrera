package Ejercicio8;

import java.util.concurrent.Semaphore;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testigo {

    // Texto de color.
    public static final String AZUL = "\u001B[34m";
    public static final String FINALIZAR_COLOR = "\u001B[0m";

    private Semaphore semTestigo1;
    private Semaphore semTestigo2;
    private Semaphore semTestigo3;
    private Semaphore semTestigo4;
    private int tiempoTotal;

    public Testigo() {
        semTestigo1 = new Semaphore(1);
        semTestigo2 = new Semaphore(0);
        semTestigo3 = new Semaphore(0);
        semTestigo4 = new Semaphore(0);
        tiempoTotal = 0;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void correr(int turno, String nombreAtleta) {

        switch (turno) {
            case 1:
                try {
                    this.semTestigo1.acquire();//adquiero el semaforo
            } catch (InterruptedException ex) {
                Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            procesoCorrer(nombreAtleta);
            this.semTestigo2.release();
            break;

            case 2:
                try {
                    this.semTestigo2.acquire();//adquiero el semaforo
            } catch (InterruptedException ex) {
                Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            procesoCorrer(nombreAtleta);
            this.semTestigo3.release();
            break;

            case 3:
                try {
                    this.semTestigo3.acquire();//adquiero el semaforo
            } catch (InterruptedException ex) {
                Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            procesoCorrer(nombreAtleta);
            this.semTestigo4.release();
            break;
            case 4:
                try {
                    this.semTestigo4.acquire();//adquiero el semaforo
            } catch (InterruptedException ex) {
                Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
            }
            procesoCorrer(nombreAtleta);

            break;
        }
    }

    private void procesoCorrer(String nombreAtleta) {
        // Metodo que simula el tiempo que demora el atleta en llegar a su destino.

        System.out.println("Comienza a correr: " + AZUL + nombreAtleta + FINALIZAR_COLOR + ".");

        long ini = System.currentTimeMillis(), fin, total;
        Random tiempo = new Random();
        int tiempoCorriendo = tiempo.nextInt(3) + 9;

        try {
            Thread.sleep(tiempoCorriendo * 1000); // simulo tiempo de carrera.

            System.out.println(nombreAtleta + " pasa el testigo.");

            fin = System.currentTimeMillis();
            total = (fin - ini) / 1000;
            System.out.println("Tiempo Corriendo: " + total + " segundos.");
            System.out.println("");

            this.tiempoTotal += total;

        } catch (InterruptedException ex) {
            Logger.getLogger(Testigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
