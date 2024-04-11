package MVC.modelo.entity;

import java.util.Date;

public class Ofrendas {
    private int miembro_id;
    private double monto;
    private Date fecha_pago;

    public Ofrendas(int miembro_id, double monto, Date fecha_pago) {
        this.miembro_id = miembro_id;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
    }

    public int getMiembro_id() {
        return miembro_id;
    }

    public void setMiembro_id(int miembro_id) {
        this.miembro_id = miembro_id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
