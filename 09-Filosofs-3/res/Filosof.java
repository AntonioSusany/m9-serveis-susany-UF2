public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra, dreta;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public void run() {
        try {
            while (true) {
                pensar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Fil" + id + " està pensant");
        Thread.sleep(1000);
    }
}
