public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5); // Esdeveniment amb 5 places màximes

        // Creem 10 assistents
        for (int i = 1; i <= 10; i++) {
            Assistent assistent = new Assistent("Assistent-" + i, esdeveniment);
            assistent.start(); // Iniciem cada assistent
        }
    }
}