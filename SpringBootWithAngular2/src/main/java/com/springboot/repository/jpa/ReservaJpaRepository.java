package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Reserva;

@Repository
public interface ReservaJpaRepository extends CrudRepository<Reserva, Long>, JpaRepository<Reserva,Long>{

	@Query("SELECT p FROM Reserva p WHERE p.cod_reserva = :cod_reserva ")
	Reserva findReservaByCode(@Param("cod_reserva") String cod_reserva);
}
