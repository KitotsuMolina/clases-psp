/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio08.java
 * Ejecutar: java Ejercicio08
 * Argumentos: no necesita.
 * Cerrar Bloc de notas para que termine la espera del padre.
 */
import java.io.IOException;

public class Ejercicio08 {
    public static void main(String[] args) {
        try {
            Process hijo = new ProcessBuilder("notepad.exe").start();
            try {
                System.out.println("Valor de salida: " + hijo.exitValue());
            } catch (IllegalThreadStateException e) {
                // exitValue() no espera: lanza esta excepción si el hijo sigue vivo.
                System.out.println("El proceso sigue ejecutándose; aún no tiene valor de salida.");
                int salida = hijo.waitFor();
                System.out.println("Valor de salida tras esperar: " + salida);
            }
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El padre fue interrumpido durante la espera.");
        }
    }
}
