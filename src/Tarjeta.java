
public class Tarjeta {

    private String redPago;
    private String tipo; //credito o debito
    private String numTarjeta;
    private String nombrePropietario;
    private String fechaCaducidad;
    private int cvs;
    public double Saldo;



    public Tarjeta(String redPago, String tipo, String numTarjeta, String nombrePropietario, String fechaCaducidad, int cvs) {
        this.redPago = redPago;
        this.tipo = tipo;
        this.numTarjeta = numTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.fechaCaducidad = fechaCaducidad;
        this.cvs = cvs;
    }

    public String getRedPago() {
        return redPago;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getCvs() {
        return cvs;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    /*
    public verTarjeta(){

    }

    public registrarTarjeta(){

    }


    public void pagarTarjeta() {

    }
    */

}
