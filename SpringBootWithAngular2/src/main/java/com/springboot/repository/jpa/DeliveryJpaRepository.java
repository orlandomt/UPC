package com.springboot.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Delivery;

@Repository
public interface DeliveryJpaRepository extends CrudRepository<Delivery, Long>, JpaRepository<Delivery, Long> {
	
	@Query("SELECT e FROM Delivery e WHERE e.estado_deliv = :estado_deliv")
	List<Delivery> buscarDeliverysPorEstado(@Param("estado_deliv") String estado_deliv);

}
