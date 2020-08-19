
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import javax.swing.JOptionPane;

public class BolaClient extends Thread implements Serializable {

    int x, y;
    int pontosJ1, pontosJ2;

    String host;
    int portNumber;
    
    Componente c;
    Socket socket_jogador1;
    ObjectOutputStream saida;
    ObjectInputStream entrada;

    Jogador j1, j2;
    Rectangle bola;

    public BolaClient(int x, int y) {
        this.y = y;

        bola = new Rectangle(this.x, this.y, 15, 15);

        new Thread() {
            @Override
            public void run() {
                try {
                    host = JOptionPane.showInputDialog(null, "Informe o IP do servidor:");
                    portNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a porta:"));
                    socket_jogador1 = new Socket(host, portNumber);

                    saida = new ObjectOutputStream(socket_jogador1.getOutputStream());
                    entrada = new ObjectInputStream(socket_jogador1.getInputStream());
                    while (true) {
                        c = (Componente) entrada.readObject();
                        bola.x = c.getX();
                        bola.y = c.getY();
                    }
                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }.start();
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(bola.x, bola.y, bola.width, bola.height);
    }

}
