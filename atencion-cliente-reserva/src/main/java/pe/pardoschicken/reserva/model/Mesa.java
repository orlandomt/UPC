package pe.pardoschicken.reserva.model;

import java.util.List;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Mesa {

    private int idMesa;
    private int numMesa;
    private Local codLocal;
    private List<Hora> horas;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public Local getCodLocal() {
        return codLocal;
    }

    public void setCodLocal(Local codLocal) {
        this.codLocal = codLocal;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }
}
