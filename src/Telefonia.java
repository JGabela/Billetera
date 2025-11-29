import java.util.ArrayList;

public class Telefonia extends PagarServicio {
    private String nis;
    private String periodoFacturacion;
    private ArrayList<PagarServicio> servicio;

    public Telefonia() { super(); }
    public Telefonia(String idServicio) { super(idServicio); }
    public Telefonia(String idServicio, String nombre) { super(idServicio, nombre); }
    public Telefonia(String idServicio, String nombre, String empresa) { super(idServicio, nombre, empresa); }

    public Telefonia(String idServicio, String nombre, String empresa, String nis, String periodoFacturacion) {
        super(idServicio, nombre, empresa);
        this.nis = nis;
        this.periodoFacturacion = periodoFacturacion;
    }

    private void crearServicioTelefoniaPred(){
        servicio.add(new Telefonia("20", "Milton", "cnt", "9", "un mes"));
    }

    @Override
    public String generarDetallePago() {
        return "Pago telefónico — NIS: " + nis + ", periodo: " + periodoFacturacion;
    }
}