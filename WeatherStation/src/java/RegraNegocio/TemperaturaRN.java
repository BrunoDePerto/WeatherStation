package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class TemperaturaRN {

    private final Supervisorio supervisorio;
    private double temperatura;

    public TemperaturaRN() {
        supervisorio = Context.getSupervisorio();
    }

    public double getTemperatura() {
        temperatura = supervisorio.getTemperatura();
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    
}
