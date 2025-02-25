public class Forquilla {
    public static final int LLIURE = -1;
    private int propietari;
    private final int numero;

    public Forquilla(int numero) {
        this.numero = numero;
        this.propietari = LLIURE;
    }

    public synchronized boolean agafar(int idFilòsof) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = idFilòsof;
        return true;
    }

    public synchronized void deixar() {
        propietari = LLIURE;
        notifyAll();
    }

    public int getNumero() {
        return numero;
    }

    public int getPropietari() {
        return propietari;
    }
}
