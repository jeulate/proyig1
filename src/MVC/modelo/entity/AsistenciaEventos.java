package MVC.modelo.entity;

public class AsistenciaEventos {
    private int id;
    private int miembro_id;
    private int evento_id;
    private Boolean asistio;

    public AsistenciaEventos(int id, int miembro_id, int evento_id, Boolean asistio) {
        this.id = id;
        this.miembro_id = miembro_id;
        this.evento_id = evento_id;
        this.asistio = asistio;
    }

    public AsistenciaEventos(int miembro_id, int evento_id, Boolean asistio) {
        this.miembro_id = miembro_id;
        this.evento_id = evento_id;
        this.asistio = asistio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }

    public int getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }
}
