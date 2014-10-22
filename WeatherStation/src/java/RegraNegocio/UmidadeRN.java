package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class UmidadeRN {

    private final Supervisorio supervisorio;
    private double umidade;

    public UmidadeRN() {
        supervisorio = Context.getSupervisorio();
    }

    public double getUmidade() {
        umidade = supervisorio.getUmidade();
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

}
