package Bean;

import RegraNegocio.VentoRN;
import javax.faces.bean.ManagedBean;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
@ManagedBean
public class VentoBean {
    
    private final VentoRN ventoRN;
    private double vento;
    private String imagem;
    
    public VentoBean(){
        this.ventoRN = new VentoRN();
    }

    public double getVento() {
        this.setVento(ventoRN.getVento());
        return vento;
    }

    public void setVento(double vento) {
        this.vento = vento;
    }

    public String getImagem() {
        if(this.getVento() <= 25)
            this.setImagem("Imagens/vento-fraco.PNG");
        if(this.getVento() > 25 && this.getVento() <= 75)
            this.setImagem("Imagens/vento-medio.PNG");
        if(this.getVento() > 75)
            this.setImagem("Imagens/vento-forte.PNG");
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
