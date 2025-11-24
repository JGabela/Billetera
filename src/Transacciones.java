public class transacciones {
    protected String idTransaccion;
    protected String Tipo;
    protected double monto;
    protected String fecha;
    protected String tarjetaOrigen;
    //protected pagarServicio Servicio;

    public transacciones(String idTransaccion, String Tipo, double monto, String fecha, String tarjetaOrigen) {
        this.idTransaccion = idTransaccion;
        this.Tipo = Tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.tarjetaOrigen = tarjetaOrigen;
    }

    protected void procesarRecarga(){

    }

    protected void procesarTransferencia(){

    }

    protected void procesarRetiro(){

    }

    protected void procesarPagoServicios(){

    }

    //Getters
    public String getIdTransaccion() {
        return idTransaccion;
    }
    public String getTipo() {
        return Tipo;
    }

    public double getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

}
