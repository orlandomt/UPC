package pe.pardoschicken.reserva.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pardoschicken.reserva.dao.ReservaMapper;
import pe.pardoschicken.reserva.model.Reniec;
import pe.pardoschicken.reserva.service.ReservaService;

/**
 * Created by Orlando on 15/07/2017.
 */
@Service
@Transactional
public class ReservaServiceImpl implements ReservaService{

    @Autowired
    ReservaMapper reservaMapper;

    @Override
    public String buscarPorDni(String dni) {
        Gson gson = new GsonBuilder().serializeNulls().create();

        Reniec reniec = reservaMapper.buscarPorDni(dni);
        String json = gson.toJson(reniec);

        return json;
    }
}
