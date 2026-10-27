/*
 * Ejecutar en Windows con un JDK instalado, desde la carpeta hoja1.
 * Compilar: javac -encoding UTF-8 Ejercicio04.java
 * Ejecutar: java Ejercicio04 notepad.exe "C:\Mis documentos\notas.txt"
 * Argumentos obligatorios: comando y ruta del fichero, en ese orden.
 * Si el comando o la ruta contienen espacios, ponerlos entre comillas.
 */
import java.io.IOException;

public class Ejercicio04 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.err.println("Uso: java Ejercicio04 <comando> <fichero>");
                System.err.println("Ejemplo: java Ejercicio04 notepad.exe \"notas.txt\"");
                return;
            }
            new ProcessBuilder(args[0], args[1]).start();
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
