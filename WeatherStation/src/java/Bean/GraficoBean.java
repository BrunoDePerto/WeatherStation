package Bean;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
import RegraNegocio.GraficoRN;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;

@ManagedBean
public class GraficoBean implements Serializable {

    private GraficoRN graficoRN;
    private LineChartModel lineModel2;

    @PostConstruct
    public void init() {
        graficoRN = new GraficoRN();
        createLineModels();
    }

    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    private void createLineModels() {
        lineModel2 = initCategoryModel();
        lineModel2.setTitle("Histórico das últimas 24 horas");
        lineModel2.setLegendPosition("i");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Horas"));
        lineModel2.setAnimate(true);
        Axis yAxis = lineModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Variação");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();
        model.addSeries(graficoRN.getTemperatura());
        model.addSeries(graficoRN.getLuminosidade());
        model.addSeries(graficoRN.getUmidade());
        return model;
    }
}
