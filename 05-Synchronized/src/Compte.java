class Compte {
    private static Compte instance;
    private float saldo;
    
    private Compte() {
        saldo = 0;
    }
    
    public static synchronized Compte getInstance() {
        if (instance == null) {
            instance = new Compte();
        }
        return instance;
    }
    
    public synchronized void ingressar(float quantitat) {
        saldo += quantitat;
    }
    
    public synchronized void retirar(float quantitat) {
        saldo -= quantitat;
    }
    
    public synchronized float getSaldo() {
        return saldo;
    }
}