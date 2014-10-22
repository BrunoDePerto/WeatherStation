package Bean;

import RegraNegocio.UmidadeRN;
import javax.faces.bean.ManagedBean;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
@ManagedBean
public class UmidadeBean {

    private final UmidadeRN umidadeRN;
    private double umidade;
    private String imagem;

    public UmidadeBean() {
        this.umidadeRN = new UmidadeRN();
    }

    public double getUmidade() {
        this.setUmidade(umidadeRN.getUmidade());
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem() {
        if (this.getUmidade() > 50) {
            this.setImagem("Imagens/umidade-alta.PNG");
        }
        if (this.getUmidade() < 50) {
            this.setImagem("Imagens/umidade.PNG");
        }
        return imagem;
    }

}
