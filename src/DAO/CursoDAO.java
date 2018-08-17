package DAO;

import Conexao.Conexao;
import Models.Curso;
import Models.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class CursoDAO {
    
    private Conexao dao = Conexao.getInstanciaDaConexao();
    private static CursoDAO instancia;
    
    public static CursoDAO getInstancia() {
        if (instancia == null) {
            instancia = new CursoDAO();
        }
        
        return instancia;
    }
    
    public void inserir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO `curso`(`id`, `nome`, `maximoHorasComplementares`) VALUES (?, ?, ?)");
            stmt.setInt(1, curso.getId());
            stmt.setString(2, curso.getNome());
            stmt.setInt(3, curso.getMaximoHorasComplementares());
            
           
            stmt.executeUpdate();
            
            //ACHO QUE AQUI TÁ ERRADO, PORQUE A MATRÍCULA NÃO É AUTO INCREMENTO
            curso.setId(this.find());
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void alterar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `curso` SET `nome` = ?,`maximoHorasComplementares` = ?, WHERE `id` = ?");
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getMaximoHorasComplementares());
           
            stmt.executeUpdate();
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM CURSO WHERE ID = ?");
            stmt.setInt(1, curso.getId());
            stmt.executeUpdate();
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void buscar(Curso curso) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `nome`, `maximoHorasComplementares`, FROM `curso` WHERE `id` = ?");
            stmt.setInt(1, curso.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                curso.setNome(result.getString("nome"));
                curso.setMaximoHorasComplementares(result.getInt("maximoHorasComplementares"));
                
        
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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'curso' AND table_schema = 'bancoBD'");
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
