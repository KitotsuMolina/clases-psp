import java.io.IOException;

public class Ejercicio06 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            System.out.println("Esperando a que termine el hijo...");
            hijo.waitFor();
            // Los números aparecen después de que termine el proceso hijo.
            for (int i = 0; i < 10; i++) {
                System.out.println((int) (Math.random() * 10));
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
