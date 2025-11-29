import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainCrearServicio {
    public static void menuCrearServicio(){
        Scanner sc = new Scanner(System.in);
        ArrayList<PagarServicio> servicios = new ArrayList<>();
        HashMap<String, String> propietarioServicio = new HashMap<>();

        System.out.print("Ingrese usuario actual: ");
        String usuarioActual = sc.nextLine();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("MENÚ");
            System.out.println("1. Crear Luz");
            System.out.println("2. Crear Agua");
            System.out.println("3. Crear Telefonia");
            System.out.println("4. Mostrar servicios");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch(opcion) {
                    case 1 -> {
                        PagarServicio s = crearLuz(sc);
                        validarID(servicios, s.getIdServicio());
                        servicios.add(s);
                        propietarioServicio.put(s.getIdServicio(), usuarioActual);
                    }
                    case 2 -> {
                        PagarServicio s = crearAgua(sc);
                        validarID(servicios, s.getIdServicio());
                        servicios.add(s);
                        propietarioServicio.put(s.getIdServicio(), usuarioActual);
                    }
                    case 3 -> {
                        PagarServicio s = crearTelefonia(sc);
                        validarID(servicios, s.getIdServicio());
                        servicios.add(s);
                        propietarioServicio.put(s.getIdServicio(), usuarioActual);
                    }
                    case 4 -> {
                        System.out.println(" LISTA DE SERVICIOS DEL USUARIO: " + usuarioActual);
                        for (PagarServicio ps : servicios) {
                            if (propietarioServicio.get(ps.getIdServicio()).equals(usuarioActual)) {
                                System.out.println(ps);
                                System.out.println(ps.generarDetallePago());
                            }
                        }
                    }
                    case 5 -> System.out.println("Saliendo");
                    default -> System.out.println("Opción no válida");
                }

            } catch (IdDuplicadoException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Por favor ingrese una ID no repetida.");
            }
        }
    }

    private static void validarID(ArrayList<PagarServicio> lista, String id) throws IdDuplicadoException {
        for (PagarServicio ps : lista) {
            if (ps.getIdServicio().equals(id)) {
                throw new IdDuplicadoException("El ID '" + id + "' ya está registrado.");
            }
        }
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
        return new Telefonia(id, nombre, emp, nis, per);
    }
}
