import java.util.List;
import java.util.ArrayList;

public class Esdeveniment {
    private int placesDisponibles;
    private List<Assistent> assistents;
    private final int MAX_PLACES;

    public Esdeveniment(int maxPlaces) {
        this.MAX_PLACES = maxPlaces;
        this.placesDisponibles = maxPlaces;
        this.assistents = new ArrayList<>();
    }

    public synchronized void ferReserva(Assistent assistent) throws InterruptedException {

    }

    public synchronized void cancelaReserva(Assistent assistent) {

    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }
}