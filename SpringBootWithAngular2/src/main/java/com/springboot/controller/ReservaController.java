package com.springboot.controller;

import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
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

}
