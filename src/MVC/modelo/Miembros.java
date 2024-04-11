package MVC.modelo;

import java.util.Date;

public class Miembros {
    private String nombre;
    private String apellido;
    private Date fnaci;
    private String genero;
    private String direccion;
    private String email;
    private String telefono;
    private Date fecha_bautismo;
    private Boolean asisitio_culto;


    public Miembros(String nombre, String apellido, Date fnaci, String genero, String direccion, String email, String telefono, Date fecha_bautismo, Boolean asisitio_culto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fnaci = fnaci;
        this.genero = genero;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.fecha_bautismo = fecha_bautismo;
        this.asisitio_culto = asisitio_culto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFnaci() {
        return fnaci;
    }

    public void setFnaci(Date fnaci) {
        this.fnaci = fnaci;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_bautismo() {
        return fecha_bautismo;
    }

    public void setFecha_bautismo(Date fecha_bautismo) {
        this.fecha_bautismo = fecha_bautismo;
    }

    public Boolean getAsisitio_culto() {
        return asisitio_culto;
    }

    public void setAsisitio_culto(Boolean asisitio_culto) {
        this.asisitio_culto = asisitio_culto;
    }
}
