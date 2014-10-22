package Comunicacao;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author WeatherStation
 * @since 11/05/2014
 */
public class Servico implements Runnable, Serializable {

    private Socket cliente;
    private String resposta = "";

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Porta 6000 aberta!");
            resposta = "Porta 6000 aberta!";
            cliente = serverSocket.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            resposta = ("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
            buscarResposta();
        } catch (IOException ex) {
            System.out.println("Porta já aberta" + ex);
        }
    }

    public void buscarResposta() {
        Scanner s;
        try {
            if (cliente != null) {
                s = new Scanner(cliente.getInputStream());
                while (s.hasNextLine()) {
                    resposta = s.nextLine();
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void enviarComando(String comando) {
        PrintStream saida;
        try {
            saida = new PrintStream(cliente.getOutputStream());
            saida.print(comando);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public String getResposta() {
        return resposta;
    }

    public Socket getCliente() {
        return cliente;
    }

}
