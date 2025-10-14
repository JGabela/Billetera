public class Contactos extends Usuario{
    private Usuario usuario; //usuario dueño del contacto
    private String alias; //alias del contacto

    public Contactos(int id, String nombre, String apellido, String alias, Usuario usuario){
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
}
