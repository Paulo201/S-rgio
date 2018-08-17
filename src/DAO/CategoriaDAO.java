package DAO;

import Conexao.Conexao;
import Models.Aluno;
import Models.Atividade;
import Models.Categoria;
import Models.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class CategoriaDAO {
      
    private Conexao dao = Conexao.getInstanciaDaConexao();
    private static CategoriaDAO instancia;
    
    public static CategoriaDAO getInstancia() {
        if (instancia == null) {
            instancia = new CategoriaDAO();
        }
        
        return instancia;
    }
    
    public void inserir(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO `categoria`(`id`, `nome`, `limite`, `curso`, `descricao`) VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNome());
            stmt.setInt(3, categoria.getLimiteHoras());
            stmt.setInt(4, categoria.getCurso().getId());
            stmt.setString(5, categoria.getDescricao());
            
            stmt.executeUpdate();
            
            //ACHO QUE AQUI TÁ ERRADO, PORQUE A MATRÍCULA NÃO É AUTO INCREMENTO
            categoria.setId(this.find());
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void alterar(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `aluno` SET `nome` = ?,`limite` = ?,`curso` = ?, `descricao` = ?, WHERE `id` = ?");
            stmt.setString(1, categoria.getNome());
            stmt.setInt(3, categoria.getLimiteHoras());
            stmt.setInt(2, categoria.getCurso().getId());
            stmt.setString(4, categoria.getDescricao());
            stmt.setInt(5, categoria.getId());
            stmt.executeUpdate();
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void excluir(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM CATEGORIA WHERE ID = ?");
            stmt.setInt(1, categoria.getId());
            stmt.executeUpdate();
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void buscar(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `nome`, `limite`, `curso`, `descricao`, FROM `categoria` WHERE `id` = ?");
            stmt.setInt(1, categoria.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                categoria.setNome(result.getString("nome"));
                categoria.setLimiteHoras(result.getInt("limite"));
                
                Curso curso = new Curso();
                curso.buscar(result.getInt("curso"));
                categoria.setCurso(curso);
                
                categoria.setDescricao(result.getString("descricao"));
                
            }
        } finally {
            Conexao.fecharConexao(conexao, stmt, result);
        }
    }
    
    private int find() throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        ResultSet result = null;
        int resultado = 0;
        
        try {
            //AJEITAR NOME DO BANCO
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'categoria' AND table_schema = 'bancoBD'");
            result = stmt.executeQuery();
            
            while (result.next()) {
                resultado = result.getInt("id");
            }
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
            return resultado - 1;
        }
    }
    
    
    
}
