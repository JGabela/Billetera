import java.util.ArrayList; //Para guardar las transacciones realizadas por el usuario

public class Usuario {
    protected int id;
    protected String nombre;
    protected String apellido;
    private double saldo;

    //Un array list para almacenar los contactos guardados del usuario
    private ArrayList<Contactos> contactos;

    //Un array list para almacenar las transacciones del usuario
    private ArrayList<gestionTransacciones> transacciones;


    public Usuario(int id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = 0.0; //El saldo por defecto es 0
        this.contactos = new ArrayList<>(); //Se crea el array list de los contactos al usuario
        this.transacciones = new ArrayList<>(); //Se crea el array list de las transacciones al usuario
    }

    //Añade la transaccion a la lista de estas
    public void nuevaTransaccion(gestionTransacciones transaccion){
        transacciones.add(transaccion);
    }

    public void nuevoContactos(){

    }

    public Contactos buscarContactos(String alias){
        for (Contactos contacto : contactos){
            if (contacto.getAlias().equals(alias)){
                return contacto;
            }
        }
        return null;
    }

}
