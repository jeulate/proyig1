package MVC.modelo;

import java.util.Date;

public class Asignaciones{
    private int miembro_id;
    private int ministerio_id;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Asignaciones(int miembro_id, int ministerio_id, Date fecha_inicio, Date fecha_fin) {
        this.miembro_id = miembro_id;
        this.ministerio_id = ministerio_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }

    public int getMinisterio_id() {
        return ministerio_id;
    }

    public void setMinisterio_id(int ministerio_id) {
        this.ministerio_id = ministerio_id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
