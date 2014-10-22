package Bean;

import RegraNegocio.TemperaturaRN;
import javax.faces.bean.ManagedBean;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
@ManagedBean
public class TemperaturaBean {

    private final TemperaturaRN temperaturaRN;
    private double temperatura;
    private String imagem;

    public TemperaturaBean() {
        this.temperaturaRN = new TemperaturaRN();
    }

    public double getTemperatura() {
        this.setTemperatura(temperaturaRN.getTemperatura());
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem() {
        if(this.getTemperatura() <= 5)
            this.setImagem("Imagens/temperatura-super-baixa.PNG");
        if(this.getTemperatura() >5 && this.getTemperatura() <=20)
            this.setImagem("Imagens/temperatura-baixa.PNG");
        if(this.getTemperatura() > 20 & this.getTemperatura() <= 30)
            this.setImagem("Imagens/temperatura-alta.PNG");
        if(this.getTemperatura() > 30)
            this.setImagem("Imagens/temperatura-super-alta.PNG");
        return imagem;
    }

}
