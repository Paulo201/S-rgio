package Views;
import Controllers.ControllerContabilizarAtividade;
import Models.Aluno;
import Models.Atividade;
import Models.Configuracao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willi
 */
public class FrmContabilizarAtividade extends javax.swing.JInternalFrame {

    private Configuracao model;
    private ControllerContabilizarAtividade controller;
    private FrmTelaPrincipal principal;
    
    public FrmContabilizarAtividade() {
        initComponents();
    }
    public FrmContabilizarAtividade(FrmTelaPrincipal principal,Configuracao model) {
        this();
        this.model = model;
        this.controller = new ControllerContabilizarAtividade(this, model);
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
     
    public void limpaCampos() {
        this.pesquisarAtividade.setText("");
        this.nomeAtividade.setText("");
        this.quantHoraAtividade.setText("");
        this.categoria.setText("");
        this.btnNovaAtividade.setEnabled(true);
        this.btnContabilizar.setEnabled(false);
        this.btnExcluir.setEnabled(false);
    }
    
    public void limpaTableAtividadesDoAluno() {
        DefaultTableModel tabela = (DefaultTableModel) this.tblAtividadesDoAluno.getModel();
        tabela.setNumRows(0);
    }
    
    public boolean validaCamposPesquisaAluno() {
        if (this.pesquisaAluno.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome do aluno.");
            this.pesquisaAluno.requestFocus();
            return false;
        }
        
       return true;
    }
    
    public boolean validaCamposPesquisaAtividade(){
        if (this.pesquisarAtividade.getText().trim().equals("")) {
            this.mostraMensagem("Informe o nome do aluno.");
            this.pesquisaAluno.requestFocus();
            return false;
        }
        
       return true;
    }
    
    
    
    
    public void preencheCamposAtividade(Atividade atividade) {
       this.nomeAtividade.setText(String.valueOf(atividade.getNomeAtividade()));
       this.quantHoraAtividade.setText(String.valueOf(atividade.getQuantHoras()));
       this.categoria.setText(String.valueOf(atividade.getCategoria().getNomeCategoria()));
       this.btnContabilizar.setEnabled(true);
       this.btnExcluir.setEnabled(true);
       this.btnCancelar.setEnabled(true);
       this.btnNovaAtividade.setEnabled(false);
    }
    
    public void preencheCamposAluno(Aluno aluno){
        this.matricula.setText(String.valueOf(aluno.getMatricula()));
        this.nomeAluno.setText(String.valueOf(aluno.getNome()));
        this.pesquisarAtividade.setEnabled(true);
        this.btnOkAtividade.setEnabled(true);
        this.btnNovaAtividade.setEnabled(true);
    }
    

    public FrmTelaPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(FrmTelaPrincipal principal) {
        this.principal = principal;
    }

    public JTable getTblAtividadesDoAluno() {
        return tblAtividadesDoAluno;
    }

    public void setTblAtividadesDoAluno(JTable tblAtividadesDoAluno) {
        this.tblAtividadesDoAluno = tblAtividadesDoAluno;
    }  
    
    public String getPesquisaAluno(){
        return this.pesquisaAluno.getText();
    }
    public void setPesquisaAluno(String pesquisaAluno){
        this.pesquisaAluno.setText(pesquisaAluno);
    }
    
    public String getPesquisaAtividade(){
        return this.pesquisarAtividade.getText();
    }
    public void setPesquisaAtividade(String pesquisaAtividade){
        this.pesquisarAtividade.setText(pesquisaAtividade);
    }
    
    public String getNomeAtividade(){
        return this.nomeAtividade.getText();
    }
    public void setNomeAtividade(String nomeAtividade){
        this.nomeAtividade.setText(nomeAtividade);
    }
    
    public String getTotalHoras(){
        return this.totalHoras.getText();
    }
    public void setTotalHoras(String totalHoras){
        this.totalHoras.setText(totalHoras);
    }
    
    public String getCategoria(){
        return this.categoria.getText();
    }
    public void setCategoria(String categoria){
        this.categoria.setText(categoria);
    }
    
    
    public String getMatricula(){
        return this.matricula.getText();
    }
    
    public void setMatricula(int matricula){
        this.matricula.setText(""+matricula);
    }
    
    public String getNomeAluno(){
        return this.nomeAluno.getText();
    }
    
    public void setNomeAluno(String nome){
        this.nomeAluno.setText(nome);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pesquisaAluno = new javax.swing.JTextField();
        btnOkAluno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtividadesDoAluno = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalHoras = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        pesquisarAtividade = new javax.swing.JTextField();
        btnOkAtividade = new javax.swing.JButton();
        btnNovaAtividade = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nomeAtividade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quantHoraAtividade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        categoria = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnContabilizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomeAluno = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Contabilizar Atividade");

        jLabel1.setText("Pesquisar Aluno:");

        btnOkAluno.setText("OK");
        btnOkAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkAlunoActionPerformed(evt);
            }
        });

        tblAtividadesDoAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Atividade", "Quant. Horas", "Categoria", "Limite Categoria", "Total Aproveitado"
            }
        ));
        tblAtividadesDoAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtividadesDoAlunoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtividadesDoAluno);

        jLabel2.setText("Total:");

        totalHoras.setEnabled(false);
        totalHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalHorasActionPerformed(evt);
            }
        });

        jLabel3.setText("Pesquisar Atividade:");

        pesquisarAtividade.setEnabled(false);
        pesquisarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarAtividadeActionPerformed(evt);
            }
        });

        btnOkAtividade.setText("OK");
        btnOkAtividade.setEnabled(false);
        btnOkAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkAtividadeActionPerformed(evt);
            }
        });

        btnNovaAtividade.setText("Novo");
        btnNovaAtividade.setEnabled(false);

        jLabel4.setText("Nome:");

        nomeAtividade.setEnabled(false);

        jLabel5.setText("Quant. Horas:");

        quantHoraAtividade.setEnabled(false);

        jLabel6.setText("Categoria:");

        categoria.setEnabled(false);

        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\cancel.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\back.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);

        btnContabilizar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\accept.png")); // NOI18N
        btnContabilizar.setText("Contabilizar");
        btnContabilizar.setEnabled(false);
        btnContabilizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContabilizarActionPerformed(evt);
            }
        });

        jLabel7.setText("Matricula:");

        matricula.setEnabled(false);

        jLabel8.setText("Nome:");

        nomeAluno.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pesquisarAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOkAtividade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNovaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(pesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnOkAluno))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(totalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel5)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(quantHoraAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnExcluir)
                                .addGap(47, 47, 47)
                                .addComponent(btnCancelar)
                                .addGap(35, 35, 35)
                                .addComponent(btnContabilizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOkAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisarAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOkAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantHoraAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnContabilizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkAlunoActionPerformed
        this.controller.eventoBotaoOkAluno(evt);
        //Habilitar os botões agora
        this.pesquisarAtividade.setEnabled(true);
        this.btnOkAtividade.setEnabled(true);
        this.btnNovaAtividade.setEnabled(true);       
    }//GEN-LAST:event_btnOkAlunoActionPerformed

    private void totalHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalHorasActionPerformed

    private void pesquisarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarAtividadeActionPerformed

    private void btnContabilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContabilizarActionPerformed
        try {
            this.controller.evento(evt);
        } catch (SQLException ex) {
            Logger.getLogger(FrmContabilizarAtividade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmContabilizarAtividade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnContabilizarActionPerformed

    private void btnOkAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkAtividadeActionPerformed
        this.controller.eventoBotaoOkAtividade(evt);
        //habilitar os botões
        this.btnContabilizar.setEnabled(true);
        this.btnCancelar.setEnabled(true);
        this.btnExcluir.setEnabled(true);
    }//GEN-LAST:event_btnOkAtividadeActionPerformed

    private void tblAtividadesDoAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtividadesDoAlunoMouseClicked
        this.controller.evento(evt);
    }//GEN-LAST:event_tblAtividadesDoAlunoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContabilizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovaAtividade;
    private javax.swing.JButton btnOkAluno;
    private javax.swing.JButton btnOkAtividade;
    private javax.swing.JTextField categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JTextField nomeAtividade;
    private javax.swing.JTextField pesquisaAluno;
    private javax.swing.JTextField pesquisarAtividade;
    private javax.swing.JTextField quantHoraAtividade;
    private javax.swing.JTable tblAtividadesDoAluno;
    private javax.swing.JTextField totalHoras;
    // End of variables declaration//GEN-END:variables
}
