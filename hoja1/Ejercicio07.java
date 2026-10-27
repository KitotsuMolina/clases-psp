import java.io.IOException;

public class Ejercicio07 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            int salida = hijo.waitFor();
            System.out.println("Valor de salida: " + salida);
            if (salida != 0) {
                System.err.println("El proceso terminó con un código de error.");
            }
            // Si no se puede iniciar, el catch de IOException muestra el error.
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
