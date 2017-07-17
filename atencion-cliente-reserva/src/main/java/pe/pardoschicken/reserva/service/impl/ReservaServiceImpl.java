package pe.pardoschicken.reserva.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pardoschicken.reserva.dao.ReservaMapper;
import pe.pardoschicken.reserva.model.Local;
import pe.pardoschicken.reserva.model.Reniec;
import pe.pardoschicken.reserva.model.Reserva;
import pe.pardoschicken.reserva.service.ReservaService;

import java.sql.Date;
import java.util.List;

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

    @Override
    public String buscarReserva(int codLocal, Date fechaInicial, Date fechaFin, String tipoReserva, String apPaterno, String nombre) {
        Gson gson = new GsonBuilder().create();
        JsonObject jsonObject = new JsonObject();

        List<Local> lsLocal = reservaMapper.buscarReserva(codLocal, fechaInicial, fechaFin, tipoReserva, apPaterno, nombre);

        for(int i=0; i<lsLocal.size(); i++){
            jsonObject.addProperty("codReserva", lsLocal.get(i).getReservas().get(i).getCodReserva());
            jsonObject.addProperty("fechaReserva", lsLocal.get(i).getReservas().get(i).getFechaReserva().toString());
            jsonObject.addProperty("horaReserva", lsLocal.get(i).getReservas().get(i).getHoras().get(i).getHoraReserva().toString());
            jsonObject.addProperty("ubicacion", lsLocal.get(i).getUbicacion());
            jsonObject.addProperty("nombre", lsLocal.get(i).getReservas().get(i).getCliente().getNombre());
            jsonObject.addProperty("tipoReserva", lsLocal.get(i).getReservas().get(i).getTipoReserva());
        }

        String json = gson.toJson(jsonObject);
        return json;
    }
}
