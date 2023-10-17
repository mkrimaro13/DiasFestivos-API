package apidiasfestivos.apidiasfestivos.controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apidiasfestivos.apidiasfestivos.interfaces.IFestivoServicio;

@RestController // Indica que es el controlador
@RequestMapping("/festivos") // Es la ruta de como se accede por la web
public class FestivoControlador {
    @Autowired
    private IFestivoServicio servicio;

    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificarFestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        try{
            Date fecha = new Date(año-1990, mes - 1, dia);
            return servicio.esFestivo(fecha) ? "Es festivo" : "No es festivo";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
}
