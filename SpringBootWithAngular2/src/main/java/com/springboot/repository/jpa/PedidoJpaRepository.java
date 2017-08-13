package com.springboot.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Pedido;

@Repository
public interface PedidoJpaRepository extends CrudRepository<Pedido, Long>, JpaRepository<Pedido,Long>{

}
