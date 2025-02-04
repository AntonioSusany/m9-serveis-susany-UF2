# Preguntes teòriques

## 1. Per què s’atura l’execució al cap d’un temps?
L'execució s'atura perquè el programa es basa en fils que executen operacions de manera concurrent. Tot i que els fils estan en un bucle infinit, poden ser interromputs per diversos motius, com ara:
- El programa es deté manualment.
- El sistema operatiu acaba l'execució.
- S'interromp l'execució de manera forçada.
A més, si s'afegís una condició de parada dins del bucle while (true), els fils es podrien aturar de manera controlada.

---

## 2. Què passaria si en lloc de una probabilitat de 50%-50% fora de 70%(ferReserva)-30%(cancel·lar)? I si foren al revés les probabilitats?

Si canviem la probabilitat, hi hauria un desajust en la disponibilitat de places. Si 70% de les vegades es fa una reserva i només 30% es cancel·la, el sistema probablement es quedarà sense places ràpidament i els assistents hauran d'esperar més temps per reservar.

Si ho fem al revés (30% ferReserva - 70% cancel·lar), sovint hi haurà places disponibles, i els assistents no hauran d'esperar gaire per fer una reserva.

### Modificació del codi per 70% reserva - 30% cancel·lació:
```java
@Override
public void run() {
    try {
        while (true) {
            if (Math.random() < 0.7) { // 70% probabilitat de fer reserva
                esdeveniment.ferReserva(this);
            } else { // 30% probabilitat de cancel·lar
                esdeveniment.cancelaReserva(this);
            }
            Thread.sleep((long) (Math.random() * 1000));
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

```

## 3. Per què creus que fa falta la llista i no valdria només amb una variable sencera de reserves?

Si només utilitzéssim una variable sencera  per comptar el nombre de places ocupades, perdríem informació essencial sobre qui ha fet la reserva. En canvi, amb una llista (List<Assistent> assistents), podem:

- Controlar exactament quins assistents han reservat.
- Evitar que un assistent cancel·li una reserva que no ha fet.
- Facilitar possibles millores, com mostrar la llista d’assistents o gestionar una cua d’espera.

Si només tinguéssim una variable sencera (int placesOcupades), el sistema només sabria quantes places hi ha lliures, però no podria validar quins assistents han reservat realment, fent més difícil la gestió del sistema de reserves.







