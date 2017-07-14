package pe.pardoschicken.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue
    @Column(name = "ood_local")
    private int codLocal;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "aforo")
    private int aforo;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "mesa", fetch = FetchType.LAZY)
    private List<Mesa> mesas = new ArrayList<>();

    public int getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(int codLocal) {
        this.codLocal = codLocal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }
}
