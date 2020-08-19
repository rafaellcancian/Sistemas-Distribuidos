
package controller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ComunicadorUDP {

    public DatagramPacket montaMensagem(String mensagem, String ip, int porta) {
        try {
            byte[] buffer = mensagem.getBytes();
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), porta);
            return pacote;
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void enviaMensagem(DatagramSocket s, DatagramPacket pacote) {
        try {
            s.send(pacote);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DatagramPacket recebeMensagem(DatagramSocket s) {
        try {
            DatagramPacket pacote = new DatagramPacket(new byte[512], 512);
            s.receive(pacote);
            return pacote;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
