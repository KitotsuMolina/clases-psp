/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio11.java
 * Ejecutar: java Ejercicio11
 * Argumentos: no necesita.
 */
import java.io.IOException;

public class Ejercicio11 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            Thread.sleep(300);
            hijo.destroy();
            hijo.waitFor();
            System.out.println("El proceso hijo ha terminado.");
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
