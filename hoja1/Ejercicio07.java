/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio07.java
 * Ejecutar: java Ejercicio07
 * Argumentos: no necesita.
 * Cerrar Bloc de notas para que termine la espera del padre.
 */
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
