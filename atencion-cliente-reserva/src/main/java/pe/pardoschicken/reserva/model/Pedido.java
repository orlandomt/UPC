package pe.pardoschicken.reserva.model;

import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Pedido {

    private int idPedido;
    private String descripcion;
    private int cantidad;
    private Double precioUnitario;
    private List<ReservaPedido> reservaPedidoList;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public List<ReservaPedido> getReservaPedidoList() {
        return reservaPedidoList;
    }

    public void setReservaPedidoList(List<ReservaPedido> reservaPedidoList) {
        this.reservaPedidoList = reservaPedidoList;
    }
}
