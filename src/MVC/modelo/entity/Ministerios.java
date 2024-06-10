package MVC.modelo.entity;

public class Ministerios implements Cloneable<Ministerios> {
    private Integer id;
    private String nombre;
    private String descripcion;

    public Ministerios(Integer id,String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Ministerios(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Ministerios clone(){
        return new Ministerios(this.nombre, this.descripcion);
    }
}
