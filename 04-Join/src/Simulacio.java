import java.util.Random;

// Classe Treballador que implementa Runnable
class Treballador extends Thread {
    private final float nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random rnd;

    public Treballador(String nom, float nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    public void cobra() {
        this.cobrat += (nouAnualBrut / 12);
    }

    public void pagaImpostos() {
        this.cobrat -= (nouAnualBrut / 12) * 0.24;
    }

    @Override
    public void run() {
        while (edatActual < edatFiTreball) {
            if (edatActual >= edatIniciTreball) {
                cobra();
                pagaImpostos();
            }
            edatActual++;

            // Simulem un retard 
            try {
                Thread.sleep(rnd.nextInt(10));
            } catch (InterruptedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edatActual;
    }
}

// Classe Administració
class Administracio {
    private static final int NUM_POBLACIO_ACTIVA = 50;
    private final Treballador[] poblacioActiva;

    public Administracio() {
        this.poblacioActiva = new Treballador[NUM_POBLACIO_ACTIVA];
        for (int i = 0; i < NUM_POBLACIO_ACTIVA; i++) {
            this.poblacioActiva[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }

    public void executarSimulacio() {
        // Engegar els treballadors
        for (Treballador treballador : poblacioActiva) {
            treballador.start();
        }

        // Esperar que tots els treballadors acabin
        for (Treballador treballador : poblacioActiva) {
            try {
                treballador.join();
            } catch (InterruptedException e) {
                System.err.println("Error esperant el fil: " + e.getMessage());
            }
        }

        // Mostrar resultats
        for (Treballador treballador : poblacioActiva) {
            System.out.printf("%s -> edat: %d / total: %.2f\n",
                    treballador.getName(), treballador.getEdat(), treballador.getCobrat());
        }
    }
}

// Classe principal
public class Simulacio {
    public static void main(String[] args) {
        Administracio administracio = new Administracio();
        administracio.executarSimulacio();
    }
}
