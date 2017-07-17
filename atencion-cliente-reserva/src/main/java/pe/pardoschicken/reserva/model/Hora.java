package pe.pardoschicken.reserva.model;

import java.sql.Time;

/**
 * Created by Orlando on 13/07/2017.
 */
public class Hora {

    private Time horaReserva;
    private Time finalAprox;
    //private Reserva codReserva;
    //private Mesa idMesa;

    public Time getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Time horaReserva) {
        this.horaReserva = horaReserva;
    }

    public Time getFinalAprox() {
        return finalAprox;
    }

    public void setFinalAprox(Time finalAprox) {
        this.finalAprox = finalAprox;
    }

    /*public Reserva getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Reserva codReserva) {
        this.codReserva = codReserva;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }*/
}
