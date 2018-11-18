/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ControllerAtividadePesquisa;
import Models.Configuracao;
import Models.Atividade;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Beatriz Oliveiira
 */
public class FrmAtividadePesquisa extends javax.swing.JInternalFrame {

    private Configuracao model;
    private ControllerAtividadePesquisa controller;

    
    public FrmAtividadePesquisa() {
        initComponents();
    }
    
    public FrmAtividadePesquisa(Configuracao model){
        this();
        this.model = model;
        this.controller = new ControllerAtividadePesquisa(this, model);
    }
    
    public void mostraMensagem(String mensagem) {
        if (mensagem != null) {
            JOptionPane.showMessageDialog(this, mensagem);
        }
    }
    
    public boolean validaPesquisa(){
        if(this.pesquisaAtividade.getText().trim().equals("")){
            this.mostraMensagem("Informe o nome da Atividade, ou digite 'todos' para retornar todos as atividades. ");
            this.pesquisaAtividade.requestFocus();
            return false;
        }
        return true;
    }
    
    public boolean validaCampos() {
         
        if (this.nomeAtividade.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome da atividade.");
            this.nomeAtividade.requestFocus();
            return false;
        }
        
        if (this.categoria.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome da categoria.");
            this.categoria.requestFocus();
            return false;
        }
        
        if (this.quantHoras.getText().trim().equals("")) {
            this.mostraMensagem("Informe a quantidade de horas da atividade.");
            this.quantHoras.requestFocus();
            return false;
        }
                
        return true;
    }
    
    public void limpaTableAtividade() {
        DefaultTableModel tabela = (DefaultTableModel) this.tableAtividade.getModel();
        tabela.setNumRows(0);
    }

    public void preencheCamposAlteracao(Atividade atividade) {
        if (atividade != null) {
            this.id.setText(String.valueOf(atividade.getId()));
            this.nomeAtividade.setText(atividade.getNomeAtividade());
            this.categoria.setText(atividade.getCategoria().getNomeCategoria());
            this.quantHoras.setText(String.valueOf(atividade.getQuantHoras()));
            this.btnSalvar.setEnabled(true);
            this.btnExcluir.setEnabled(true);
            this.btnCancelar.setEnabled(true);
            
        }
    }
    
    public void limpaCampos() {
        this.id.setText("");
        this.quantHoras.setText("");
        this.nomeAtividade.setText("");
        this.pesquisaAtividade.setText("");
        this.categoria.setText("");

       
    }
    
     public void fechaTela() {
        this.dispose();
    }

    public String getId(){
        return this.id.getText().trim();
    }
    
    public String getCategoria() {
        return this.categoria.getText().trim();
    }

    public String getNomeAtividade() {
        return this.nomeAtividade.getText().trim();
    }

    public String getQuantHoras() {
        return this.quantHoras.getText().trim();
    }
    
    public String getPesquisaAtividade(){
        return this.pesquisaAtividade.getText().trim();
    }
    
    public JTable getTableAtividade(){
        return this.tableAtividade;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeAtividade = new javax.swing.JTextField();
        txtLogin = new javax.swing.JLabel();
        txtContato = new javax.swing.JLabel();
        categoria = new javax.swing.JTextField();
        quantHoras = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        txtPesquisarUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        pesquisaAtividade = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        BtnOk = new javax.swing.JButton();
        txtNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAtividade = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Atividade");

        nomeAtividade.setEnabled(false);

        txtLogin.setText("categoria:");

        txtContato.setText("Quantidade de horas:");

        categoria.setEnabled(false);

        quantHoras.setEnabled(false);

        id.setEnabled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\accept.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        titulo.setText("Pesquisar Atividade");

        labelId.setText("Id:");

        txtPesquisarUsuario.setText("Pesquisar:");

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\back.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        pesquisaAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaAtividadeActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\cancel.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        BtnOk.setText("OK");
        BtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOkActionPerformed(evt);
            }
        });

        txtNome.setText("Nome:");

        tableAtividade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Categoria", "quantidade de horas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAtividade.setColumnSelectionAllowed(true);
        tableAtividade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAtividadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAtividade);
        tableAtividade.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(64, 64, 64)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(titulo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelId)
                                .addGap(73, 73, 73)
                                .addComponent(txtNome)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtLogin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContato)
                            .addComponent(quantHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisarUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnOk)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtPesquisarUsuario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pesquisaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId)
                    .addComponent(txtNome))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(txtContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void pesquisaAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaAtividadeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        this.controller.evento(evt);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void BtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOkActionPerformed
        this.controller.evento(evt);
        this.id.setEnabled(false);
        this.nomeAtividade.setEnabled(true);
        this.categoria.setEnabled(true);
        this.quantHoras.setEnabled(true);
    }//GEN-LAST:event_BtnOkActionPerformed

    private void tableAtividadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAtividadeMouseClicked
        this.controller.evento(evt);
    }//GEN-LAST:event_tableAtividadeMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnOk;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField categoria;
    private javax.swing.JTextField id;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelId;
    private javax.swing.JTextField nomeAtividade;
    private javax.swing.JTextField pesquisaAtividade;
    private javax.swing.JTextField quantHoras;
    private javax.swing.JTable tableAtividade;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtContato;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtNome;
    private javax.swing.JLabel txtPesquisarUsuario;
    // End of variables declaration//GEN-END:variables

}
