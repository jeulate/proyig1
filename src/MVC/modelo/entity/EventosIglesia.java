package MVC.modelo.entity;

import java.util.Date;

public class EventosIglesia {
    private String nombre_evento;
    private String descripcion;
    private Date fecha_evento;
    private String tipo_evento;

    public EventosIglesia(String nombre_evento, String descripcion, Date fecha_evento, String tipo_evento) {
        this.nombre_evento = nombre_evento;
        this.descripcion = descripcion;
        this.fecha_evento = fecha_evento;
        this.tipo_evento = tipo_evento;
    }

    public String getNombre_evento() {
        return nombre_evento;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre_evento = nombre_evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_evento() {
        return fecha_evento;
    }

    public void setFecha_evento(Date fecha_evento) {
        this.fecha_evento = fecha_evento;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }
}
