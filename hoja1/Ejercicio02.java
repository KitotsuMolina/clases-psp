/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio02.java
 * Ejecutar: java Ejercicio02
 * Argumentos: no necesita.
 */
import java.io.IOException;

public class Ejercicio02 {
    public static void main(String[] args) {
        try {
            ProcessBuilder constructor = new ProcessBuilder();
            constructor.command("notepad.exe");
            constructor.start();
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
