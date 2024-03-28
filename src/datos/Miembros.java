package datos;

import java.util.Date;

public class Miembros {
    private String nombre;
    private String apellido;
    private Date fnaci;
    private String genero;
    private String direccion;
    private String email;
    private String telefono;

    public Miembros( String nombre, String apellido, Date fnaci, String genero, String direccion, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fnaci = fnaci;
        this.genero = genero;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
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


}
