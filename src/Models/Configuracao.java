package Models;

import DAO.AlunoDAO;
import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Configuracao implements InterfaceObservable {

    private ArrayList<InterfaceObserver> observers;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Atividade> alunoAtividade;
    private Funcionario funcionario;

    public Configuracao() {
        if (this.observers == null) {
            this.observers = new ArrayList<>();
        }
    }

    @Override
    public void incluir(InterfaceObserver observer) {
        if (observer != null) {
            this.observers.add(observer);
        }
    }

    @Override
    public void excluir(InterfaceObserver observer) {
        if (observer != null) {
            this.observers.remove(observer);
        }
    }

    @Override
    public void avisarObservers() {
        for (InterfaceObserver observer : this.observers) {
            if (observer != null) {
                observer.alterar();
            }
        }
    }

    public void salvaFuncionario(String contato, String nome, String login, String senha) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setContato(contato);
        funcionario.setLogin(login);
        funcionario.setNome(nome);
        funcionario.setSenha(senha);
        funcionario.inserir();
    }

    public void alterarFuncionario(int codigo, String contato, String nome, String login, String senha) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.buscar(codigo);

        funcionario.setContato(contato);
        funcionario.setLogin(login);
        funcionario.setNome(nome);
        funcionario.setSenha(senha);

        funcionario.alterar();
    }

    public void excluirFuncionario(int codigo) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.buscar(codigo);
        funcionario.excluir();
    }

    public void buscaFuncionarios() throws SQLException, ClassNotFoundException {
        this.funcionarios = FuncionarioDAO.getInstancia().buscaTodos();
    }
    
    public void buscaFuncionario(int codigo) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.buscar(codigo);

        if (funcionario.getNome() != null) {
            if (this.funcionarios == null) {
                this.funcionarios = new ArrayList<Funcionario>();
            }

            this.funcionarios.add(funcionario);
        }
    }

    public Aluno buscaAluno(int matricula) throws ClassNotFoundException, SQLException{
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        return aluno;
    
    }
    
    public Atividade buscaAtividade(int id) throws ClassNotFoundException, SQLException{
        Atividade atividade = new Atividade();
        atividade.buscar(id);
        return atividade;
    }
    
    
    public void excluirAlunoAtividade(int matricula, int id_atividade) throws SQLException, ClassNotFoundException{
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        Atividade atividade = new Atividade();
        atividade.buscar(id_atividade);
        if(atividade != null && aluno != null){
            aluno.excluirAlunoAtividade(atividade);
        }
    }
    
    public void salvarAlunoAtividades(int matricula, int id_atividade) throws SQLException, ClassNotFoundException{
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        Atividade atividade = new Atividade();
        atividade.buscar(id_atividade);
        if(atividade != null && aluno != null){
            aluno.inserirAlunoAtividade(atividade);
        }
    }
    
    public void buscarAlunoAtividades(int matricula) throws ClassNotFoundException, SQLException{
        if(matricula > 0){
            Aluno aluno = new Aluno();
            aluno.buscar(matricula);
            this.alunoAtividade = AlunoDAO.getInstancia().buscarAtividades(aluno);
        }
    }
    
    public Atividade retornaAtividade(int id) throws ClassNotFoundException, SQLException{
        Atividade atividade = new Atividade();
        atividade.buscar(id);
        return atividade;
    }
    
    public void salvarAluno(int matricula, String nome, String nomeCurso, int limiteHoras, boolean situacao, String advertencia) throws ClassNotFoundException, SQLException{
    
        if(matricula > 0 && nome != null && nomeCurso != null && limiteHoras > 0){
            Aluno aluno = new Aluno();
            aluno.setMatricula(matricula);
            aluno.setNome(nome);
            Curso curso = new Curso();
            curso.buscarPorNome(nomeCurso);
            aluno.setCurso(curso);
            aluno.setSituacao(situacao);
            aluno.setAdvertencia(advertencia);
            aluno.inserir();
        }
        
    }
    
    
    
    public void validaFuncionario(String usuario, String senha) throws SQLException, ClassNotFoundException {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario();
        }
        this.funcionario.setLogin(usuario);
        this.funcionario.setSenha(senha);
        FuncionarioDAO.getInstancia().validaFuncionario(this.funcionario);
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<InterfaceObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<InterfaceObserver> observers) {
        this.observers = observers;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Atividade> getAlunoAtividade() {
        return alunoAtividade;
    }

    public void setAlunoAtividade(ArrayList<Atividade> alunoAtividade) {
        this.alunoAtividade = alunoAtividade;
    }

    
}
