package pe.pardoschicken.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by Orlando on 13/07/2017.
 */
public class ReservaPedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_reserva")
    private Reserva codReserva;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido idPedido;

    public Reserva getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Reserva codReserva) {
        this.codReserva = codReserva;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }
}
