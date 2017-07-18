package com.springboot.service;

import java.util.List;

import com.springboot.model.ClienteViewModel;
import com.springboot.model.MesaViewModel;
import com.springboot.model.NotificacionViewModel;
import com.springboot.model.ReservaFilter;
import com.springboot.model.ReservaResult;
import com.springboot.model.ReservaViewModel;

public interface ReservaService {

	List<ReservaResult> searchReserva(ReservaFilter reservaFilter);

	ReservaViewModel getReservaByCode(Long code);

	NotificacionViewModel actualizarReserva(ReservaViewModel reservaModel);

	NotificacionViewModel anularReserva(ReservaViewModel reservaModel);

	ClienteViewModel obtenerInformacionClienteByDNI(Long dni);

	MesaViewModel obtenerUltimaReservaClienteByDNI(Long dni);

	NotificacionViewModel registrarReserva(ReservaViewModel reservaViewModel);
}
