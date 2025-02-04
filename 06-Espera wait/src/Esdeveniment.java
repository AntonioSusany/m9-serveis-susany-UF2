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
        while (placesDisponibles == 0) {
            wait(); // Espera fins que hi hagi places disponibles
        }
        assistents.add(assistent);
        placesDisponibles--;
        System.out.println(assistent.getNom() + " ha fet una reserva. Places disponibles: " + placesDisponibles);
        notifyAll(); // Notifica als altres assistents que hi ha places disponibles
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (assistents.contains(assistent)) {
            assistents.remove(assistent);
            placesDisponibles++;
            System.out.println(assistent.getNom() + " ha cancel·lat una reserva. Places disponibles: " + placesDisponibles);
            notifyAll(); // Notifica als altres assistents que hi ha places disponibles
        } else {
            System.out.println(assistent.getNom() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + placesDisponibles);
        }
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }
}