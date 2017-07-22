package com.springboot.service.impl;

import com.springboot.repository.jdbc.ReservaJdbcRepository;
import com.springboot.repository.jpa.ClienteJpaRepository;
import com.springboot.repository.jpa.LocalJpaRepository;
import com.springboot.repository.jpa.MesaJpaRepository;
import com.springboot.repository.jpa.ReservaJpaRepository;
import com.springboot.model.Cliente;
import com.springboot.model.ClienteViewModel;
import com.springboot.model.Local;
import com.springboot.model.Mesa;
import com.springboot.model.MesaViewModel;
import com.springboot.model.NotificacionViewModel;
import com.springboot.model.Reserva;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;
import com.springboot.service.ReservaService;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaJdbcRepository reservaJdbcRepository;
	
	@Autowired
	ReservaJpaRepository reservaJpaRepository;
	
	@Autowired
	ClienteJpaRepository clienteJpaRepository;
	
	@Autowired
	MesaJpaRepository mesaJpaRepository;
	
	@Autowired
	LocalJpaRepository localJpaRepository;
	
	Mapper mapper;

	@Override
	public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		return reservaJdbcRepository.searchReserva(reservaFilter);
	}

	@Override
	public ReservaViewModel getReservaByCode(Long cod_reserva) {
		ReservaViewModel dto = new ReservaViewModel();
		
		Reserva reservaEntity = reservaJpaRepository.findOne(cod_reserva);
		dto.setCod_reserva(reservaEntity.getCod_reserva());
		dto.setFecha_reserva(reservaEntity.getFecha_reserva());
		dto.setTipo_reserva(reservaEntity.getTipo_reserva());
		dto.setMotivo(reservaEntity.getMotivo());
		dto.setHora(reservaEntity.getHora());
		dto.setCantidad_personas(reservaEntity.getCantidad_personas());
		dto.setEstado(reservaEntity.getEstado());
		dto.setComentario(reservaEntity.getComentario());
		
		Cliente clienteEntity = clienteJpaRepository.findOne(reservaEntity.getCliente().getDni());
		dto.setDni(clienteEntity.getDni());
		dto.setNombre(clienteEntity.getNombre());
		dto.setAp_paterno(clienteEntity.getAp_paterno());
		dto.setCorreo(clienteEntity.getCorreo());
		dto.setTelefono(clienteEntity.getTelefono());
		
		Mesa mesaEntity = mesaJpaRepository.findOne(reservaEntity.getMesa().getCod_mesa());
		dto.setCod_mesa(mesaEntity.getCod_mesa());
		dto.setNombre_mesa(mesaEntity.getNombre_mesa());
		
		Local localEntity = localJpaRepository.findLocalByName(reservaEntity.getLocal().getNombre_local());
		dto.setNombre_local(localEntity.getNombre_local());
		
		
		return dto;
	}

	@Override
	public NotificacionViewModel actualizarReserva(ReservaViewModel reservaModel) {

		NotificacionViewModel notificacion = new NotificacionViewModel();
		
		try{
			Reserva dto = new Reserva();
	
			dto.setCod_reserva(reservaModel.getCod_reserva());
			dto.setFecha_reserva(reservaModel.getFecha_reserva());
			dto.setTipo_reserva(reservaModel.getTipo_reserva());
			dto.setMotivo(reservaModel.getMotivo());
			dto.setHora(reservaModel.getHora());
			dto.setCantidad_personas(reservaModel.getCantidad_personas());
			dto.setEstado(reservaModel.getEstado());
			dto.setComentario(reservaModel.getComentario());
			
			Cliente clienteEntity = clienteJpaRepository.findOne(reservaModel.getDni());
			dto.setCliente(clienteEntity);
			
			Mesa mesaEntityAnterior = mesaJpaRepository.findOne(reservaModel.getCod_mesa_anterior());

			Mesa mesaentiAnterior = new Mesa();
			mesaentiAnterior.setCod_mesa(mesaEntityAnterior.getCod_mesa());
			mesaentiAnterior.setDisponibilidad(true);
			mesaentiAnterior.setFecha_mesa(mesaEntityAnterior.getFecha_mesa());
			mesaentiAnterior.setHora_mesa(mesaEntityAnterior.getHora_mesa());
			mesaentiAnterior.setNombre_mesa(mesaEntityAnterior.getNombre_mesa());
			mesaJpaRepository.save(mesaentiAnterior);
			mesaJpaRepository.flush();
			
			Mesa mesaEntity = mesaJpaRepository.findOne(reservaModel.getCod_mesa());
			Mesa mesaentiNueva = new Mesa();
			mesaentiNueva.setCod_mesa(mesaEntity.getCod_mesa());
			mesaentiNueva.setDisponibilidad(false);
			mesaentiNueva.setFecha_mesa(mesaEntity.getFecha_mesa());
			mesaentiNueva.setHora_mesa(mesaEntity.getHora_mesa());
			mesaentiNueva.setNombre_mesa(mesaEntity.getNombre_mesa());
			mesaJpaRepository.save(mesaentiNueva);
			mesaJpaRepository.flush();
			
			dto.setMesa(mesaEntity);
			
			Local localEntity = localJpaRepository.findLocalByName(reservaModel.getNombre_local());
			dto.setLocal(localEntity);
			
			reservaJpaRepository.save(dto);
			reservaJpaRepository.flush();
			
			notificacion.setCodigo(1L);
			notificacion.setSeverity("success");
			notificacion.setSummary("Runakuna Success");
			notificacion.setDetail("Se actualizo exitosamente");
			return notificacion;
			
		} catch (Exception e) {
			notificacion.setCodigo(0L);
			notificacion.setSeverity("error");
			notificacion.setSummary("Runakuna Error");
			notificacion.setDetail("No es posible registrar, "+e.getMessage());
			e.printStackTrace();
		}
		return notificacion;
	}

	@Override
	public NotificacionViewModel anularReserva(ReservaViewModel reservaModel) {
		NotificacionViewModel notificacion = new NotificacionViewModel();
		Reserva entity = reservaJpaRepository.findOne(reservaModel.getCod_reserva());
		entity.setEstado("Anulado");
		reservaJpaRepository.save(entity);
		reservaJpaRepository.flush();
		
		Mesa mesaenti = new Mesa();
		mesaenti.setCod_mesa(reservaModel.getCod_mesa());
		mesaenti.setDisponibilidad(true);
		mesaenti.setFecha_mesa(reservaModel.getFecha_reserva());
		mesaenti.setHora_mesa(reservaModel.getHora());
		mesaenti.setNombre_mesa(reservaModel.getNombre_mesa());
		mesaJpaRepository.save(mesaenti);
		mesaJpaRepository.flush();
		
		notificacion.setCodigo(1L);
		notificacion.setSeverity("success");
		notificacion.setSummary("Runakuna Success");
		notificacion.setDetail("El registro fue anulado correctamente");
		return notificacion;
	}

	@Override
	public ClienteViewModel obtenerInformacionClienteByDNI(Long dni) {
		ClienteViewModel dto = reservaJdbcRepository.obtenerInformacionClienteByDNI(dni);
		return dto;
	}

	@Override
	public MesaViewModel obtenerUltimaReservaClienteByDNI(Long dni) {
		MesaViewModel dto = reservaJdbcRepository.obtenerUltimaReservaClienteByDNI(dni);
		return dto;
	}

	@Override
	public NotificacionViewModel registrarReserva(ReservaViewModel reservaModel) {
		NotificacionViewModel notificacion = new NotificacionViewModel();
		
		try{
			Reserva dto = new Reserva();
//			dto.setCod_reserva(reservaModel.getDni());
			dto.setFecha_reserva(reservaModel.getFecha_reserva());
			dto.setTipo_reserva(reservaModel.getTipo_reserva());
			dto.setMotivo(reservaModel.getMotivo());
			dto.setHora(reservaModel.getHora());
			dto.setCantidad_personas(reservaModel.getCantidad_personas());
			dto.setEstado("Confirmado");
			dto.setComentario(reservaModel.getComentario());
			
			Cliente clienteEntity = clienteJpaRepository.findOne(reservaModel.getDni());
			if(clienteEntity == null){
				Cliente clienteDto = new Cliente();
				clienteDto.setDni(reservaModel.getDni());
				clienteDto.setNombre(reservaModel.getNombre());
				clienteDto.setAp_paterno(reservaModel.getAp_paterno());
				clienteDto.setCorreo(reservaModel.getCorreo());
				clienteDto.setTelefono(reservaModel.getTelefono());
				clienteJpaRepository.save(clienteDto);
				reservaJpaRepository.flush();
				
				Cliente clienteEnti = clienteJpaRepository.findOne(clienteDto.getDni());
				dto.setCliente(clienteEnti);
			}else{
				dto.setCliente(clienteEntity);
			}
			
			Mesa mesaenti = new Mesa();
			mesaenti.setCod_mesa(reservaModel.getCod_mesa());
			mesaenti.setDisponibilidad(false);
			mesaenti.setFecha_mesa(reservaModel.getFecha_reserva());
			mesaenti.setHora_mesa(reservaModel.getHora());
			mesaenti.setNombre_mesa(reservaModel.getNombre_mesa());
			mesaJpaRepository.save(mesaenti);
			mesaJpaRepository.flush();
			
			Mesa mesaEntity = mesaJpaRepository.findOne(reservaModel.getCod_mesa());
			dto.setMesa(mesaEntity);
			
			Local localEntity = localJpaRepository.findLocalByName(reservaModel.getNombre_local());
			dto.setLocal(localEntity);
			
			reservaJpaRepository.save(dto);
			reservaJpaRepository.flush();
			
			notificacion.setCodigo(1L);
			notificacion.setSeverity("success");
			notificacion.setSummary("Runakuna Success");
			notificacion.setDetail("Se actualizo exitosamente");
			return notificacion;
		} catch (Exception e) {
			notificacion.setCodigo(0L);
			notificacion.setSeverity("error");
			notificacion.setSummary("Runakuna Error");
			notificacion.setDetail("No es posible registrar, "+e.getMessage());
			e.printStackTrace();
		}
		return notificacion;
	}

	@Override
	public List<MesaViewModel> getDisponibilidadMesas(Long dni) {
		return reservaJdbcRepository.getDisponibilidadMesas(dni);
	}

	@Override
	public List<MesaViewModel> getMesaDisponibleByDateHour(ReservaViewModel reservaViewModel) {
		return reservaJdbcRepository.getMesaDisponibleByDateHour(reservaViewModel);
	}

	@Override
	public MesaViewModel verDisponibilidadMesa(Long cod_mesa) {
		return reservaJdbcRepository.verDisponibilidadMesa(cod_mesa);
	}
}
