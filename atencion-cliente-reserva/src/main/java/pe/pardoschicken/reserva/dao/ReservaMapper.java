package pe.pardoschicken.reserva.dao;

import org.apache.ibatis.annotations.Param;
import pe.pardoschicken.reserva.model.Local;
import pe.pardoschicken.reserva.model.Mesa;
import pe.pardoschicken.reserva.model.Reniec;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaMapper {

    Reniec buscarPorDni(@Param("dni") String dni);

    List<Local> buscarReserva(@Param("codLocal") int codLocal, @Param("fechaInicial") Date fechaInicial,
                              @Param("fechaFin") Date fechaFin, @Param("tipoReserva") String tipoReserva,
                              @Param("apPaterno") String apPaterno, @Param("nombre") String nombre);

    Local buscarLocal(@Param("ubicacion") String ubicacion);

    Mesa buscarMesa(@Param("numMesa") int numMesa, @Param("codLocal") int codLocal);

    void nuevoCliente(@Param("dni") String dni, @Param("nombre") String nombre, @Param("apPaterno") String apPaterno,
                      @Param("apMaterno") String apMaterno, @Param("direccion") String direccion, @Param("telefono") String telefono,
                      @Param("correo") String correo, @Param("reniecDni") String reniecDni);

    void nuevaReserva(@Param("fechaReserva") Date fechaReserva, @Param("tipoReserva") String tipoReserva, @Param("motivo") String motivo,
                      @Param("fecha") Date fecha, @Param("dni") String dni, @Param("codLocal") int codLocal);

    void nuevaHora(@Param("codReserva") int codReserva, @Param("idMesa") int idMesa, @Param("horaReserva") Time horaReserva,
                   @Param("finalAprox") Time finalAprox);

}
