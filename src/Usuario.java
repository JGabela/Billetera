import java.util.ArrayList; //Para guardar las transacciones realizadas por el usuario

public class Usuario {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    //private double saldo;

    //Un array list para almacenar los contactos guardados del usuario
    private ArrayList<Contactos> contactos;

    //Un array list para almacenar las transacciones del usuario
    private ArrayList<gestionTransacciones> transacciones;

    //Un array list para almacenar las tarjetas
    private ArrayList<Tarjeta> tarjetas;


    public Usuario(String cedula, String nombre, String apellido){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        //this.saldo = 0.0; //El saldo por defecto es 0
        this.contactos = new ArrayList<>(); //Se crea el array list de los contactos al usuario
        this.transacciones = new ArrayList<>(); //Se crea el array list de las transacciones al usuario
    }

    //Añade la transaccion a la lista de estas
    public void nuevaTransaccion(gestionTransacciones transaccion){
        transacciones.add(transaccion);
    }

    //Crea un nuevo y lo añade a la lista de contactos del usuario
    public void nuevoContactos(){

    }
/*
    //Confirma si el alias a buscar está en la lista de contactos del usuario
    public Contactos buscarContactos(String alias){
        for (Contactos contacto : contactos){
            if (contacto.getAlias().equals(alias)){
                return contacto; //Si es que el alias esta en la lista de contactos
            }
        }
        return null; //Si es que el alias no es parte de la lista de contactos
    }
*/

}
