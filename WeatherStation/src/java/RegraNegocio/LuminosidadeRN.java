
package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class LuminosidadeRN {
    
    private final Supervisorio supervisorio;
    private double luminosidade;

    public LuminosidadeRN() {
        supervisorio = Context.getSupervisorio();
    }

    public double getLuminosidade() {
        luminosidade = supervisorio.getLuminosidade();
        return luminosidade;
    }

    public void setLuminosidade(double luminosidade) {
        this.luminosidade = luminosidade;
    }
    
    
}
