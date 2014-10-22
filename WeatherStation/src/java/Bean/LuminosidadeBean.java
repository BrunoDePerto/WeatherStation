package Bean;

import RegraNegocio.LuminosidadeRN;
import javax.faces.bean.ManagedBean;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
@ManagedBean
public class LuminosidadeBean {

    private final LuminosidadeRN luminosidadeRN;
    private double luminosidade;
    private String imagem;

    public LuminosidadeBean() {
        this.luminosidadeRN = new LuminosidadeRN();
    }

    public double getLuminosidade() {
        this.setLuminosidade(luminosidadeRN.getLuminosidade());
        return luminosidade;
    }

    public void setLuminosidade(double luminosidade) {
        this.luminosidade = luminosidade;
    }

    public String getImagem() {
        if (this.getLuminosidade() >= 60) {
            this.setImagem("Imagens/dia-claro.PNG");
        }
        if (this.getLuminosidade() >= 40 && this.getLuminosidade() < 60) {
            this.setImagem("Imagens/dia-nublado");
        }
        if (this.getLuminosidade() < 40) {
            this.setImagem("Imagens/noite.PNG");
        }
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
