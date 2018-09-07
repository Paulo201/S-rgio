package Views;

import Controllers.ControllerFuncionarioCadastrar;
import Models.Configuracao;
import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class FrmFuncionarioCadastro extends javax.swing.JInternalFrame {

    private Configuracao model;
    private ControllerFuncionarioCadastrar controller;
    private FrmTelaPrincipal principal;
    
    /**
     * Creates new form FrmFuncionario
     */
    public FrmFuncionarioCadastro() {
        initComponents();
    }
    
    public FrmFuncionarioCadastro(Configuracao model, FrmTelaPrincipal principal) {
        this();
        this.model = model;
        this.controller = new ControllerFuncionarioCadastrar(this, model);
        this.principal = principal;
    }

    public void mostraMensagem(String mensagem) {
        if (mensagem != null) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
    }
    
    public boolean validaCampos() {
        if (this.nome.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome do usuário.");
            this.nome.requestFocus();
            return false;
        }
        
        if (this.contato.getText().trim().equals("")) {
            this.mostraMensagem("Informe o contato do usuário.");
            this.contato.requestFocus();
            return false;
        }
        
        if (this.login.getText().trim().equals("")) {
            this.mostraMensagem("Informe o login do usuário.");
            this.login.requestFocus();
            return false;
        }
        
        if (this.senha.getText().trim().equals("")) {
            this.mostraMensagem("Informe a senha do usuário.");
            this.senha.requestFocus();
            return false;
        }
        
        if (this.confirmarSenha.getText().trim().equals("")) {
            this.mostraMensagem("Informe a senha do usuário de novo, para confirmar.");
            this.confirmarSenha.requestFocus();
            return false;
        }
        
        if (this.confirmarSenha.getText().trim().equals(this.senha.getText().trim())) {
            this.mostraMensagem("Informe a senha igual a anterior, para confirmar.");
            this.confirmarSenha.requestFocus();
            return false;
        }
        
        return true;
    }
    
    public void limpaCampos() {
        this.nome.setText("");
        this.contato.setText("");
        this.login.setText("");
        this.senha.setText("");
        this.confirmarSenha.setText("");
    }
    
    
    public void setPrincipal(FrmTelaPrincipal principal){
        if(principal != null){
            this.principal = principal;
        }        
    }
    public FrmTelaPrincipal getPrincipal(){
        return this.principal;
    }
    
    public void setNome(String nome){
        if(nome != null){
            this.nome.setText(nome);
        }
    }
    public String getNome(){
        return this.nome.getText();
    }
    
    
    public void setContato(String contato){
        if(contato != null){
            this.contato.setText(contato);
        }
    }
    public String getContato(){
        return this.contato.getText();
    }
    
    
    public void setLogin(String login){
        if(login != null){
            this.login.setText(login);
        }
    }
    public String getLogin(){
        return this.login.getText();
    }
    
    public void setSenha(String senha){
        if(senha != null){
            this.senha.setText(senha);
        }
    }
    public String getSenha(){
        return this.senha.getText();
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CadastroDeUsuario = new javax.swing.JLabel();
        txtNome = new javax.swing.JLabel();
        txtContato = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        txtSenha = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        contato = new javax.swing.JTextField();
        login = new javax.swing.JTextField();
        confirmarSenha = new javax.swing.JPasswordField();
        senha = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuario");

        CadastroDeUsuario.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        CadastroDeUsuario.setText("Cadastro de Usuário");

        txtNome.setText("Nome: ");

        txtContato.setText("Contato:");

        txtLogin.setText("Login:");

        txtSenha.setText("Senha:");

        txtConfirmarSenha.setText("Confirmar Senha: ");

        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\icons 1\\accept.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\icons 1\\cancel.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(CadastroDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtNome)
                        .addGap(18, 18, 18)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtContato)
                        .addGap(10, 10, 10)
                        .addComponent(contato, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtLogin)
                        .addGap(24, 24, 24)
                        .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtConfirmarSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSenha)
                                .addGap(18, 18, 18)
                                .addComponent(senha)))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(CadastroDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtNome))
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContato)
                    .addComponent(contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtLogin))
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmarSenha)
                    .addComponent(confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        setBounds(0, 0, 422, 330);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_nomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CadastroDeUsuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPasswordField confirmarSenha;
    private javax.swing.JTextField contato;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel txtConfirmarSenha;
    private javax.swing.JLabel txtContato;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtSenha;
    // End of variables declaration//GEN-END:variables
}
