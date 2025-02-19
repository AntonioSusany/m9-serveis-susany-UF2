class Taula {
    private final Filòsof[] filosofs;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        forquilles = new Forquilla[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        filosofs = new Filòsof[numFilosofs];
        for (int i = 0; i < numFilosofs; i++) {
            filosofs[i] = new Filòsof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        System.out.println("Taula amb " + filosofs.length + " filòsofs.");
        for (Filòsof filòsof : filosofs) {
            filòsof.pensar();  
        }
    }
}
