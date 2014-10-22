package Bean;

import RegraNegocio.MapaRN;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
@ManagedBean
@ViewScoped
public class MapaBean implements Serializable {

    private MapModel simpleModel; //Implementação do gMap
    private MapaRN mapaRN;
    private String localizacao;
    private Marker marker;

    @PostConstruct
    public void init() {
        this.simpleModel = new DefaultMapModel();
        this.mapaRN = new MapaRN();

        //Shared coordinates
        LatLng coord1 = new LatLng(mapaRN.getLatitude(), mapaRN.getLongitude());

        //Basic marker
        this.simpleModel.addOverlay(new Marker(coord1, "WeatherStation"));
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public String getLocalizacao() {
        this.localizacao = String.valueOf(mapaRN.getLatitude());
        this.localizacao += ",";
        this.localizacao += String.valueOf(mapaRN.getLongitude());
        return localizacao;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estação selecionada", marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }
}
