import Controlador.GestorUsuarios;
import Modelo.Usuario;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        int opcion = 0;

        System.out.println("=== BILLETERA VIRTUAL ===");

        while(opcion != 3) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1:
                    crearCuenta(scanner, gestor);
                    break;
                case 2:
                    iniciarSesion(scanner, gestor);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar la billetera virtual!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearCuenta(Scanner scanner, GestorUsuarios gestor) {
        System.out.println("\n--- CREAR CUENTA ---");

        System.out.print("Ingrese su cédula (10 dígitos): ");
        String cedula = scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Clave (mínimo 5 caracteres): ");
        String clave = scanner.nextLine();


        boolean exito = gestor.crearUsuario(cedula, usuario, clave, nombre);

        if (exito) {
            System.out.println("\n¡Cuenta creada exitosamente!");
            System.out.println("Ahora puede iniciar sesión con su usuario y clave.");
        } else {
            System.out.println("\nNo se pudo crear la cuenta. Verifique los datos.");
        }
    }

    private static void iniciarSesion(Scanner scanner, GestorUsuarios gestor) {
        System.out.println("\n--- INICIAR SESIÓN ---");

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        Usuario usuarioLogueado = gestor.iniciarSesion(usuario, clave);

        if (usuarioLogueado != null) {
            System.out.println("\n¡Inicio de sesión exitoso!");
            System.out.println("Bienvenido, " + usuarioLogueado.getNombre() + "!");
            System.out.println("Su número de billetera es: " + usuarioLogueado.getNumeroBilletera());
            System.out.println("Cédula: " + usuarioLogueado.getCedula());
        } else {
            System.out.println("Usuario o clave incorrectos.");
        }
    }
}