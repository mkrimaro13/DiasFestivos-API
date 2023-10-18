package apidiasfestivos.apidiasfestivos.interfaces;

import java.util.Date;
import java.util.List;

import apidiasfestivos.apidiasfestivos.entidades.FestivoDto;

public interface IFestivoServicio {

    public boolean esFestivo(Date fecha);

    public List<FestivoDto> obtenerFestivos(int año);

    public boolean esFechaValida(String strFecha);
    
}
