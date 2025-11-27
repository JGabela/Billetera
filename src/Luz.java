public class Luz extends PagarServicio {
    private String codigoCliente;
    private String mes;

    public Luz() { super(); }
    public Luz(String idServicio) { super(idServicio); }
    public Luz(String idServicio, String nombre) { super(idServicio, nombre); }
    public Luz(String idServicio, String nombre, String empresa) { super(idServicio, nombre, empresa); }

    public Luz(String idServicio, String nombre, String empresa, String codigoCliente, String mes) {
        super(idServicio, nombre, empresa);
        this.codigoCliente = codigoCliente;
        this.mes = mes;
    }

    @Override
    public String generarDetallePago() {
        return "Pago de luz — Cliente: " + codigoCliente + ", mes: " + mes;
}
}