package Comunicacao;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class Supervisorio implements Serializable{

    private final Servico servico;
    private double latitude;
    private double longitude;
    private double temperatura;
    private double umidade;
    private double luminosidade;
    private double vento;
    private String historico;

    public Supervisorio() {
        //Default valors
        servico = Context.getServico();
        if (servico.getCliente() == null) {
            this.threadCliente(1000, 2000);
        }
    }

    public void threadCliente(int delay, int intervalo) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (servico.getCliente() != null) {
                    solicitaDados();
                    this.cancel();
                }
            }
        }, delay, intervalo);
    }

    public void solicitaDados() {
        solicitaDadosThread(10000, 70000, "GPSLA");
        solicitaDadosThread(20000, 70000, "GPSLO");
        solicitaDadosThread(30000, 70000, "TEMPE");
        solicitaDadosThread(40000, 70000, "LUMIN");
        solicitaDadosThread(50000, 70000, "UMIDA");
        solicitaDadosThread(60000, 70000, "VENTO");
        solicitaDadosThread(70000, 70000, "HISTO");
        tratarDadosThread(5000, 10000);
    }

    public void solicitaDadosThread(int delay, int intervalo, String sensor) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                servico.enviarComando(sensor);
            }
        }, delay, intervalo);
    }

    private void tratarDadosThread(int delay, int intervalo) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                tratarDados();
            }
        }, delay, intervalo);
    }

    private void tratarDados() {
        String resposta = servico.getResposta();
        System.out.println(resposta);
        if (resposta.substring(0, 2).equals(":#")) {
            switch (resposta.substring(2, 4)) {
                case "LA":
                    this.setLatitude(Double.parseDouble(resposta.substring(4, 14)));
                    break;
                case "LO":
                    this.setLongitude(Double.parseDouble(resposta.substring(4, 15)));
                    break;
                case "TP":
                    this.setTemperatura(Double.parseDouble(resposta.substring(4, 10)));
                    break;
                case "LU":
                    this.setLuminosidade(Double.parseDouble(resposta.substring(4, 9)));
                    break;
                case "UM":
                    this.setUmidade(Double.parseDouble(resposta.substring(4, 9)));
                    break;
                case "VT":
                    this.setVento(Double.parseDouble(resposta.substring(4, 9)));
                    break;
                case "HI":
                    this.setHistorico(resposta.substring(4, 554));
                    break;
                default:
                    System.out.println("Pacote incorreto");
            }
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getLuminosidade() {
        return luminosidade;
    }

    public void setLuminosidade(double luminosidade) {
        this.luminosidade = luminosidade;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public double getVento() {
        return vento;
    }
    
    public void setVento(double vento){
        this.vento = vento;
    }
}
