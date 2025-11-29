import java.util.ArrayList;

public class Agua extends PagarServicio {
    private String codigoSuministro;
    private String referenciaPago;
    private ArrayList<PagarServicio> servicio;

    public Agua() { super(); }
    public Agua(String idServicio) { super(idServicio); }
    public Agua(String idServicio, String nombre) { super(idServicio, nombre); }
    public Agua(String idServicio, String nombre, String empresa) { super(idServicio, nombre, empresa); }

    public Agua(String idServicio, String nombre, String empresa, String codigoSuministro, String referenciaPago) {
        super(idServicio, nombre, empresa);
        this.codigoSuministro = codigoSuministro;
        this.referenciaPago = referenciaPago;
    }

    private void crearServicioAguaPred(){
        servicio.add(new Agua("32", "Ignacio", "amagua", "987", "paypal"));
    }

    @Override
    public String generarDetallePago() {
        return "Pago de agua — Suministro: " + codigoSuministro + ", ref: " + referenciaPago;
    }
}