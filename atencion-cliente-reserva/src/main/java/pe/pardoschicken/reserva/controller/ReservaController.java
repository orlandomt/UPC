package pe.pardoschicken.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.pardoschicken.reserva.service.ReservaService;

/**
 * Created by Orlando on 15/07/2017.
 */
@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @RequestMapping(value = "/buscardni", method = RequestMethod.POST)
    public @ResponseBody String buscarPorDni(@RequestParam("dni") String dni) throws Exception{
        return reservaService.buscarPorDni(dni);
    }
}
