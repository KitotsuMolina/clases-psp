import java.io.IOException;

public class Ejercicio09 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("calc.exe").start();
            System.out.println("Cierra la calculadora antes de que pasen 10 segundos.");
            Thread.sleep(10000);
            try {
                System.out.println("Valor de salida: " + hijo.exitValue());
                // Si ya terminó, exitValue() devuelve su código sin lanzar excepción.
            } catch (IllegalThreadStateException e) {
                System.out.println("El proceso aún sigue vivo; todavía no tiene valor de salida.");
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
