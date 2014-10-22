package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;
import org.primefaces.model.chart.ChartSeries;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class GraficoRN {

    private final Supervisorio supervisorio;
    private final ChartSeries temperatura;
    private final ChartSeries umidade;
    private final ChartSeries luminosidade;
    //Formatacao pacote Arduino
    private final int horaIni = 0, horaFim = 2,
            umidIni = 4, umidFim = 8,
            tempIni = 9, tempFim = 15,
            lumiIni = 16, lumiFim = 21,
            pctComp = 22;

    public GraficoRN() {
        supervisorio = Context.getSupervisorio();
        temperatura = new ChartSeries("Temperatura");
        umidade = new ChartSeries("Umidade");
        luminosidade = new ChartSeries("Luminosidade");
        atualizaValores();
    }

    private void atualizaValores() {
        for (int i = 0; i < 23; i++) {
            if (supervisorio.getHistorico() != null
                    && !supervisorio.getHistorico().substring(horaIni + (pctComp * i), horaFim + (pctComp * i)).equals("XX")) {
                temperatura.set(supervisorio.getHistorico().substring(horaIni + (pctComp * i), horaFim + (pctComp * i)),
                        Double.parseDouble(supervisorio.getHistorico().substring(tempIni + (pctComp * i), tempFim + (pctComp * i))));
                umidade.set(supervisorio.getHistorico().substring(horaIni + (pctComp * i), horaFim + (pctComp * i)),
                        Double.parseDouble(supervisorio.getHistorico().substring(umidIni + (pctComp * i), umidFim + (pctComp * i))));
                luminosidade.set(supervisorio.getHistorico().substring(horaIni + (pctComp * i), horaFim + (pctComp * i)),
                        Double.parseDouble(supervisorio.getHistorico().substring(lumiIni + (pctComp * i), lumiFim + (pctComp * i))));
            }
        }
    }

    public ChartSeries getTemperatura() {
        return temperatura;
    }

    public ChartSeries getUmidade() {
        return umidade;
    }

    public ChartSeries getLuminosidade() {
        return luminosidade;
    }
}
