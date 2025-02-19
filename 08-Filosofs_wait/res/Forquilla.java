public class Forquilla {
    private final int numero;

    public Forquilla(int numero) {
        this.numero = numero;
    }

    public void agafar() {
        System.out.println("Forquilla " + numero + " agafada.");
    }

    public void deixar() {
        System.out.println("Forquilla " + numero + " deixada.");
    }

    public int getNumero() {
        return numero;

        
    }
}
