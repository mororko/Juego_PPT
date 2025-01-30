import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String PIEDRA = "piedra";
    private static final String PAPEL = "papel";
    private static final String TIJERA = "tijera";
    private static final String[] OPCIONES = {PIEDRA, PAPEL, TIJERA};

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a Piedra, Papel o Tijera!");
        jugar();
        scanner.close(); // Cerrar el Scanner al terminar
    }

    private static void jugar() {
        boolean seguirJugando = true;

        while (seguirJugando) {
            // Ejecutar una ronda del juego
            String elementoJugador = elegirElementoJugador();
            String elementoComputadora = elegirElementoComputadora();

            System.out.println("La computadora eligió: " + elementoComputadora);
            quienGana(elementoJugador, elementoComputadora);

            // Preguntar al usuario si quiere seguir jugando
            seguirJugando = deseaContinuar();
        }

        System.out.println("¡Gracias por jugar! Hasta la próxima.");
    }

    private static boolean deseaContinuar() {
        while (true) {
            System.out.println("¿Quieres jugar otra ronda? (si/no):");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("si")) {
                return true;
            } else if (respuesta.equals("no")) {
                return false;
            } else {
                System.out.println("Por favor, responde con 'si' o 'no'.");
            }
        }
    }

    private static String elegirElementoJugador() {
        while (true) {
            System.out.println("Elige una opción: PIEDRA, PAPEL o TIJERA:");
            String eligeJugador = scanner.nextLine().toLowerCase();
            for (String opcion : OPCIONES) {
                if (eligeJugador.equals(opcion)) {
                    return eligeJugador;
                }
            }
            System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }

    private static String elegirElementoComputadora() {
        Random random = new Random();
        return OPCIONES[random.nextInt(OPCIONES.length)];
    }

    private static void quienGana(String eleccionJugador, String eleccionComputadora) {
        if (eleccionJugador.equals(eleccionComputadora)) {
            System.out.println("Es un empate.");
        } else {
            switch (eleccionJugador) {
                case PIEDRA:
                    System.out.println(eleccionComputadora.equals(TIJERA) ? "¡Ganaste!" : "Perdiste.");
                    break;
                case PAPEL:
                    System.out.println(eleccionComputadora.equals(PIEDRA) ? "¡Ganaste!" : "Perdiste.");
                    break;
                case TIJERA:
                    System.out.println(eleccionComputadora.equals(PAPEL) ? "¡Ganaste!" : "Perdiste.");
                    break;
            }
        }
    }
}
