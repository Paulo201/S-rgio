package Views;

import Controllers.ControllerLogin;
import Models.Configuracao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author willi
 */
public class FrmLogin extends javax.swing.JInternalFrame {
    
    private Configuracao model;
    private ControllerLogin controller;
    
    
    public FrmLogin() {
        initComponents();
    }

    FrmLogin(Configuracao model) {
        this();
        this.model = model;
        this.controller = new ControllerLogin(this, model);
    }
    
    public void mensagem(String mensagem) {
        if (mensagem != null) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
    }

    public boolean validaCampos() {
        if (this.login.getText().equals("")) {
            this.mensagem("Informe o usuário.");
            this.login.requestFocus();
            return false;
        }

        if (this.senha.getText().equals("")) {
            this.mensagem("Informe a senha.");
            this.senha.requestFocus();
            return false;
        }

        return true;
    }

    public String getUsuario() {
        return this.login.getText();
    }

    public String getSenha() {
        return this.senha.getText();
    }

    public void fechaTela() {
        this.dispose();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        txtLogin = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        login = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Autenticação");
        getContentPane().setLayout(null);

        txtLogin.setText("Usuario:");
        getContentPane().add(txtLogin);
        txtLogin.setBounds(150, 60, 50, 14);

        txtSenha.setText("Senha:");
        getContentPane().add(txtSenha);
        txtSenha.setBounds(150, 100, 34, 14);
        getContentPane().add(login);
        login.setBounds(200, 60, 130, 20);
        getContentPane().add(senha);
        senha.setBounds(200, 100, 130, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\login 1 (1).png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(28, 22, 128, 128);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Login");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 20, 38, 17);

        btnLogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\accept.png")); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(250, 140, 83, 25);

        btnSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\cancel.png")); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(150, 140, 71, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField login;
    private java.awt.Panel panel1;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtSenha;
    // End of variables declaration//GEN-END:variables

}
