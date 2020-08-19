
package view;

import model.IChat;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Cancian e Lucas Heinen
 */

public class Cliente extends javax.swing.JFrame {

    ArrayList<String> historicoMensagens;
    IChat chat;

    public Cliente() {
        initComponents();
        setLocationRelativeTo(null);
        historicoMensagens = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextEndereco = new javax.swing.JTextField();
        jTextPorta = new javax.swing.JTextField();
        jTextUsuario = new javax.swing.JTextField();
        jButtonConectar = new javax.swing.JButton();
        jTextStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jTextMensagem = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat RMI - Cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextEndereco.setBackground(new java.awt.Color(240, 240, 240));
        jTextEndereco.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Endereço IP do servidor:"));

        jTextPorta.setEditable(false);
        jTextPorta.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextPorta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPorta.setText("1099");
        jTextPorta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Porta:"));

        jTextUsuario.setBackground(new java.awt.Color(240, 240, 240));
        jTextUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Usuário:"));

        jButtonConectar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonConectar.setText("CONECTAR");
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConectarActionPerformed(evt);
            }
        });

        jTextStatus.setEditable(false);
        jTextStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextStatus.setForeground(new java.awt.Color(255, 0, 0));
        jTextStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextStatus.setText("DESCONECTADO");
        jTextStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Status do cliente:"));

        jTextAreaChat.setEditable(false);
        jTextAreaChat.setColumns(20);
        jTextAreaChat.setLineWrap(true);
        jTextAreaChat.setRows(5);
        jTextAreaChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextAreaChat);

        jTextMensagem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextMensagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextMensagem.setEnabled(false);
        jTextMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextMensagemKeyPressed(evt);
            }
        });

        jButtonEnviar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonEnviar.setText("ENVIAR");
        jButtonEnviar.setEnabled(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addComponent(jTextStatus)
                    .addComponent(jButtonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonConectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextMensagem)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConectarActionPerformed
        if (verificarErros() == false) {
            if (iniciarConexao() == true) {
                jButtonConectar.setEnabled(false);
                jTextEndereco.setEditable(false);
                jTextUsuario.setEditable(false);
                jTextMensagem.setEnabled(true);
                jButtonEnviar.setEnabled(true);
                jTextStatus.setText("CONECTADO");
                jTextStatus.setForeground(Color.GREEN);
                jTextMensagem.requestFocus();
                iniciarThreadAtualizarChat();
            }
        }
    }//GEN-LAST:event_jButtonConectarActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        enviarMensagem();
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMensagemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarMensagem();
        }
    }//GEN-LAST:event_jTextMensagemKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (jButtonEnviar.isEnabled()) {
            try {
                chat.receberMensagem(jTextUsuario.getText() + " deixou a sala.");
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    public boolean verificarErros() {
        boolean erro = false;

        if (jTextEndereco.getText().isEmpty() || jTextUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.", "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
            erro = true;
        }

        return erro;
    }

    public boolean iniciarConexao() {
        try {
            chat = (IChat) Naming.lookup("rmi://" + jTextEndereco.getText() + "/Chat");
            for (int i = 0; i < chat.getHistoricoMensagens().size(); i++) {
                String mensagens = (String) chat.getHistoricoMensagens().get(i);
                jTextAreaChat.append(mensagens + "\n");
                historicoMensagens.add(mensagens);
            }
            chat.receberMensagem(jTextUsuario.getText() + " juntou-se a sala.");
            return true;
        } catch (MalformedURLException | NotBoundException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void enviarMensagem() {
        if (!jTextMensagem.getText().isEmpty()) {
            try {
                chat.receberMensagem("[" + jTextUsuario.getText() + "]: " + jTextMensagem.getText());
                jTextMensagem.setText("");
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escreva alguma mensagem para enviar.", "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void iniciarThreadAtualizarChat() {
        Thread atualizarChat = new Thread() {
            @Override
            public void run() {
                String mensagem;
                int difMensagens;
                while (true) {
                    try {
                        if (chat.getHistoricoMensagens().size() != historicoMensagens.size()) {
                            difMensagens = chat.getHistoricoMensagens().size() - historicoMensagens.size();
                            mensagem = (String) chat.getHistoricoMensagens().get(chat.getHistoricoMensagens().size() - difMensagens);
                            jTextAreaChat.append(mensagem + "\n");
                            historicoMensagens.add(mensagem);
                        }
                        Thread.sleep(500);
                    } catch (RemoteException | InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "ERRO: " + ex, "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        atualizarChat.start();
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaChat;
    private javax.swing.JTextField jTextEndereco;
    private javax.swing.JTextField jTextMensagem;
    private javax.swing.JTextField jTextPorta;
    private javax.swing.JTextField jTextStatus;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
