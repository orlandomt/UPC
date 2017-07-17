package pe.pardoschicken.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.pardoschicken.reserva.model.Cliente;
import pe.pardoschicken.reserva.model.Reserva;
import pe.pardoschicken.reserva.service.ReservaService;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Orlando on 15/07/2017.
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buscardni", method = RequestMethod.POST)
    public @ResponseBody String buscarPorDni(@RequestParam("dni") String dni) throws Exception{
        return reservaService.buscarPorDni(dni);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/buscareserva", method = RequestMethod.POST)
    public @ResponseBody String buscarReserva(@RequestParam("codLocal") int codLocal, @RequestParam("fechaInicial") Date fechaInicial,
                                              @RequestParam("fechaFin") Date fechaFin, @RequestParam("tipoReserva") String tipoReserva,
                                              @RequestParam("apPaterno") String apPaterno, @RequestParam("nombre") String nombre) throws Exception{
        return reservaService.buscarReserva(codLocal, fechaInicial, fechaFin, tipoReserva, apPaterno, nombre);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/nuevareserva", method = RequestMethod.POST)
    public @ResponseBody String nuevaReserva(@RequestBody String json, @RequestParam("ubicacion") String ubicacion,
                                             @RequestParam("mesa") int numMesa, @RequestParam("hora") Time horaReserva) throws Exception{
        reservaService.nuevaReserva(json, ubicacion, numMesa, horaReserva);
        return "Usuario Creado";
    }
}