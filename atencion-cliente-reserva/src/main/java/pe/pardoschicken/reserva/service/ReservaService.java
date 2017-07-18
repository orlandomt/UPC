package pe.pardoschicken.reserva.service;

import pe.pardoschicken.reserva.model.Cliente;
import pe.pardoschicken.reserva.model.Reserva;
import pe.pardoschicken.reserva.model.ReservaFilter;
import pe.pardoschicken.reserva.model.ReservaResult;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaService {

    String buscarPorDni(String dni);
    String buscarReserva(int codLocal, Date fechaInicial, Date fechaFin, String tipoReserva, String apPaterno, String nombre);
    void nuevaReserva(String json, String ubicacion, int numMesa, Time horaReserva) throws ParseException;
	List<ReservaResult> searchReserva(ReservaFilter reservaFilter);

}
