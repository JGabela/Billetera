import java.util.ArrayList;

public class Luz extends PagarServicio {
    private String codigoCliente;
    private String mes;
    private ArrayList<PagarServicio> servicio;

    public Luz() { super(); }
    public Luz(String idServicio) { super(idServicio); }
    public Luz(String idServicio, String nombre) { super(idServicio, nombre); }
    public Luz(String idServicio, String nombre, String empresa) { super(idServicio, nombre, empresa); }

    public Luz(String idServicio, String nombre, String empresa, String codigoCliente, String mes) {
        super(idServicio, nombre, empresa);
        this.codigoCliente = codigoCliente;
        this.mes = mes;
    }

    private void crearServicioLuzPred(){
        servicio.add(new Luz("2", "Juan", "cenl", "989", "abril"));
    }

    @Override
    public String generarDetallePago() {
        return "Pago de luz — Cliente: " + codigoCliente + ", mes: " + mes;
    }
}