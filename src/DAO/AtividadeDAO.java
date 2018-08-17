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

/**
 *
 * @author willi
 */
public class AtividadeDAO {
    private Conexao dao = Conexao.getInstanciaDaConexao();
    private static AtividadeDAO instancia;
    
    public static AtividadeDAO getInstancia() {
        if (instancia == null) {
            instancia = new AtividadeDAO();
        }
        
        return instancia;
    }
    
    public void inserir(Atividade atividade) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO `aluno`(`id`, `categoria`, `quantHoras`, `nome`) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, atividade.getId());
            stmt.setInt(2, atividade.getCategoria().getId());
            stmt.setInt(3, atividade.getQuantHoras());
            stmt.setString(4, atividade.getNome());
            
            stmt.executeUpdate();
            
            atividade.setId(this.find());
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void alterar(Atividade atividade) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `atividade` SET `categoria` = ?,`quantHoras` = ?,`nome` = ?, WHERE `id` = ?");
            stmt.setInt(1, atividade.getCategoria().getId());
            stmt.setInt(2, atividade.getQuantHoras());
            stmt.setString(3, atividade.getNome());
            stmt.setInt(4, atividade.getId());
            stmt.executeUpdate();
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void excluir(Atividade atividade) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM ATIVIDADE WHERE ID = ?");
            stmt.setInt(1, atividade.getId());
            stmt.executeUpdate();
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void buscar(Atividade atividade) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `categoria`, `quantHoras`, `nome`, FROM `atividade` WHERE `id` = ?");
            stmt.setInt(1, atividade.getId());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                Categoria categoria = new Categoria();
                categoria.buscar(result.getInt("categoria"));
                
                atividade.setCategoria(categoria);
                atividade.setQuantHoras(result.getInt("quantHoras"));
                atividade.setNome(result.getString("nome"));
                
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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'atividade' AND table_schema = 'bancoBD'");
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
