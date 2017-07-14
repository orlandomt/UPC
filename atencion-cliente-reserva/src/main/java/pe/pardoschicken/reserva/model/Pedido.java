package pe.pardoschicken.reserva.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @OneToMany(mappedBy = "reserva_pedido", fetch = FetchType.LAZY)
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
