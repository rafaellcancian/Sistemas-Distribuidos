
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.JOptionPane;

public class Bola extends Thread {

    int x, y, direcaoX, direcaoY;
    int pontosJ1, pontosJ2;

    Jogador j1, j2;
    Rectangle bola;

    public Bola(int x, int y, Jogador j1, Jogador j2) {
        this.j1 = j1;
        this.j2 = j2;

        pontosJ1 = 0;
        pontosJ2 = 0;

        this.x = x;
        this.y = y;

        Random r = new Random();
        int randomXDir = r.nextInt(2);

        if (randomXDir == 0) {
            randomXDir = -1;
        } else {
            randomXDir = 1;
        }
        setDirecaoX(randomXDir);

        int randomYDir = r.nextInt(2);
        if (randomYDir == 0) {
            randomYDir = -1;
        } else {
            randomYDir = 1;
        }
        setDirecaoY(randomYDir);

        bola = new Rectangle(this.x, this.y, 15, 15);
    }

    public void setDirecaoX(int xDir) {
        direcaoX = xDir;
    }

    public void setDirecaoY(int yDir) {
        direcaoY = yDir;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(bola.x, bola.y, bola.width, bola.height);
    }

    public void colisao() {
        if (bola.intersects(j1.goleiro)) {
            setDirecaoX(+1);
        }
        if (bola.intersects(j2.goleiro)) {
            setDirecaoX(-1);
        }
    }

    public void mover() {
        colisao();
        bola.x = bola.x + direcaoX;
        bola.y = bola.y + direcaoY;

        if (bola.x <= 5) {
            setDirecaoX(+1);
            pontosJ2++;
        }
        if (bola.x >= 480) {
            setDirecaoX(-1);
            pontosJ1++;
        }

        if (bola.y <= 30) {
            setDirecaoY(+1);
        }
        if (bola.y >= 380) {
            setDirecaoY(-1);
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
