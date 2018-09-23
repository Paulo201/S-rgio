package Controllers;

import Models.Aluno;
import Models.Atividade;
import Models.Categoria;
import Views.FrmContabilizarAtividade;
import Models.Configuracao;
import Models.Aluno;
import Models.InterfaceObserver;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

        
public class ControllerContabilizarAtividade implements InterfaceObserver{
    
    private FrmContabilizarAtividade view;
    private Configuracao model;
    
    public ControllerContabilizarAtividade(FrmContabilizarAtividade view,Configuracao model){
        this.view = view;
        this.model = model;
    }
    
    public void eventoBotao(ActionEvent evt) throws SQLException, ClassNotFoundException {
        
        if (((JButton) evt.getSource()).getText().equals("Novo")) {
           //try {
            this.view.fechaTela();
            //para abrir a tela de cadastro de atividade
            // FrmAtividadeCadastro novaView = new FrmAtividadeCadastro(new ControllerAtivdade(), this.model);
         /*   } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível abrir a tela para cadastrar Atividade. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
            }*/
        }
        
        if (((JButton) evt.getSource()).getText().equals("Contabilizar")) {
            try{
           
                this.model.salvarAlunoAtividades(Integer.parseInt(this.view.getMatricula()), Integer.parseInt(this.view.getPesquisaAtividade()));
                
                this.view.limpaCampos();
                
                this.view.mostraMensagem("A atividade foi contabilizada com sucesso!");
            
            } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível contabilizar a atividade do aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }
        }
        
        if (((JButton) evt.getSource()).getText().equals("Cancelar")) {
            this.view.fechaTela();
        }
     
        if (((JButton) evt.getSource()).getText().equals("Excluir")) {
            
            try{
            
                this.model.excluirAlunoAtividade(Integer.parseInt(this.view.getMatricula()), Integer.parseInt(this.view.getPesquisaAtividade()));
            
            } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível excluir a atividade feita pelo aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }
        
        }
        
    }
     
    public void eventoBotaoOkAluno(ActionEvent evt){
         
        if (this.view.validaCamposPesquisaAluno()) {
                try {
                    Aluno aluno = this.model.buscaAluno(Integer.parseInt(this.view.getPesquisaAluno()));
                    this.view.preencheCamposAluno(aluno);
                  
                } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível pesquisar o aluno. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }   
        }  
        
    }
    
    public void eventoBotaoOkAtividade(ActionEvent evt){
         
        if (this.view.validaCamposPesquisaAluno()) {
                try {
                    Atividade atividade = this.model.buscaAtividade(Integer.parseInt(this.view.getPesquisaAtividade()));
                    this.view.preencheCamposAtividade(atividade);
                    // this.model.avisarObservers();
                } catch (SQLException | ClassNotFoundException ex) {
                    this.view.mostraMensagem("Não foi possível pesquisar a atividade. Mensagem retornada: " + ex.getMessage());
                    this.view.limpaCampos();
                }   
        }  
        
    }
    
    public void evento(ActionEvent evt) throws SQLException, ClassNotFoundException {
        if ((evt.getSource() instanceof JButton)) {
            this.eventoBotao(evt);
        }

        this.model.avisarObservers();
    }  

    public void evento(MouseEvent evt) {
      int linha = this.view.getTblAtividadesDoAluno().getSelectedRow();
                        
        if (linha >= 0) {
            try {
                Atividade atividade = new Atividade();
                atividade.buscar(Integer.parseInt(this.view.getTblAtividadesDoAluno().getValueAt(linha, 0).toString()));
                this.view.preencheCamposAtividade(atividade);

            } catch (ClassNotFoundException | SQLException ex) {
                this.view.mostraMensagem("Não foi possível selecionar funcionario. Mensagem retornada: " + ex.getMessage());
                this.view.limpaCampos();
                }
            } 
     
     }
    
    public void evento(InternalFrameEvent evt) {
        this.model.excluir(this);//deixando de ser um observer
    }
    
    @Override
    public void alterar() {
       try {
            ArrayList<Atividade> atividades = this.model.getAlunoAtividade();
            if (atividades != null) {
                this.view.limpaTableAtividadesDoAluno();
                for (Atividade atividadees : atividades) {
                    
                    Categoria categoria = new Categoria();
                    categoria.buscar(atividadees.getCategoria().getId());
                    String[] novaLinha = {atividadees.getNome(), String.valueOf(atividadees.getQuantHoras()), categoria.getNome() ,String.valueOf(categoria.getLimiteHoras()), String.valueOf(atividadees.getTotalAproveitado())};
                    ((DefaultTableModel) this.view.getTblAtividadesDoAluno().getModel()).addRow(novaLinha);
                }
            }

            this.model.setAlunoAtividade(new ArrayList<Atividade>());
        } catch (Exception ex) {
            this.view.mostraMensagem("Não foi possível atualizar as atividades dos alunos. Mensagem retornada: " + ex.getMessage());
        }
    
    }
    
    
    
}
