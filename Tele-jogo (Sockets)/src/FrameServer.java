
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class FrameServer extends JFrame {

    Dimension tamanhoTela = new Dimension(500, 400);

    Image dbImage, background;
    Graphics dbGraphics;
    
    static ServerSocket servidor;
    static ObjectOutputStream saida;
    static ObjectInputStream entrada;

    static Jogador j1 = new Jogador(15, 180, 1);
    static Jogador j2 = new Jogador(475, 180, 2);
    static BolaServer bola = new BolaServer(250, 200, j1, j2);

    public FrameServer() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        setTitle("Tele-jogo | feito por: Rafael Cancian e Lucas Heinen");
        setSize(tamanhoTela);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/icon.png")));
        addKeyListener(new Eventos());
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbGraphics = dbImage.getGraphics();
        draw(dbGraphics);
        g.drawImage(dbImage, 0, 0, null);
    }

    public void draw(Graphics g) {
        background = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/background.png"));
        g.drawImage(background, 1, 0, null);

        bola.draw(g);
        j1.draw(g);
        j2.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("Grêmio: " + bola.pontosJ1, 30, 50);
        g.drawString("Inter: " + bola.pontosJ2, 430, 50);
        
        repaint();
    }

    public class Eventos extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            j1.keyPressed(e);
            j2.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            j1.keyReleased(e);
            j2.keyReleased(e);
        }
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new FrameServer().setVisible(true);

        /*/
        Object[] opcoes = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null, "Deseja iniciar o jogo?", "Mensagem de confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if ((n == -1) || (n == 1)) {
            System.exit(0);
        }
        /*/

        bola.start();
        j1.start();
        j2.start();
    }

}
