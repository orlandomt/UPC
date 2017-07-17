package pe.pardoschicken.reserva.dao;

import org.apache.ibatis.annotations.Param;
import pe.pardoschicken.reserva.model.Local;
import pe.pardoschicken.reserva.model.Reniec;
import pe.pardoschicken.reserva.model.Reserva;

import java.sql.Date;
import java.util.List;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaMapper {

    Reniec buscarPorDni(@Param("dni") String dni);

    List<Local> buscarReserva(@Param("codLocal") int codLocal, @Param("fechaInicial") Date fechaInicial,
                              @Param("fechaFin") Date fechaFin, @Param("tipoReserva") String tipoReserva,
                              @Param("apPaterno") String apPaterno, @Param("nombre") String nombre);

}
