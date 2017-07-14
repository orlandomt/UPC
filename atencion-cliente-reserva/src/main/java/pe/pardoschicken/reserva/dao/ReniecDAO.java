package pe.pardoschicken.reserva.dao;

import org.springframework.data.repository.CrudRepository;
import pe.pardoschicken.reserva.model.Reniec;

/**
 * Created by Orlando on 14/07/2017.
 */
public interface ReniecDAO extends CrudRepository<Reniec, Long> {

    Reniec buscarPorDni(String dni);
}
