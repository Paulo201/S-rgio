package Views;
import Controllers.ControllerContabilizarAtividade;
import Models.Configuracao;
import javax.swing.JOptionPane;

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
    public FrmContabilizarAtividade(FrmTelaPrincipal principal) {
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
     
    public void limpaCampos() {
        this.pesquisarAtividade.setText("");
        this.nomeAtividade.setText("");
        this.quantHoraAtividade.setText("");
        this.categoria.setText("");
        
       // this.btnSalvar.setText("Salvar");
        //this.btnCancelar.setEnabled(false);
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
                "Matricula", "Nome", "Atividade", "Limite Categoria", "Total Aproveitado"
            }
        ));
        tblAtividadesDoAluno.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblAtividadesDoAluno);
        tblAtividadesDoAluno.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel2.setText("Total:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(pesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOkAluno))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(totalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(pesquisarAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnOkAtividade)
                .addGap(10, 10, 10)
                .addComponent(btnNovaAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(171, 171, 171)
                .addComponent(jLabel5)
                .addGap(52, 52, 52)
                .addComponent(jLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(quantHoraAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnExcluir)
                .addGap(43, 43, 43)
                .addComponent(btnCancelar)
                .addGap(39, 39, 39)
                .addComponent(btnContabilizar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pesquisaAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOkAluno))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(totalHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pesquisarAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOkAtividade)
                    .addComponent(btnNovaAtividade))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantHoraAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnContabilizar)
                        .addComponent(btnCancelar)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkAlunoActionPerformed

    private void totalHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalHorasActionPerformed

    private void pesquisarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarAtividadeActionPerformed

    private void btnContabilizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContabilizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContabilizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContabilizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovaAtividade;
    private javax.swing.JButton btnOkAluno;
    private javax.swing.JButton btnOkAtividade;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField categoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomeAtividade;
    private javax.swing.JTextField pesquisaAluno;
    private javax.swing.JTextField pesquisarAtividade;
    private javax.swing.JTextField quantHoraAtividade;
    private javax.swing.JTable tblAtividadesDoAluno;
    private javax.swing.JTextField totalHoras;
    // End of variables declaration//GEN-END:variables
}
