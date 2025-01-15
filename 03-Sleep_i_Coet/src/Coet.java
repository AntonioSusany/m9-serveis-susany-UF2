import java.util.Scanner;

public class Coet {
    private Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error: Potència fora de rang (0-10)");
            return;
        }
        System.out.printf("Passant a potència %d\n", p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Introdueix potència objectiu (0-10): ");
            int potencia = scanner.nextInt();
            if (potencia == 0) {
                coet.passaAPotencia(potencia);
                break;
            }
            coet.passaAPotencia(potencia);
        }

        scanner.close();
    }
}
