package Comunicacao;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class Context {

    private static Servico servico;
    private static Supervisorio supervisorio;

    public static Servico getServico() {
        if (servico == null) {
            servico = new Servico();
            new Thread(servico).start();
        }
        return servico;
    }
    
    public static Supervisorio getSupervisorio(){
        if(supervisorio == null){
            supervisorio = new Supervisorio();
        }
        return supervisorio;
    }
}
