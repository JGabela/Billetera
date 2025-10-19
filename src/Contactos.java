public class Contactos extends Usuario{
    private String alias; //alias de la persona guardada

    public Contactos(String cedula, String nombre, String apellido) {
        super(cedula, nombre, apellido);
    }

    /*
    private Usuario usuario; //usuario dueño del contacto
    private String Cedula;
    private String alias; //alias del contacto

    public Contactos(){
        super(id, nombre, apellido);
        this.alias = alias;
        this.usuario = usuario;
    }

    //getters
    public String getAlias(){
        return alias;
    }

    public Usuario getUsuario(){
        return usuario;
    }
    */
}
