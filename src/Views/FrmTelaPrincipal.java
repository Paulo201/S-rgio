package Views;

import Models.Configuracao;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author willi
 */
public class FrmTelaPrincipal extends javax.swing.JFrame {
    
    private static Configuracao model;
    
    public FrmTelaPrincipal() {
        initComponents();
        this.setExtendedState(FrmTelaPrincipal.MAXIMIZED_BOTH);
        
    }

     public FrmTelaPrincipal(Configuracao model) {
        this();
        this.model = model;
        this.iniciaFormulario();
    }
     
    public boolean verificaLogin() {
        if (this.model.getFuncionario() == null) {
            return false;
        } else {
            return true;
        }
    } 
     
    
     private void colocarFormularioCentro(JInternalFrame frame) {
        Dimension desktopSize = this.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jdpPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        itemCadastrarFuncionario = new javax.swing.JMenuItem();
        itemCadastrarAluno = new javax.swing.JMenuItem();
        itemCadastrarCategoria = new javax.swing.JMenuItem();
        itemCadastrarAtividade = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemPesquisarUsuario = new javax.swing.JMenuItem();
        itemPesquisarAluno = new javax.swing.JMenuItem();
        itemPesquisarCategoria = new javax.swing.JMenuItem();
        itemPesquisarAtividade = new javax.swing.JMenuItem();
        menuContabilizarAtividade = new javax.swing.JMenu();
        menuRelatorio = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        jMenuItem7.setText("jMenuItem7");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        jMenuItem10.setText("jMenuItem10");

        jMenuItem11.setText("jMenuItem11");

        jMenuItem8.setText("jMenuItem8");

        jMenuItem12.setText("jMenuItem12");

        jMenuItem13.setText("jMenuItem13");

        jMenuItem14.setText("jMenuItem14");

        jMenuItem17.setText("jMenuItem17");

        jMenuItem18.setText("jMenuItem18");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jdpPrincipal);
        jdpPrincipal.setBounds(0, 0, 660, 420);

        menuCadastrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\add.png")); // NOI18N
        menuCadastrar.setText("Cadastrar");

        itemCadastrarFuncionario.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\user.png")); // NOI18N
        itemCadastrarFuncionario.setText("Usuário");
        itemCadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarFuncionarioActionPerformed(evt);
            }
        });
        menuCadastrar.add(itemCadastrarFuncionario);

        itemCadastrarAluno.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\group.png")); // NOI18N
        itemCadastrarAluno.setText("Aluno");
        itemCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarAlunoActionPerformed(evt);
            }
        });
        menuCadastrar.add(itemCadastrarAluno);

        itemCadastrarCategoria.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\folder_page.png")); // NOI18N
        itemCadastrarCategoria.setText("Categoria");
        itemCadastrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarCategoriaActionPerformed(evt);
            }
        });
        menuCadastrar.add(itemCadastrarCategoria);

        itemCadastrarAtividade.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\page.png")); // NOI18N
        itemCadastrarAtividade.setText("Atividade");
        itemCadastrarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCadastrarAtividadeActionPerformed(evt);
            }
        });
        menuCadastrar.add(itemCadastrarAtividade);

        jMenuBar1.add(menuCadastrar);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\zoom.png")); // NOI18N
        jMenu2.setText("Pesquisar");

        itemPesquisarUsuario.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\user.png")); // NOI18N
        itemPesquisarUsuario.setText("Usuário");
        itemPesquisarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPesquisarUsuarioActionPerformed(evt);
            }
        });
        jMenu2.add(itemPesquisarUsuario);

        itemPesquisarAluno.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\group.png")); // NOI18N
        itemPesquisarAluno.setText("Aluno");
        itemPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPesquisarAlunoActionPerformed(evt);
            }
        });
        jMenu2.add(itemPesquisarAluno);

        itemPesquisarCategoria.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\folder_page.png")); // NOI18N
        itemPesquisarCategoria.setText("Categoria");
        itemPesquisarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPesquisarCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(itemPesquisarCategoria);

        itemPesquisarAtividade.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\page.png")); // NOI18N
        itemPesquisarAtividade.setText("Atividade");
        itemPesquisarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPesquisarAtividadeActionPerformed(evt);
            }
        });
        jMenu2.add(itemPesquisarAtividade);

        jMenuBar1.add(jMenu2);

        menuContabilizarAtividade.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\calc (2).png")); // NOI18N
        menuContabilizarAtividade.setText("Contabilizar Atividade");
        menuContabilizarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContabilizarAtividadeActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuContabilizarAtividade);

        menuRelatorio.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\page_white_acrobat.png")); // NOI18N
        menuRelatorio.setText("Relatorio");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuRelatorio);

        menuSobre.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\Icones\\information.png")); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSobre);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 683, 484);
    }// </editor-fold>//GEN-END:initComponents

    private void itemCadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarFuncionarioActionPerformed
       this.jdpPrincipal.removeAll();
        if (this.verificaLogin()) {
            FrmFuncionarioCadastro frmFuncionarioCadastro = new FrmFuncionarioCadastro(this.model, this);
            this.jdpPrincipal.add(frmFuncionarioCadastro);
            this.colocarFormularioCentro(frmFuncionarioCadastro);
            frmFuncionarioCadastro.setVisible(true);
        } else {
            FrmLogin frmLogin = new FrmLogin(this.model);
            this.jdpPrincipal.add(frmLogin);
            this.colocarFormularioCentro(frmLogin);
            frmLogin.setVisible(true);
        }
    }//GEN-LAST:event_itemCadastrarFuncionarioActionPerformed

    private void itemCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCadastrarAlunoActionPerformed

    private void itemCadastrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCadastrarCategoriaActionPerformed

    private void itemPesquisarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPesquisarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPesquisarUsuarioActionPerformed

    private void itemPesquisarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPesquisarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPesquisarAtividadeActionPerformed

    private void itemCadastrarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCadastrarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCadastrarAtividadeActionPerformed

    private void itemPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPesquisarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPesquisarAlunoActionPerformed

    private void itemPesquisarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPesquisarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPesquisarCategoriaActionPerformed

    private void menuContabilizarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContabilizarAtividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuContabilizarAtividadeActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSobreActionPerformed
 
    public void iniciaFormulario() {
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal().setVisible(true);
            }
        });*/
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTelaPrincipal(new Configuracao()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCadastrarAluno;
    private javax.swing.JMenuItem itemCadastrarAtividade;
    private javax.swing.JMenuItem itemCadastrarCategoria;
    private javax.swing.JMenuItem itemCadastrarFuncionario;
    private javax.swing.JMenuItem itemPesquisarAluno;
    private javax.swing.JMenuItem itemPesquisarAtividade;
    private javax.swing.JMenuItem itemPesquisarCategoria;
    private javax.swing.JMenuItem itemPesquisarUsuario;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenu menuContabilizarAtividade;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSobre;
    // End of variables declaration//GEN-END:variables
}
