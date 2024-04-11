package MVC.modelo;

public class Asistencia_eventos  {
    private int miembro_id;
    private int evento_id;
    private Boolean asistio;

    public Asistencia_eventos(int miembro_id, int evento_id, Boolean asistio) {
        this.miembro_id = miembro_id;
        this.evento_id = evento_id;
        this.asistio = asistio;
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
