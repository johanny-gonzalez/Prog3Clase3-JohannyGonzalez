import java.util.Scanner;

class EstudianteInvalidoException extends Exception {
    public EstudianteInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Main {

    public static void validarEstudiante(
            String nombre,
            int edad,
            double indice)
            throws EstudianteInvalidoException {

        if (nombre.trim().isEmpty()) {
            throw new EstudianteInvalidoException(
                    "Error: El nombre no puede estar vacío.");
        }

        if (edad < 18) {
            throw new EstudianteInvalidoException(
                    "Error: La edad debe ser mayor o igual a 18 años.");
        }

        if (edad > 100) {
            throw new EstudianteInvalidoException(
                    "Error: La edad debe ser menor o igual a 100 años.");
        }

        if (indice < 0 || indice > 4) {
            throw new EstudianteInvalidoException(
                    "Error: El índice debe estar entre 0 y 4.");
        }
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Edad: ");
        int edad = leer.nextInt();

        System.out.print("Índice: ");
        double indice = leer.nextDouble();

        try {

            validarEstudiante(nombre, edad, indice);

            System.out.println(
                    "Estudiante registrado correctamente.");

        } catch (EstudianteInvalidoException e) {

            System.out.println(
                    e.getMessage());

        } finally {

            System.out.println(
                    "Proceso finalizado.");

        }

        leer.close();
    }
}