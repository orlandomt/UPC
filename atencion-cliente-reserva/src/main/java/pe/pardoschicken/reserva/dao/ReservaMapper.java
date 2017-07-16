package pe.pardoschicken.reserva.dao;

import org.apache.ibatis.annotations.Param;
import pe.pardoschicken.reserva.model.Reniec;

/**
 * Created by Orlando on 15/07/2017.
 */
public interface ReservaMapper {

    public Reniec buscarPorDni(@Param("dni") String dni);
}
