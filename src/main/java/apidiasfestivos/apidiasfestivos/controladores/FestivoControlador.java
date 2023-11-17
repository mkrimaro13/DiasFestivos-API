package apidiasfestivos.apidiasfestivos.controladores;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apidiasfestivos.apidiasfestivos.entidades.FestivoDto;
import apidiasfestivos.apidiasfestivos.interfaces.IFestivoServicio;

@RestController // Indica que es el controlador
@RequestMapping("/festivos") // Es la ruta de como se accede por la web
public class FestivoControlador {
    @Autowired
    private IFestivoServicio servicio;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificarFestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        if (servicio.esFechaValida(String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia))) {
            Date fecha = new Date(año - 1990, mes - 1, dia);
            return servicio.esFestivo(fecha) ? "Es festivo" : "No es festivo";
        } else {
            return "Fecha no válida";
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/obtener/{año}", method = RequestMethod.GET)
    public List<FestivoDto> obtener(@PathVariable int año) {
        return servicio.obtenerFestivos(año);
    }

}
