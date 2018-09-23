package Controllers;

import Models.Aluno;
import Models.Configuracao;
import Views.FrmRelatorio;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;

/**
 *
 * @author willi
 */
public class ControllerRelatorio {
   
    private FrmRelatorio view;
    private Configuracao model;
    
    public ControllerRelatorio(FrmRelatorio view,Configuracao model){
        this.view = view;
        this.model = model;
    }
    
    public void evento(ActionEvent evt) throws SQLException, ClassNotFoundException{
        if ((evt.getSource() instanceof JButton)) {
            this.eventoBotao(evt);
        }
    } 
     
    public void eventoBotao(ActionEvent evt) throws SQLException, ClassNotFoundException {
        
        if (((JButton) evt.getSource()).getText().equals("OK")) {
             
            try {
                   Aluno aluno = new Aluno();
                   aluno.buscar(Integer.parseInt(this.view.getMatricula().trim()));
                   this.view.preencheCamposAlteracao(aluno);
                    
                } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível buscar o aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }
        
        }
        
        if (((JButton) evt.getSource()).getText().equals("Gerar PDF")) {
            if (this.view.validaCampos()) {
            
                try {
                   
                    Aluno aluno = new Aluno();
                    aluno.buscar(Integer.parseInt(this.view.getMatricula()));
                    aluno.emitirRelatorio();
                
                } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível gerar o relatório do aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }
                
            }            
        }
        
        if (((JButton) evt.getSource()).getText().equals("Cancelar")){
            
            this.view.limpaCampos();
            this.view.fechaTela();
        
        }
    
    }
    
}
