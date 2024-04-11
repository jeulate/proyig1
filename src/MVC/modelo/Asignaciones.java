package MVC.modelo;

import java.util.Date;

public class Asignaciones extends Ministerios {
    private int IdMiembro;
    private int idMinisterio;
    private Date finicio;
    private Date ffin;

    public Asignaciones(String nombre, String descripcion, int idMiembro, int idMinisterio, Date finicio, Date ffin) {
        super(nombre, descripcion);
        IdMiembro = idMiembro;
        this.idMinisterio = idMinisterio;
        this.finicio = finicio;
        this.ffin = ffin;
    }

    public int getIdMiembro() {
        return IdMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        IdMiembro = idMiembro;
    }

    public int getIdMinisterio() {
        return idMinisterio;
    }

    public void setIdMinisterio(int idMinisterio) {
        this.idMinisterio = idMinisterio;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }
}
