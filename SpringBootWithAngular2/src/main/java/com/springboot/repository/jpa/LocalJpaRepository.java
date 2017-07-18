package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.model.Local;

@Repository
public interface LocalJpaRepository extends CrudRepository<Local, Long>, JpaRepository<Local,Long>{
	
	@Query("SELECT p FROM Local p WHERE p.nombre_local = :nombre_local ")
	Local findLocalByName(@Param("nombre_local") String nombre_local);

}