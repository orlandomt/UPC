package pe.pardoschicken.reserva.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.pardoschicken.reserva.dao.ReservaMapper;
import pe.pardoschicken.reserva.model.*;
import pe.pardoschicken.reserva.service.ReservaService;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public void nuevaReserva(String json, String ubicacion, int numMesa, Time horaReserva) throws ParseException {
        Gson gson = new GsonBuilder().create();

        Map<String,String> jsonmap = new HashMap<String,String>();
        jsonmap = gson.fromJson(json, jsonmap.getClass());

        //Convertir String to Date
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = format1.parse(jsonmap.get("fechaReserva"));
        java.util.Date date2 = format1.parse(jsonmap.get("fecha"));

        java.sql.Date fechaReserva = new Date(date1.getTime());
        java.sql.Date fecha = new Date(date2.getTime());

        //Sumar 2 horas
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(horaReserva.getTime());
        calendar.add(calendar.HOUR, 2);

        Time finalAprox = new Time(calendar.getTimeInMillis());

        //Obtengo ID de local para guardar en Reserva
        Local local = reservaMapper.buscarLocal(ubicacion);

        //Obtengo ID de mesa para guardar en Hora
        Mesa mesa = reservaMapper.buscarMesa(numMesa, local.getCodLocal());

        //Guardo cliente
        reservaMapper.nuevoCliente(jsonmap.get("dni"), jsonmap.get("nombre"), jsonmap.get("apPaterno"), jsonmap.get("apMaterno"),
                jsonmap.get("direccion"), jsonmap.get("telefono"), jsonmap.get("correo"), jsonmap.get("dni"));

        //Guardo reserva
        reservaMapper.nuevaReserva(fechaReserva, jsonmap.get("tipoReserva"), jsonmap.get("motivo"), fecha,
                jsonmap.get("dni"), local.getCodLocal());

        //Guardo hora
        reservaMapper.nuevaHora(2, mesa.getIdMesa(), horaReserva, finalAprox);
    }
}
