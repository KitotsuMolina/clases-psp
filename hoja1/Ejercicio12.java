import java.io.IOException;

public class Ejercicio12 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            hijo.destroy();
            Thread.sleep(10000);
            try {
                System.out.println("Valor de salida: " + hijo.exitValue());
            } catch (IllegalThreadStateException e) {
                // Dormir 10 segundos no garantiza la terminación del proceso.
                System.out.println("El proceso aún no ha terminado. Esperando...");
                System.out.println("Valor de salida: " + hijo.waitFor());
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
