package pe.pardoschicken.reserva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.pardoschicken.reserva.model.Reniec;

/**
 * Created by Orlando on 14/07/2017.
 */
public interface ReniecDAO extends JpaRepository<Reniec, Long> {

    Reniec buscarPorDni(String dni);
}
