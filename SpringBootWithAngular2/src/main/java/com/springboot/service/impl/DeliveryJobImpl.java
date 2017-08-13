package com.springboot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Cliente;
import com.springboot.model.Delivery;
import com.springboot.model.Pedido;
import com.springboot.model.PedidoDetalle;
import com.springboot.model.Reniec;
import com.springboot.repository.jpa.ClienteJpaRepository;
import com.springboot.repository.jpa.DeliveryJpaRepository;
import com.springboot.repository.jpa.PedidoJpaRepository;
import com.springboot.repository.jpa.ReniecJpaRepository;

@Service
public class DeliveryJobImpl {
	
	@Autowired
	DeliveryJpaRepository deliveryJpaRepository;
	
	@Autowired
	ClienteJpaRepository clienteJpaRepository;
	
	@Autowired
	ReniecJpaRepository reniecJpaRepository;
	
	@Autowired
	PedidoJpaRepository pedidoJpaRepository;
	
	@Scheduled(fixedRate = 60000)  // every minuto
	@Transactional
	public void crearReporteMarcacion() {
		
		System.out.println("Ejecutando job");
		List<Delivery> deliverys = deliveryJpaRepository.buscarDeliverysPorEstado("porprocesar");
		System.out.println("Ejecutando: "+deliverys.size());
		for(Delivery delivery: deliverys){
			
			//Busqueda en la RENIEC
			Reniec reniecData = reniecJpaRepository.findOne(delivery.getDni());
			if(reniecData == null){
				delivery.setEstado_deliv("DNI Inv\u00e1lido");
				deliveryJpaRepository.save(delivery);
				deliveryJpaRepository.flush();
				return;
			}else{
				Cliente clienteData = clienteJpaRepository.findOne(delivery.getDni());
				if(clienteData == null){
					Cliente cliente = new Cliente();
					cliente.setDni(reniecData.getReniec_dni());
					cliente.setNombre(reniecData.getNombre());
					cliente.setAp_paterno(reniecData.getAp_paterno());
					cliente.setAp_materno(reniecData.getAp_materno());
					clienteJpaRepository.save(cliente);
					clienteJpaRepository.flush();
					System.out.println("Cliente guardado exitosamente"+cliente.getDni());
				}
			}
			
			//Insertar pedido carta
			Pedido pedidoEntity = new Pedido();
			Cliente clientePedido = clienteJpaRepository.findOne(delivery.getDni());
			pedidoEntity.setCliente(clientePedido);
			pedidoEntity.setPedidoDetalle(new ArrayList<>());
			
			List<String> list_cod_carta = Arrays.asList(delivery.getCod_carta_deliv().split(","));
			for(String cod_carta: list_cod_carta){
				System.out.println("cod carta! "+cod_carta);
				
				PedidoDetalle pedidoDetaEntity = new PedidoDetalle();
				
//				pedidoDetaEntity.setId_pedidetalle(1l);
				pedidoDetaEntity.setCod_carta(cod_carta);
				pedidoDetaEntity.setPedido(pedidoEntity);
				pedidoEntity.getPedidoDetalle().add(pedidoDetaEntity);
			}
			
			delivery.setHoraestimada_deliv(DateUtils.addHours(delivery.getFecha_deliv(), 1));
			
			pedidoJpaRepository.save(pedidoEntity);
			pedidoJpaRepository.flush();
			
			delivery.setEstado_deliv("procesado");
			deliveryJpaRepository.save(delivery);
			deliveryJpaRepository.flush();
			
		}
		
		
		
	}

}
