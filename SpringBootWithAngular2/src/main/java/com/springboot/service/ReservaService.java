package com.springboot.service;

import java.util.List;

import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;

public interface ReservaService {

	List<ReservaResult> searchReserva(ReservaFilter reservaFilter);
}
