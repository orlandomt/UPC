package pe.pardoschicken.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue
    @Column(name = "cod_reserva")
    private int codReserva;

    @Column(name = "fecha_reserva")
    private Date fechaReserva;

    @Column(name = "tipo_reserva")
    private String tipoReserva;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cod_local")
    private Local local;

    @OneToMany(mappedBy = "hora", fetch = FetchType.LAZY)
    private List<Hora> horas;

    @OneToMany(mappedBy = "reserva_pedido", fetch = FetchType.LAZY)
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
