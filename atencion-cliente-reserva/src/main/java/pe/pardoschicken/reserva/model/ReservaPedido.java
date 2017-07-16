package pe.pardoschicken.reserva.model;

/**
 * Created by Orlando on 13/07/2017.
 */
public class ReservaPedido {

    private Reserva codReserva;
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
