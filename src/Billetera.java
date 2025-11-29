import java.util.ArrayList;
import java.util.Scanner;

public class Billetera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorUsuarios gestor = new GestorUsuarios();
        GestorTarjetas gestorTarjetas = new GestorTarjetas();
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
                    Usuario usuarioLogueado = iniciarSesion(scanner, gestor);
                    if (usuarioLogueado != null) {
                        mostrarMenuUsuario(scanner, usuarioLogueado, gestorTarjetas);
                    }
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

    private static Usuario iniciarSesion(Scanner scanner, GestorUsuarios gestor) {
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
            return usuarioLogueado;
        } else {
            System.out.println("Usuario o clave incorrectos.");
            return null;
        }
    }

    //otro menu

    private static void mostrarMenuUsuario(Scanner scanner, Usuario usuario, GestorTarjetas gestorTarjetas) {
        int opcion = 0;

        while(opcion != 5) {
            System.out.println("\n=== MENÚ DE USUARIO ===");
            System.out.println("Bienvenido: " + usuario.getNombre());
            System.out.println("N° Billetera: " + usuario.getNumeroBilletera());
            System.out.println("1. Tarjetas");
            System.out.println("2. Servicios");
            System.out.println("3. Contactos");
            System.out.println("4. Transacciones");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1:
                    menuTarjetas(scanner, usuario, gestorTarjetas);
                    break;
                case 2:
                    menuServicios(scanner, usuario);
                    break;
                case 3:
                    menuContactos(scanner, usuario);
                    break;
                case 4:
                    menuTransacciones(scanner, usuario);
                    break;
                case 5:
                    System.out.println("Cerrando sesión... ¡Hasta pronto, " + usuario.getNombre() + "!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void menuTarjetas(Scanner scanner, Usuario usuario, GestorTarjetas gestorTarjetas) {
        int opcion = 0;

        while(opcion != 3) {
            System.out.println("\n--- GESTIÓN DE TARJETAS ---");
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("1. Ver mis tarjetas");
            System.out.println("2. Registrar nueva tarjeta");
            System.out.println("3. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch(opcion) {
                case 1:
                    //System.out.println("Funcionalidad en desarrollo...");
                    menuVerTarjetas(scanner, usuario, gestorTarjetas);
                    break;
                case 2:
                    menuRegistrarTarjeta(scanner, usuario, gestorTarjetas);
                    break;
                case 3:
                    System.out.println("Volviendo al menú anterior...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void menuVerTarjetas(Scanner scanner, Usuario usuario, GestorTarjetas gestorTarjetas) {
        int opcion = 0;

        while(opcion != 3) {
            System.out.println("\n--- MIS TARJETAS ---");
            gestorTarjetas.mostrarTarjetas(usuario);
            System.out.println("\n1. Ver detalles completos");
            System.out.println("2. Eliminar tarjeta");
            System.out.println("3. Volver al menú de tarjetas");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
                case 1:
                    verDetallesCompletosTarjetas(usuario, gestorTarjetas);
                    break;
                case 2:
                    eliminarTarjetaMenu(scanner, usuario, gestorTarjetas);
                    break;
                case 3:
                    System.out.println("Volviendo al menú de tarjetas...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void menuRegistrarTarjeta(Scanner scanner, Usuario usuario, GestorTarjetas gestorTarjetas) {
        System.out.println("\n--- REGISTRAR NUEVA TARJETA ---");

        System.out.print("Red de pago (Visa/Mastercard/Amex): ");
        String redPago = scanner.nextLine();

        System.out.print("Tipo (credito/debito): ");
        String tipo = scanner.nextLine();

        System.out.print("Número de tarjeta (16 dígitos): ");
        String numTarjeta = scanner.nextLine();
        scanner.nextLine();

        // Validar que el número tenga 16 dígitos
        if (String.valueOf(numTarjeta).length() != 16) {
            System.out.println("Error: El número de tarjeta debe tener 16 dígitos.");
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        System.out.print("Nombre del propietario: ");
        String nombrePropietario = scanner.nextLine();

        System.out.print("Fecha de caducidad (MM/YY): ");
        String fechaCaducidad = scanner.nextLine();

        System.out.print("CVS (3 dígitos): ");
        int cvs = scanner.nextInt();
        scanner.nextLine();

        // Validar que el CVS tenga 3 dígitos
        if (String.valueOf(cvs).length() != 3) {
            System.out.println("Error: El CVS debe tener 3 dígitos.");
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        Tarjeta nuevaTarjeta = new Tarjeta(redPago, tipo, numTarjeta, nombrePropietario, fechaCaducidad, cvs);
        boolean exito = gestorTarjetas.agregarTarjeta(usuario, nuevaTarjeta);

        if (exito) {
            System.out.println("¡Tarjeta registrada exitosamente!");
        } else {
            System.out.println("No se pudo registrar la tarjeta.");
        }

        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void verDetallesCompletosTarjetas(Usuario usuario, GestorTarjetas gestorTarjetas) {
        System.out.println("\n--- DETALLES COMPLETOS DE TARJETAS ---");
        java.util.ArrayList<Tarjeta> tarjetas = gestorTarjetas.obtenerTarjetas(usuario);

        if (tarjetas.isEmpty()) {
            System.out.println("No tienes tarjetas registradas.");
        } else {
            for (int i = 0; i < tarjetas.size(); i++) {
                Tarjeta tarjeta = tarjetas.get(i);
                System.out.println("\n=== Tarjeta " + (i + 1) + " ===");
                System.out.println("Red de pago: " + tarjeta.getRedPago());
                System.out.println("Tipo: " + tarjeta.getTipo());
                System.out.println("Número completo: " + tarjeta.getNumTarjeta());
                System.out.println("Propietario: " + tarjeta.getNombrePropietario());
                System.out.println("Fecha de caducidad: " + tarjeta.getFechaCaducidad());
                System.out.println("CVS: " + tarjeta.getCvs());
                System.out.println("Saldo: $" + tarjeta.getSaldo());
            }
        }

        System.out.print("\nPresione Enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    private static void eliminarTarjetaMenu(Scanner scanner, Usuario usuario, GestorTarjetas gestorTarjetas) {
        System.out.println("\n--- ELIMINAR TARJETA ---");
        java.util.ArrayList<Tarjeta> tarjetas = gestorTarjetas.obtenerTarjetas(usuario);

        if (tarjetas.isEmpty()) {
            System.out.println("No tienes tarjetas para eliminar.");
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();
            return;
        }

        // Mostrar tarjetas numeradas
        System.out.println("Tus tarjetas:");
        for (int i = 0; i < tarjetas.size(); i++) {
            Tarjeta tarjeta = tarjetas.get(i);
            String ultimosDigitos = tarjeta.getNumTarjeta().substring(12);
            System.out.println((i + 1) + ". " + tarjeta.getTipo() + " " +
                    tarjeta.getRedPago() + " - ****" + ultimosDigitos);
        }

        System.out.print("Seleccione el número de la tarjeta a eliminar (0 para cancelar): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        if (seleccion < 1 || seleccion > tarjetas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Tarjeta tarjetaAEliminar = tarjetas.get(seleccion - 1);
        System.out.print("¿Está seguro de eliminar la tarjeta ****" +
                tarjetaAEliminar.getNumTarjeta().substring(12) +
                "? (s/n): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            gestorTarjetas.eliminarTarjeta(usuario, tarjetaAEliminar.getNumTarjeta());
        } else {
            System.out.println("Operación cancelada.");
        }

        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }


    private static void menuServicios(Scanner scanner, Usuario usuario) {
        System.out.println("\n--- SERVICIOS ---");
        System.out.println("Funcionalidad en desarrollo...");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Aquí podrás pagar servicios como luz, agua, teléfono, etc.");
        MainCrearServicio.menuCrearServicio();
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void menuContactos(Scanner scanner, Usuario usuario) {
        System.out.println("\n--- GESTIÓN DE CONTACTOS ---");
        System.out.println("Funcionalidad en desarrollo...");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Aquí podrás agregar y gestionar tus contactos frecuentes.");
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void menuTransacciones(Scanner scanner, Usuario usuario) {
        System.out.println("\n--- TRANSACCIONES ---");
        System.out.println("Funcionalidad en desarrollo...");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Aquí podrás ver tu historial de transacciones y realizar transferencias.");
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
}