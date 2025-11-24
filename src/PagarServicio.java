public class PagarServicio {

       private String idServicio;
    private String nombre;
    private String empresa;

    public PagarServicio(String idServicio, String nombre, String empresa) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public PagarServicio(String nombre, String empresa) {
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public PagarServicio(String nombre) {
        this.nombre = nombre;
    }

    public String getIdServicio() {
        return idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
  public String toString() {
        return "Servicio: " + nombre + " | Empresa: " + empresa + " | ID: " + idServicio;
    }

}
