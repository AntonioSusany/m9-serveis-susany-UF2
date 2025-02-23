
class Associacio {
    private static final int NUM_SOCIS = 1000;
    private Soci[] socis;
    
    public Associacio() {
        socis = new Soci[NUM_SOCIS];
        for (int i = 0; i < NUM_SOCIS; i++) {
            socis[i] = new Soci();
        }
    }
    
    public void iniciaCompteTempsSocis() {
        for (Soci soci : socis) {
            soci.start();
        }
        for (Soci soci : socis) {
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void mostraBalancComptes() {
        System.out.printf("Saldo: %.2f%n", Compte.getInstance().getSaldo());
    }
    
    public static void main(String[] args) {
        Associacio associacio = new Associacio();
        associacio.iniciaCompteTempsSocis();
        associacio.mostraBalancComptes();
    }
}
