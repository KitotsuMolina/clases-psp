/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio06.java
 * Ejecutar: java Ejercicio06
 * Argumentos: no necesita.
 * Cerrar Bloc de notas para que termine la espera del padre.
 */
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
