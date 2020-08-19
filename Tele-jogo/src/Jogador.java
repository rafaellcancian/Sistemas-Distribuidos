
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Jogador extends Thread {

    int x, y, direcaoY, id;

    Rectangle goleiro;
    
    public Jogador(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        goleiro = new Rectangle(x, y, 7, 50);
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1: {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setDirecaoY(-1);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setDirecaoY(+1);
                }
                break;
            }
            case 2: {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setDirecaoY(-1);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setDirecaoY(+1);
                }
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "ID do jogador não encontrado.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1: {
                if (e.getKeyCode() == e.VK_W) {
                    setDirecaoY(0);
                }
                if (e.getKeyCode() == e.VK_S) {
                    setDirecaoY(0);
                }
                break;
            }
            case 2: {
                if (e.getKeyCode() == e.VK_UP) {
                    setDirecaoY(0);
                }
                if (e.getKeyCode() == e.VK_DOWN) {
                    setDirecaoY(0);
                }
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "ID do jogador não encontrado.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }

    public void setDirecaoY(int yDir) {
        direcaoY = yDir;
    }

    public void mover() {
        goleiro.y = goleiro.y + direcaoY;
        if (goleiro.y <= 35) {
            goleiro.y = 35;
        }
        if (goleiro.y >= 340) {
            goleiro.y = 340;
        }
    }

    public void draw(Graphics g) {
        switch (id) {
            case 1: {
                g.setColor(Color.BLUE);
                g.fillRect(goleiro.x, goleiro.y, goleiro.width, goleiro.height);
                break;
            }
            case 2: {
                g.setColor(Color.RED);
                g.fillRect(goleiro.x, goleiro.y, goleiro.width, goleiro.height);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "ID do jogador não encontrado.", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                mover();
                Thread.sleep(5);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
