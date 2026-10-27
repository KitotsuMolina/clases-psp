import java.io.IOException;

public class Ejercicio03 {
    public static void main(String[] args) {
        try {
            // Se puede pasar la ruta del fichero como primer argumento.
            String fichero = args.length > 0 ? args[0] : "ejemplo.txt";
            new ProcessBuilder("notepad.exe", fichero).start();
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
