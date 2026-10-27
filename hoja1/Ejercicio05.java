import java.io.IOException;

public class Ejercicio05 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            System.out.println("Bloc de notas iniciado. El padre continúa sin esperar.");
            for (int i = 0; i < 10; i++) {
                System.out.println((int) (Math.random() * 10));
            }
            // El padre puede terminar aunque el hijo siga abierto.
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
