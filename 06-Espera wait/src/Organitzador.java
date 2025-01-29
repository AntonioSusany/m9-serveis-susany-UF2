public class Organitzador {
    public static void main(String[] args) {
        
        Esdeveniment esdeveniment = new Esdeveniment(5);

        
        for (int i = 1; i <= 10; i++) {
            Assistent assistent = new Assistent("Assistent-" + i, esdeveniment);
            
        }
    }
}