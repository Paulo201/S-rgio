package Controllers;

import Models.Configuracao;
import Models.InterfaceObserver;
import Views.FrmAlunoCadastro;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author willi
 */
public class ControllerAlunoCadastrar implements InterfaceObserver{
    private Configuracao model;
    private FrmAlunoCadastro view;
    
    public ControllerAlunoCadastrar(FrmAlunoCadastro view, Configuracao model){
        this.view = view;
        this.model = model;
    }

    public void eventoBotao(ActionEvent evt) {
        if (((JButton) evt.getSource()).getText().equals("Salvar")) {
            if (this.view.validaCampos()) {
                try {
                    this.model.salvarAluno(Integer.parseInt(this.view.getMatricula()), this.view.getNome(), this.view.getNomeCurso(), Integer.parseInt(this.view.getLimiteHoras()), this.view.isSituacao(), this.view.getAdvertencia());
                    this.view.mostraMensagem("Aluno cadastrado com sucesso.");
                    this.view.limpaCampos();
                } catch (ClassNotFoundException | SQLException ex) {
                    this.view.mostraMensagem("Não foi possível salvar o aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }
            }
        }

        if (((JButton) evt.getSource()).getText().equals("Cancelar")) {
            this.view.limpaCampos();
            this.view.fechaTela();
            this.view.getPrincipal().setVisible(true);//volta para a tela inicial
        }
  
    }
    
    public void evento(ActionEvent evt) {
        if ((evt.getSource() instanceof JButton)) {
            this.eventoBotao(evt);
        }

        this.model.avisarObservers();
    }  

    public void evento(InternalFrameEvent evt) {
        this.model.excluir(this);//deixando de ser um observer
    }
    
    @Override
    public void alterar() {
    
    
    } 
}
