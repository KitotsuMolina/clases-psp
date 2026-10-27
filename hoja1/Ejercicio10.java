import java.io.IOException;

public class Ejercicio10 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            hijo.destroy();
            // destroy() solicita la terminación, pero puede no ser inmediata.
            // Esperamos para evitar IllegalThreadStateException al llamar a exitValue().
            hijo.waitFor();
            System.out.println("Valor de salida tras destruirlo: " + hijo.exitValue());
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
