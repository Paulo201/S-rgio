package Models;

import DAO.AlunoDAO;
import DAO.FuncionarioDAO;
import DAO.CategoriaDAO;
import DAO.AtividadeDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 * @author Beatriz Oliveira
 */
public class Configuracao implements InterfaceObservable {

    private ArrayList<InterfaceObserver> observers;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Atividade> atividades = new ArrayList<>();
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private ArrayList<Atividade> alunoAtividade;
    private ArrayList<Aluno> alunos;
    private Funcionario funcionario;
    private Atividade atividade;

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

    public void buscarAluno(int matricula) throws ClassNotFoundException, SQLException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        if (aluno.getNome() != null) {
            if (this.alunos == null) {
                this.alunos = new ArrayList<Aluno>();
            }

            this.alunos.add(aluno);
        }

    }

    public Aluno buscaAluno(int matricula) throws ClassNotFoundException, SQLException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);

        return aluno;
    }

    public Funcionario buscarFuncionario(int codigo) throws ClassNotFoundException, SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.buscar(codigo);

        return funcionario;

    }

    public Atividade buscaAtividade(int codigo) throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade();
        atividade.buscar(codigo);
        return atividade;
    }

    public void excluirAlunoAtividade(int matricula, int id_atividade) throws SQLException, ClassNotFoundException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        Atividade atividade = new Atividade();
        atividade.buscar(id_atividade);
        if (atividade != null && aluno != null) {
            aluno.excluirAlunoAtividade(atividade);
        }
    }

    public void salvarAlunoAtividades(int matricula, int id_atividade) throws SQLException, ClassNotFoundException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);
        Atividade atividade = new Atividade();
        atividade.buscar(id_atividade);
        if (atividade != null && aluno != null) {
            int totalAproveitado = aluno.addAtividade(atividade);
            aluno.contabilizarAtividade(atividade);
            aluno.alterar();
            if (totalAproveitado >= 0){
                aluno.inserirAlunoAtividade(atividade, totalAproveitado);
            }
        }
    }

    public void buscarAlunoAtividades(int matricula) throws ClassNotFoundException, SQLException {
        if (matricula > 0) {
            Aluno aluno = new Aluno();
            aluno.buscar(matricula);
            this.alunoAtividade = AlunoDAO.getInstancia().buscarAtividades(aluno);
        }
    }

    public Atividade retornaAtividade(int id) throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade();
        atividade.buscar(id);
        return atividade;
    }

    public void salvarAluno(int matricula, String nome, String nomeCurso, int quantHoras, boolean situacao, String advertencia) throws ClassNotFoundException, SQLException {

        if (matricula > 0 && nome != null && nomeCurso != null && quantHoras > 0) {
            Aluno aluno = new Aluno();
            aluno.setMatricula(matricula);
            aluno.setNome(nome);
            Curso curso = new Curso();
            curso.setNome(nomeCurso);
            curso.buscarPorNome(nomeCurso);
            aluno.setCurso(curso);
            aluno.setSituacao(situacao);
            aluno.setAdvertencia(advertencia);
            aluno.inserir();
        }

    }

    public void alterarAluno(int matricula, String nome, String nomeCurso, int quantHoras, boolean situacao, String advertencia) throws ClassNotFoundException, SQLException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);

        aluno.setMatricula(matricula);
        aluno.setNome(nome);

        Curso curso = new Curso();
        curso.buscarPorNome(nomeCurso);

        aluno.setCurso(curso);
        aluno.setQuantHoras(quantHoras);
        aluno.setSituacao(situacao);
        aluno.setAdvertencia(advertencia);

    }

    public void excluirAluno(int matricula) throws ClassNotFoundException, SQLException {
        Aluno aluno = new Aluno();
        aluno.buscar(matricula);

        aluno.excluir();
    }

    public void buscarAlunos() throws ClassNotFoundException, SQLException {

        this.alunos = AlunoDAO.getInstancia().buscaTodos();
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
        return this.alunoAtividade;
    }

    public void setAlunoAtividade(ArrayList<Atividade> alunoAtividade) {
        this.alunoAtividade = alunoAtividade;
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void salvarAtividade(String nomeAtividade, String nomeCategoria, int quantHoras) 
            throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade();
        atividade.setNomeAtividade(nomeAtividade);
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nomeCategoria);
        categoria.buscarPorNome(nomeCategoria);
        atividade.setCategoria(categoria);
        atividade.setQuantHoras(quantHoras);
        atividade.inserir();
    }

    public void alterarAtividade(int codigo, String nomeAtividade, String categoria, int quantHoras) 
        throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade();
        atividade.buscar(codigo);

        atividade.setNomeAtividade(nomeAtividade);
        Categoria categorias = new Categoria ();
        categorias.buscarPorNome(categoria);
        atividade.setCategoria(categorias);
        atividade.setQuantHoras(quantHoras);
        atividade.alterar();
    }

    public void excluirAtividade(int id)   throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade();
        atividade.buscar(id);

        atividade.excluir();
    }

    public void buscaAtividade()   throws ClassNotFoundException, SQLException {
       this.atividades = AtividadeDAO.getInstancia().buscaTodos(); 
    }
    
    public void buscarAtividadePorNome(String nome)throws ClassNotFoundException, SQLException {
        Atividade atividade = new Atividade ();
        atividade.buscarPorNome(nome);
        
        
        if(atividade.getId() > 0){
            
            this.atividades.add(atividade);
        }
    }

    public ArrayList<Atividade> getAtividades() {
        return this.atividades;
    }

    public void setAtividade(ArrayList<Atividade> atividade) {
        this.atividades = atividade;
    }

    
    public void salvarCategoria(String nomeCategoria, String nomeCurso, int limiteHoras, String descricao) 
            throws ClassNotFoundException, SQLException {
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nomeCategoria);
        Curso curso = new Curso();
        curso.setNome(nomeCurso);
        curso.buscarPorNome(nomeCurso);
        categoria.setCurso(curso);
        categoria.setDescricao(descricao);
        categoria.setLimiteHoras(limiteHoras);
        categoria.inserir();
    }
    
    
    public void alterarCategoria(int id, String nomeCurso, String categoria, int limiteHoras, String descricao) 
            throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluirCategoria(int codigo) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscaCategoria() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void buscarCategoriaPorNome(String pesquisaCategoria) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategoria(ArrayList<Categoria> categoria) {
        this.categorias = categoria;
    }

}
