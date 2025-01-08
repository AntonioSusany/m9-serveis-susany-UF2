// Futbolista.java - Versió 2 (completa)
import java.util.Random;

public class Futbolista extends Thread {
    private int ngols;
    private int ntirades;

    // Constants
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (rand.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Inici dels xuts --------------------");

        // Crear els fils
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        
        // Crear jugadors
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista("Jugador " + (i + 1));
        }
        
        // Iniciar els fils
        for (Futbolista futbolista : jugadors) {
            futbolista.start();
        }
        
        // Esperar que tots els fils acabin
        for (Futbolista futbolista : jugadors) {
            futbolista.join();
        }

        // Mostrar les estadístiques
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ----");
        for (Futbolista futbolista : jugadors) {
            System.out.println(futbolista.getName() + " -> " + futbolista.getNgols() + " gols");
        }
    }
}
