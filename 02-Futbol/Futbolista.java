// Futbolista.java - Versió 1 (incompleta)
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
        // Aquí iría la lògica per simular els xuts
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) throws InterruptedException {
        
        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        
        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista("Jugador " + (i + 1));
        }
        
        for (Futbolista futbolista : jugadors) {
            futbolista.start();
        }
        
        for (Futbolista futbolista : jugadors) {
            futbolista.join();
        }
        
        System.out.println("--- Estadístiques ----");
        for (Futbolista futbolista : jugadors) {
            System.out.println(futbolista.getName() + " -> " + futbolista.getNgols() + " gols");
        }
    }
}
