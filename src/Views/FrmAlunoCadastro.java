/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControllerAlunoCadastrar;
import Models.Configuracao;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author willi
 */
public class FrmAlunoCadastro extends javax.swing.JInternalFrame {

    private Configuracao model;
    private ControllerAlunoCadastrar controller;
    private FrmTelaPrincipal principal;
    private boolean situacao = false;
    
    public FrmAlunoCadastro() {
        initComponents();
    }

    public FrmAlunoCadastro(Configuracao model, FrmTelaPrincipal principal){
        this();
        this.model = model;
        this.controller = new ControllerAlunoCadastrar(this, model);
        this.principal = principal;
    }
    
    public void mostraMensagem(String mensagem) {
        if (mensagem != null) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
    }

    public void fechaTela() {
        this.dispose();
    }
    
    
    public boolean validaCampos() {
        
        if (this.matricula.getText().trim().equals("")) {
            this.mostraMensagem("Informe a matricula do aluno.");
            this.nome.requestFocus();
            return false;
        }
        
        if (this.nome.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome do aluno.");
            this.nome.requestFocus();
            return false;
        }
        
        if (this.nomeCurso.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome do curso do aluno.");
            this.nome.requestFocus();
            return false;
        }
        
        if (this.limiteHoras.getText().trim().equals("")) {
            this.mostraMensagem("Informe a quantidade de horas complementares que o curso tem.");
            this.nome.requestFocus();
            return false;
        }
        return true;
    }
    
    
    
    public FrmTelaPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(FrmTelaPrincipal principal) {
        this.principal = principal;
    }

    public String getAdvertencia() {
        return advertencia.getText();
    }

    public void setAdvertencia(String advertencia) {
        this.advertencia.setText(advertencia);
    }

    public String getLimiteHoras() {
        return limiteHoras.getText();
    }

    public void setLimiteHoras(String limiteHoras) {
        this.limiteHoras.setText(limiteHoras);
    }

    public String getMatricula() {
        return matricula.getText();
    }

    public void setMatricula(String matricula) {
        this.matricula.setText(matricula);
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }

    public String getNomeCurso() {
        return nomeCurso.getText();
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso.setText(nomeCurso);
    }

    public boolean isSituacao() {
        return situacao;
    }
    
    public void limpaCampos() {
        this.nome.setText("");
        this.matricula.setText("");
        this.nomeCurso.setText("");
        this.limiteHoras.setText("");
        this.advertencia.setText("");
        this.rbtnAtivo.setSelected(false);
        this.rbtnInativo.setSelected(false);
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nomeCurso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        limiteHoras = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbtnAtivo = new javax.swing.JRadioButton();
        rbtnInativo = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        advertencia = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Aluno");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Aluno");

        jLabel2.setText("Nome:");

        nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Matricula:");

        matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaActionPerformed(evt);
            }
        });

        jLabel4.setText("Curso:");

        jLabel5.setText("Limite Horas Comp:");

        limiteHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limiteHorasActionPerformed(evt);
            }
        });

        jLabel6.setText("Situação:");

        rbtnAtivo.setText("Ativo");
        rbtnAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAtivoActionPerformed(evt);
            }
        });

        rbtnInativo.setText("Inativo");

        jLabel8.setText("Advertências:");

        advertencia.setColumns(20);
        advertencia.setRows(5);
        jScrollPane1.setViewportView(advertencia);

        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\accept.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\back.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(nome)))))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(nomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(limiteHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtnAtivo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtnInativo))
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnCancelar)
                .addGap(103, 103, 103)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limiteHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAtivo)
                    .addComponent(rbtnInativo))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeActionPerformed

    private void matriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaActionPerformed

    private void limiteHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limiteHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limiteHorasActionPerformed

    private void rbtnAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAtivoActionPerformed
        this.situacao = true;
    }//GEN-LAST:event_rbtnAtivoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea advertencia;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField limiteHoras;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomeCurso;
    private javax.swing.JRadioButton rbtnAtivo;
    private javax.swing.JRadioButton rbtnInativo;
    // End of variables declaration//GEN-END:variables
}
