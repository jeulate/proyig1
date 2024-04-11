package MVC.modelo.entity;

public class Relaciones {
    private int miembro1_id;
    private int miembro2_id;
    private String tipo_relacion;

    public Relaciones(int miembro1_id, int miembro2_id, String tipo_relacion) {
        this.miembro1_id = miembro1_id;
        this.miembro2_id = miembro2_id;
        this.tipo_relacion = tipo_relacion;
    }

    public int getMiembro1_id() {
        return miembro1_id;
    }

    public void setMiembro1_id(int miembro1_id) {
        this.miembro1_id = miembro1_id;
    }

    public int getMiembro2_id() {
        return miembro2_id;
    }

    public void setMiembro2_id(int miembro2_id) {
        this.miembro2_id = miembro2_id;
    }

    public String getTipo_relacion() {
        return tipo_relacion;
    }

    public void setTipo_relacion(String tipo_relacion) {
        this.tipo_relacion = tipo_relacion;
    }
}
