package pe.pardoschicken.reserva.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Reserva {

    private int codReserva;
    private Date fechaReserva;
    private String tipoReserva;
    private String motivo;
    private Date fecha;
    private Cliente cliente;
    private Local local;
    private List<Hora> horas;
    private List<ReservaPedido> reservaPedidos;

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }

    public List<ReservaPedido> getReservaPedidos() {
        return reservaPedidos;
    }

    public void setReservaPedidos(List<ReservaPedido> reservaPedidos) {
        this.reservaPedidos = reservaPedidos;
    }
}
