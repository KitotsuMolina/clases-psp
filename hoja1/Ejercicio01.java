import java.io.IOException;

public class Ejercicio01 {
    public static void main(String[] args) {
        try {
            ProcessBuilder constructor = new ProcessBuilder("notepad.exe");
            constructor.start();
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el proceso: " + e.getMessage());
        }
    }
}
