public class Compte {
    private static Compte instance;
    private float saldo;

    private Compte() {
        saldo = 0;
    }

    public static Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }

    public void ingressar(float quantitat) {
        saldo += quantitat;
    }

    public void retirar(float quantitat) {
        saldo -= quantitat;
    }

    public float getSaldo() {
        return saldo;
    }
}
