package pe.pardoschicken.reserva.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Local {

    private int codLocal;
    private String ubicacion;
    private String telefono;
    private int aforo;
    private List<Reserva> reservas = new ArrayList<>();
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
