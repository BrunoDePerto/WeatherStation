package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class VentoRN {
    
    private final Supervisorio supervisorio;
    private double vento;
    
    public VentoRN(){
        supervisorio = Context.getSupervisorio();
    }

    public double getVento() {
        vento = supervisorio.getVento();
        return vento;
    }
    
    public void setVento(double vento){
        this.vento = vento;
    }
    
}
