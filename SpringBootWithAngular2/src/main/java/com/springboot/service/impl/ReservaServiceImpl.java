package com.springboot.service.impl;

import com.springboot.repository.jdbc.ReservaJdbcRepository;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.service.ReservaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaJdbcRepository reservaJdbcRepository;

	@Override
	public List<ReservaResult> searchReserva(ReservaFilter reservaFilter) {
		return reservaJdbcRepository.searchReserva(reservaFilter);
	}
}
