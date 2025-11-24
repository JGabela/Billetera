package Modelo;

import java.util.Random;

public class Usuario {
    private String cedula;
    private int numeroBilletera;
    private String usuario;
    private String clave;
    private String nombre;

    public Usuario(String cedula, String usuario, String clave, String nombre) {
        this.cedula = cedula;
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.numeroBilletera = generarNumeroBilletera();
    }

    private int generarNumeroBilletera() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }

    public String getCedula() {
        return cedula;
    }

    public int getNumeroBilletera() {
        return numeroBilletera;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
}
