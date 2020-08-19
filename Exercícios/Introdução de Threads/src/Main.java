
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        Thread t1, t2, t3;
        
        t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Rafael");
                }
            }
        };
        t1.start();
        JOptionPane.showMessageDialog(null, t1.getState());
        
        new Thread() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("UFN");
                }
            }
        }.start();
        
        new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Zambinho");
                }
            }
        }.start();
    }
}
