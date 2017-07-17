package pe.pardoschicken.reserva.service;

import org.apache.ibatis.annotations.Param;
import pe.pardoschicken.reserva.model.Reserva;

import java.sql.Date;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaService {

    String buscarPorDni(String dni);
    String buscarReserva(int codLocal, Date fechaInicial, Date fechaFin, String tipoReserva, String apPaterno, String nombre);

}
