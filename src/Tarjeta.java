
public class Tarjeta {

    private String redPago;
    private String tipo; //credito o debito
    private int numTarjeta;
    private String nombrePropietario;
    private String fechaCaducidad;
    private int cvs;
    public double Saldo;



    public Tarjeta(String redPago, String tipo, int numTarjeta, String nombrePropietario, String fechaCaducidad, int cvs) {
        this.redPago = redPago;
        this.tipo = tipo;
        this.numTarjeta = numTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.fechaCaducidad = fechaCaducidad;
        this.cvs = cvs;
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
