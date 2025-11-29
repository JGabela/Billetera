import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorTarjetas {
    private Map<String, ArrayList<Tarjeta>> tarjetasPorUsuario;

    public GestorTarjetas() {
        this.tarjetasPorUsuario = new HashMap<>();
        crearTarjetasPredeterminadas();
    }

    private void crearTarjetasPredeterminadas() {
        // Tarjetas para usuario "Spanza07" - $100 en cada una
        Tarjeta tarjeta1Sancho = new Tarjeta("Visa", "credito", "1234567890123456", "Sancho Panza", "12/25", 123);
        tarjeta1Sancho.setSaldo(100.0);

        Tarjeta tarjeta2Sancho = new Tarjeta("Mastercard", "debito", "2345678901234567", "Sancho Panza", "10/26", 456);
        tarjeta2Sancho.setSaldo(100.0);

        // Agregar tarjetas al usuario "Spanza07"
        if (!tarjetasPorUsuario.containsKey("Spanza07")) {
            tarjetasPorUsuario.put("Spanza07", new ArrayList<>());
        }
        tarjetasPorUsuario.get("Spanza07").add(tarjeta1Sancho);
        tarjetasPorUsuario.get("Spanza07").add(tarjeta2Sancho);

        // Tarjetas para usuario "maria22" - $500 en cada una
        Tarjeta tarjeta1Maria = new Tarjeta("Visa", "credito", "3456789012345678", "María González", "08/25", 789);
        tarjeta1Maria.setSaldo(500.0);

        Tarjeta tarjeta2Maria = new Tarjeta("Amex", "debito", "4567890123456789", "María González", "05/27", 321);
        tarjeta2Maria.setSaldo(500.0);

        // Agregar tarjetas al usuario "maria22"
        if (!tarjetasPorUsuario.containsKey("maria22")) {
            tarjetasPorUsuario.put("maria22", new ArrayList<>());
        }
        tarjetasPorUsuario.get("maria22").add(tarjeta1Maria);
        tarjetasPorUsuario.get("maria22").add(tarjeta2Maria);
    }

    public boolean agregarTarjeta(Usuario usuario, Tarjeta tarjeta) {
        if (!tarjetasPorUsuario.containsKey(usuario.getUsuario())) {
            tarjetasPorUsuario.put(usuario.getUsuario(), new ArrayList<>());
        }

        ArrayList<Tarjeta> tarjetasUsuario = tarjetasPorUsuario.get(usuario.getUsuario());
        for (Tarjeta t : tarjetasUsuario) {
            if (t.getNumTarjeta().equals(tarjeta.getNumTarjeta())) {
                System.out.println("Error: Esta tarjeta ya está registrada para el usuario.");
                return false;
            }
        }

        tarjetasUsuario.add(tarjeta);
        System.out.println("Tarjeta agregada exitosamente.");
        return true;
    }

    public boolean eliminarTarjeta(Usuario usuario, String numTarjeta) {
        if (!tarjetasPorUsuario.containsKey(usuario.getUsuario())) {
            System.out.println("Error: El usuario no tiene tarjetas registradas.");
            return false;
        }

        ArrayList<Tarjeta> tarjetasUsuario = tarjetasPorUsuario.get(usuario.getUsuario());
        for (int i = 0; i < tarjetasUsuario.size(); i++) {
            if (tarjetasUsuario.get(i).getNumTarjeta().equals(numTarjeta)) {
                tarjetasUsuario.remove(i);
                System.out.println("Tarjeta eliminada exitosamente.");
                return true;
            }
        }

        System.out.println("Error: No se encontró la tarjeta con el número especificado.");
        return false;
    }

    public ArrayList<Tarjeta> obtenerTarjetas(Usuario usuario) {
        return tarjetasPorUsuario.getOrDefault(usuario.getUsuario(), new ArrayList<>());
    }

    public void mostrarTarjetas(Usuario usuario) {
        ArrayList<Tarjeta> tarjetas = obtenerTarjetas(usuario);

        if (tarjetas.isEmpty()) {
            System.out.println("No tienes tarjetas registradas.");
            return;
        }

        System.out.println("\n--- TUS TARJETAS ---");
        for (int i = 0; i < tarjetas.size(); i++) {
            Tarjeta tarjeta = tarjetas.get(i);
            String numTarjeta = tarjeta.getNumTarjeta();
            System.out.println((i + 1) + ". " + tarjeta.getTipo() + " - " +
                    tarjeta.getRedPago() + " - ****" +
                    numTarjeta.substring(numTarjeta.length() - 4));
        }
    }

    public Tarjeta buscarTarjetaPorNumero(Usuario usuario, String numTarjeta) {
        ArrayList<Tarjeta> tarjetas = obtenerTarjetas(usuario);
        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta.getNumTarjeta().equals(numTarjeta)) {
                return tarjeta;
            }
        }
        return null;
    }

    public boolean tieneTarjetas(Usuario usuario) {
        return tarjetasPorUsuario.containsKey(usuario.getUsuario()) &&
                !tarjetasPorUsuario.get(usuario.getUsuario()).isEmpty();
    }

    public int cantidadTarjetas(Usuario usuario) {
        if (!tarjetasPorUsuario.containsKey(usuario.getUsuario())) {
            return 0;
        }
        return tarjetasPorUsuario.get(usuario.getUsuario()).size();
    }


}
