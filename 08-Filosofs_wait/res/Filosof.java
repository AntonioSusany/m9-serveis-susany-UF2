class Filòsof extends Thread {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;

    public Filòsof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public void pensar() throws InterruptedException {
        System.out.println("Filòsof " + id + " està pensant.");
        Thread.sleep((long) (1000 + Math.random() * 1000));
    }

    public void menjar() throws InterruptedException {
        System.out.println("Filòsof " + id + " està menjant.");
        Thread.sleep((long) (1000 + Math.random() * 1000));
    }

    public void agafarForquilles() throws InterruptedException {
        while (true) {
            if (esquerra.agafar(id)) {
                if (dreta.agafar(id)) {
                    return;
                } else {
                    esquerra.deixar();
                    Thread.sleep((long) (500 + Math.random() * 500));
                }
            } else {
                Thread.sleep((long) (500 + Math.random() * 500));
            }
        }
    }

    public void deixarForquilles() {
        esquerra.deixar();
        dreta.deixar();
    }

    public void run() {
        try {
            while (true) {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
