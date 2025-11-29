public class Transacciones {
    protected String idTransaccion;
    protected String Tipo;
    protected double monto;
    protected String fecha;
    protected String tarjetaOrigen;
    protected String tarjetaDestino;
    protected PagarServicio Servicio;

    public Transacciones(String idTransaccion, String Tipo, double monto, String fecha, String tarjetaOrigen, String tarjetaDestino) {
        this.idTransaccion = idTransaccion;
        this.Tipo = Tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.tarjetaOrigen = tarjetaOrigen;
        this.tarjetaDestino = tarjetaDestino;
    }

    public boolean procesarRecarga(double montoRecarga, Usuario usuariologueado){

        Tarjeta tarjetaDestino = usuariologueado.getTarjetas().get(0);

        // Sumar el monto
        tarjetaDestino.Saldo += montoRecarga;

        System.out.println("Recarga realizada con éxito.");
        System.out.println("Usuario: " + usuariologueado.getUsuario());
        System.out.println("Monto recargado: " + montoRecarga);

        return true;
    }

    public boolean procesarTransferencia(double montoEnviado, Usuario usuariologeado, Usuario usuarioRecipiente){

        Tarjeta tarjetaOrigen = usuariologeado.getTarjetas().get(0);
        Tarjeta tarjetaDestino = usuarioRecipiente.getTarjetas().get(0);

        if (montoEnviado <= tarjetaOrigen.Saldo) {

            // Restar del que envía
            tarjetaOrigen.Saldo -= montoEnviado;

            // Sumar al que recibe
            tarjetaDestino.Saldo += montoEnviado;

            System.out.println("Transferencia realizada con éxito.");
            System.out.println("De: " + usuariologeado.getUsuario());
            System.out.println("Para: " + usuarioRecipiente.getUsuario());
            System.out.println("Monto enviado: " + montoEnviado);

            return true;

        } else {
            System.out.println("Saldo insuficiente en la tarjeta del usuario que envía.");
            return false;
        }
    }

    public boolean procesarRetiro(double montoRetiro, Usuario usuariologueado){

        Tarjeta tarjetaOrigen = usuariologueado.getTarjetas().get(0);

        if (montoRetiro <= tarjetaOrigen.Saldo) {

            tarjetaOrigen.Saldo -= montoRetiro;

            System.out.println("Retiro realizado con éxito.");
            System.out.println("Usuario: " + usuariologueado.getUsuario());
            System.out.println("Monto retirado: " + montoRetiro);

            return true;

        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
            return false;
        }
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