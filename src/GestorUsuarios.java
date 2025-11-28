import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
        crearUsuariosPredeterminados();
    }

    private void crearUsuariosPredeterminados() {
        // Usuario 1
        usuarios.add(new Usuario("0950086107", "Spanza07", "123Aa", "Sancho Panza"));

        // Usuario 2
        usuarios.add(new Usuario("1234567890", "maria22", "clave123", "María González"));

    }

    public boolean crearUsuario(String cedula, String nombreUsuario, String clave, String nombreCompleto) {
        // Validar cédula
        if (!validarCedula(cedula)) {
            System.out.println("Error: La cédula debe tener 10 dígitos.");
            return false;
        }

        // Verificar si cédula ya existe
        if (cedulaExiste(cedula)) {
            System.out.println("Error: Esta cédula ya está registrada.");
            return false;
        }

        // Verificar si usuario ya existe
        if (existeUsuario(nombreUsuario)) {
            System.out.println("Error: Este nombre de usuario ya existe.");
            return false;
        }

        // Validar clave
        if (clave.length() < 5) {
            System.out.println("Error: La clave debe tener al menos 5 caracteres.");
            return false;
        }

        // Crear y agregar usuario
        Usuario nuevoUsuario = new Usuario(cedula, nombreUsuario, clave, nombreCompleto);
        usuarios.add(nuevoUsuario);
        return true;
    }

    public Usuario iniciarSesion(String nombreUsuario, String clave) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getClave().equals(clave)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean existeUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean cedulaExiste(String cedula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCedula(String cedula) {
        return cedula != null && cedula.matches("\\d{10}");
    }

}