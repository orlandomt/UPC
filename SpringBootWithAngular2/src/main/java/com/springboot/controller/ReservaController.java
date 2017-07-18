package com.springboot.controller;

import com.springboot.model.ClienteViewModel;
import com.springboot.model.MesaViewModel;
import com.springboot.model.NotificacionViewModel;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;
import com.springboot.service.ReservaService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	@RequestMapping(value = "/buscarReserva", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<ReservaResult>> buscarReserva(@RequestBody ReservaFilter reservaFilter) throws Exception{
        
    	List<ReservaResult> result;
    	result = reservaService.searchReserva(reservaFilter);
    	if(result == null)
    		result = new ArrayList<>();
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/reservaByCode", method = RequestMethod.POST)
	public @ResponseBody ReservaViewModel reservaByCode(@RequestBody Long code){
		ReservaViewModel result = new ReservaViewModel();
		result = reservaService.getReservaByCode(code);
		if(result == null)
			result = new ReservaViewModel();
		return result;
	}
	
	@RequestMapping(value = "/actualizarReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel actualizarReserva(@RequestBody ReservaViewModel reservaModel) {
		
		NotificacionViewModel dto = reservaService.actualizarReserva(reservaModel);
		return dto;
	}
	
	@RequestMapping(value = "/anularReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel anularReserva(@RequestBody ReservaViewModel reservaModel) {
		
		NotificacionViewModel dto = reservaService.anularReserva(reservaModel);
		return dto;
	}
	
	@RequestMapping(value = "/obtenerInformacionClienteByDNI", method = RequestMethod.POST)
	public @ResponseBody ClienteViewModel obtenerInformacionClienteByDNI(@RequestBody Long dni) {
		ClienteViewModel dto = reservaService.obtenerInformacionClienteByDNI(dni);
		if(dto == null){
			dto = new ClienteViewModel();
		}
		return dto;
	}
	
	@RequestMapping(value = "/obtenerUltimaReservaClienteByDNI", method = RequestMethod.POST)
	public @ResponseBody MesaViewModel obtenerUltimaReservaClienteByDNI(@RequestBody Long dni) {
		MesaViewModel dto = reservaService.obtenerUltimaReservaClienteByDNI(dni);
		if(dto == null){
			dto = new MesaViewModel();
		}
		return dto;
	}
	
	@RequestMapping(value = "/registrarReserva", method = RequestMethod.POST)
	public @ResponseBody NotificacionViewModel registrarPermisoEmpleado(@RequestBody ReservaViewModel reservaViewModel) {
		
		NotificacionViewModel dto = reservaService.registrarReserva(reservaViewModel);
		return dto;
	}

}
