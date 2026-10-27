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
