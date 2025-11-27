public abstract class PagarServicio {
    protected String idServicio;
    protected String nombre;
    protected String empresa;

    public PagarServicio(){}

    public PagarServicio(String idServicio){
        this.idServicio = idServicio;
        this.nombre = "No asignado";
        this.empresa = "No asignada";
    }

    public PagarServicio(String idServicio, String nombre){
        this.idServicio = idServicio;
        this.nombre = nombre;
    }


    public PagarServicio(String idServicio, String nombre, String empresa){
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.empresa = empresa;
    }

    public String getIdServicio(){
        return idServicio;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmpresa(){
        return empresa;
    }

    public abstract String generarDetallePago();

    @Override
    public String toString(){
        return "Servicio: " + nombre + " Empresa: " + empresa + "ID: " + idServicio;
    }

}