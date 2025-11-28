import java.util.Scanner;

public class Billetera {
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
                    Usuario usuarioLogueado = iniciarSesion(scanner, gestor);
                    if (usuarioLogueado != null) {
                        mostrarMenuUsuario(scanner, usuarioLogueado);
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

    private static void mostrarMenuUsuario(Scanner scanner, Usuario usuario) {
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
                    menuTarjetas(scanner, usuario);
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

    private static void menuTarjetas(Scanner scanner, Usuario usuario) {
        System.out.println("\n--- GESTIÓN DE TARJETAS ---");
        System.out.println("Funcionalidad en desarrollo...");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Aquí podrás agregar, eliminar y ver tus tarjetas.");
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }

    private static void menuServicios(Scanner scanner, Usuario usuario) {
        System.out.println("\n--- SERVICIOS ---");
        System.out.println("Funcionalidad en desarrollo...");
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Aquí podrás pagar servicios como luz, agua, teléfono, etc.");
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
    private static Luz crearLuz(Scanner sc){
        System.out.print("idServicio: "); String id = sc.nextLine();
        System.out.print("nombre: "); String nombre = sc.nextLine();
        System.out.print("empresa: "); String emp = sc.nextLine();
        System.out.print("codigoCliente: "); String cc = sc.nextLine();
        System.out.print("mes: "); String mes = sc.nextLine();
        return new Luz(id, nombre, emp, cc, mes);
    }

    private static Agua crearAgua(Scanner sc){
        System.out.print("idServicio: "); String id = sc.nextLine();
        System.out.print("nombre: "); String nombre = sc.nextLine();
        System.out.print("empresa: "); String emp = sc.nextLine();
        System.out.print("codigoSuministro: "); String cs = sc.nextLine();
        System.out.print("referencia: "); String ref = sc.nextLine();
        return new Agua(id, nombre, emp, cs, ref);
    }

    private static Telefonia crearTelefonia(Scanner sc){
        System.out.print("idServicio: "); String id = sc.nextLine();
        System.out.print("nombre: "); String nombre = sc.nextLine();
        System.out.print("empresa: "); String emp = sc.nextLine();
        System.out.print("nis: "); String nis = sc.nextLine();
        System.out.print("periodoFacturacion: "); String per = sc.nextLine();
        return new Telefonia(id, nombre, emp, nis,per);
    }


}