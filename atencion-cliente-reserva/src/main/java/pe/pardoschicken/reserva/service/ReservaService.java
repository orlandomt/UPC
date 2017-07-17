package pe.pardoschicken.reserva.service;

import pe.pardoschicken.reserva.model.Cliente;
import pe.pardoschicken.reserva.model.Reserva;

import java.sql.Date;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaService {

    String buscarPorDni(String dni);
    String buscarReserva(int codLocal, Date fechaInicial, Date fechaFin, String tipoReserva, String apPaterno, String nombre);
    void nuevaReserva(Cliente cliente, Reserva reserva, String ubicacion, int numMesa);

}
