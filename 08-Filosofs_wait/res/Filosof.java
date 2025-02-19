class Filòsof {
    private final int id;
    private final Forquilla esquerra;
    private final Forquilla dreta;

    public Filòsof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    public void pensar() {
        System.out.println("Filòsof " + id + " està pensant.");
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
