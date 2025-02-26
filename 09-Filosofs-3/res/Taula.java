public class Taula {
    private final Filosof[] filosofts;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        filosofts = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            filosofts[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < filosofts.length; i++) {
            System.out.println("Comensal:Fil" + i + " esq:" + forquilles[i].getNum() +
                    " dret:" + forquilles[(i + 1) % forquilles.length].getNum());
        }
        System.out.println("-----------------------------");
    }
}
