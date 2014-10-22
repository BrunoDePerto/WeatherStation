package RegraNegocio;

import Comunicacao.Context;
import Comunicacao.Supervisorio;
import java.io.Serializable;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class MapaRN implements Serializable{

    private final Supervisorio supervisorio;
    private double latitude, longitude;

    public MapaRN() {
        supervisorio = Context.getSupervisorio();
    }

    public double getLatitude() {
        latitude = supervisorio.getLatitude();
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        longitude = supervisorio.getLongitude();
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
