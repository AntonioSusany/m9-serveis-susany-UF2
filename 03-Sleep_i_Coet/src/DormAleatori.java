import java.util.Random;

public class DormAleatori extends Thread {
    private long instantCreacio;
    private String nom;

    public DormAleatori(String nom) {
        super(nom); // Assignem el nom al thread
        this.nom = nom;
        this.instantCreacio = System.currentTimeMillis(); // Temps de creació
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000); // Interval aleatori entre 0 i 999 ms
            long tempsTotal = System.currentTimeMillis() - instantCreacio;
            System.out.printf("%s(%d) a dormir %dms total %d\n", nom, i, interval, tempsTotal);

            try {
                Thread.sleep(interval); // Dormim l'interval especificat
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}
