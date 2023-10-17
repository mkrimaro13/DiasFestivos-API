package apidiasfestivos.apidiasfestivos.interfaces;

import java.util.Date;
import java.util.List;

public interface IFestivoServicio {

    public boolean esFestivo(Date fecha);

    public List<Date> obtenerFestivos(int año);

    public boolean esFechaValida(String strFecha);
    
}
