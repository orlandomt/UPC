package pe.pardoschicken.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Orlando on 13/07/2017.
 */
@Entity
@Table(name = "hora")
public class Hora {

    @Column(name = "hora_reserva")
    private Time horaReserva;

    @Column(name = "final_aprox")
    private Time finalAprox;

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_reserva")
    private Reserva codReserva;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa idMesa;

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

    public Reserva getCodReserva() {
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
    }
}
