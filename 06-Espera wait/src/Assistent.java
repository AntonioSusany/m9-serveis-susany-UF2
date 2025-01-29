public class Assistent extends Thread {
    private String nom;
    private Esdeveniment esdeveniment;

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.nom = nom;
        this.esdeveniment = esdeveniment;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        try {
            while (true) {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}