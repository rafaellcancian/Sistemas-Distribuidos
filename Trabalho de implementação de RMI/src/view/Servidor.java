
package view;

import controller.Chat;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Cancian e Lucas Heinen
 */

public class Servidor extends javax.swing.JFrame {

    InetAddress inetAddress;
    String HOST_URL;

    public Servidor() {
        initComponents();
        setLocationRelativeTo(null);

        try {
            inetAddress = InetAddress.getLocalHost();
            HOST_URL = "rmi://" + inetAddress.getHostAddress() + "/Chat";
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextEndereco = new javax.swing.JTextField();
        jTextPorta = new javax.swing.JTextField();
        jTextStatus = new javax.swing.JTextField();
        jButtonParar = new javax.swing.JButton();
        jButtonIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat RMI - Servidor");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextEndereco.setEditable(false);
        jTextEndereco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextEndereco.setText("-");
        jTextEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Endereço IP:"));

        jTextPorta.setEditable(false);
        jTextPorta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextPorta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPorta.setText("-");
        jTextPorta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Porta:"));

        jTextStatus.setEditable(false);
        jTextStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextStatus.setForeground(new java.awt.Color(255, 0, 0));
        jTextStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextStatus.setText("OFFLINE");
        jTextStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Status do servidor:"));

        jButtonParar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonParar.setText("PARAR");
        jButtonParar.setEnabled(false);
        jButtonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPararActionPerformed(evt);
            }
        });

        jButtonIniciar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextEndereco)
                    .addComponent(jTextPorta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jTextStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonParar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonParar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        if (iniciarServidor() == true) {
            jTextEndereco.setText(inetAddress.getHostAddress());
            jTextPorta.setText(String.valueOf(Registry.REGISTRY_PORT));
            jTextStatus.setForeground(Color.GREEN);
            jTextStatus.setText("EM EXECUÇÃO...");
            jButtonIniciar.setEnabled(false);
            jButtonParar.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPararActionPerformed
        pararServidor();
    }//GEN-LAST:event_jButtonPararActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (jButtonParar.isEnabled() == true) {
            pararServidor();
        }
    }//GEN-LAST:event_formWindowClosing

    public boolean iniciarServidor() {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Chat remoteChatObject = new Chat();
            Naming.bind(HOST_URL, remoteChatObject);
            return true;
        } catch (MalformedURLException | AlreadyBoundException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void pararServidor() {
        Object[] opcoes = {"Sim", "Não"};
        int n = JOptionPane.showOptionDialog(null, "Tem certeza que deseja parar o servidor?", "Mensagem de confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (n == 0) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonParar;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextPorta;
    private javax.swing.JTextField jTextStatus;
    // End of variables declaration//GEN-END:variables
}
