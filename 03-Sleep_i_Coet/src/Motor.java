import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private int id;

    public Motor(int id) {
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
        notify(); // Notifiquem al thread que hi ha un canvi
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (this) {
                while (potenciaActual == potenciaObjectiu) {
                    try {
                        wait(); // Esperem fins que hi hagi un canvi de potència
                    } catch (InterruptedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }

            if (potenciaObjectiu == 0 && potenciaActual == 0) {
                System.out.printf("Motor %d: Aturat.\n", id);
                break;
            }

            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d\n", id, potenciaObjectiu, potenciaActual);
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d\n", id, potenciaObjectiu, potenciaActual);
            }

            try {
                Thread.sleep(random.nextInt(1000) + 1000); // Interval entre 1 i 2 segons
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
