package MVC.modelo.entity;

import java.util.Date;

public class Miembros {
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String genero;
    private String direccion;
    private String correo_electronico;
    private String telefono;
    private Date fecha_bautismo;
    private Boolean asistio_culto;


    public Miembros(Integer id, String nombre, String apellido, Date fecha_nacimiento, String genero, String direccion, String correo_electronico, String telefono, Date fecha_bautismo, Boolean asistio_culto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.fecha_bautismo = fecha_bautismo;
        this.asistio_culto = asistio_culto;
    }
    public Miembros(String nombre, String apellido, Date fecha_nacimiento, String genero, String direccion, String correo_electronico, String telefono, Date fecha_bautismo, Boolean asistio_culto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.fecha_bautismo = fecha_bautismo;
        this.asistio_culto = asistio_culto;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
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

    public Boolean getAsistio_culto() {
        return asistio_culto;
    }

    public void setAsistio_culto(Boolean asistio_culto) {
        this.asistio_culto = asistio_culto;
    }
}
