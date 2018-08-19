package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Models.*;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class AlunoDAO {
    
    //TESTADA!
    
    private Conexao dao = Conexao.getInstanciaDaConexao();
    private static AlunoDAO instancia;
    
    public static AlunoDAO getInstancia() {
        if (instancia == null) {
            instancia = new AlunoDAO();
        }
        
        return instancia;
    }
    
    public void inserir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("INSERT INTO `aluno`(`matricula`, `nome`, `id_curso`, `situacao`, `quant_horas`, `PAC`, `Advertencias`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setInt(3, aluno.getCurso().getId());
            stmt.setBoolean(4, aluno.isSituacao());
            stmt.setInt(5, aluno.getQuantHoras());
            stmt.setInt(6, aluno.getPontuacaoPAC());
            stmt.setString(7, aluno.getAdvertencia());
            
            stmt.executeUpdate();
            
            //ACHO QUE AQUI TÁ ERRADO, PORQUE A MATRÍCULA NÃO É AUTO INCREMENTO
            //aluno.setMatricula(this.find());
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("UPDATE `aluno` SET `nome` = ?,`id_curso` = ?,`situacao` = ?, `quant_horas` = ?, `PAC` = ?, `Advertencias` = ? WHERE `matricula` = ?");
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getCurso().getId());
            stmt.setBoolean(3, aluno.isSituacao());
            stmt.setInt(4, aluno.getQuantHoras());
            stmt.setInt(5, aluno.getPontuacaoPAC());
            stmt.setString(6, aluno.getAdvertencia());
            stmt.setInt(7, aluno.getMatricula());
            stmt.executeUpdate();
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void excluir(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement("DELETE FROM `ALUNO` WHERE `MATRICULA` = ?");
            stmt.setInt(1, aluno.getMatricula());
            stmt.executeUpdate();
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
    }
    
    public void buscar(Aluno aluno) throws SQLException, ClassNotFoundException {
        Connection conexao = dao.getConexao();
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = conexao.prepareStatement("SELECT `nome`, `id_curso`, `situacao`, `quant_horas`,`PAC`, `Advertencias` FROM `aluno` WHERE `matricula` = ?");
            stmt.setInt(1, aluno.getMatricula());
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                Curso curso = new Curso();
                curso.buscar(result.getInt("id_curso"));
                aluno.setCurso(curso);
                
                
                aluno.setAdvertencia(result.getString("Advertencias"));
                aluno.setQuantHoras(result.getInt("quant_horas"));
                aluno.setPontuacaoPAC(result.getInt("PAC"));
                aluno.setNome(result.getString("nome"));
                aluno.setSituacao(result.getBoolean("situacao"));
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
            stmt = conexao.prepareStatement("SELECT AUTO_INCREMENT as id FROM information_schema.tables WHERE table_name = 'aluno' AND table_schema = 'bancogerenciamentoatividadecomplementar'");
            result = stmt.executeQuery();
            
            while (result.next()) {
                resultado = result.getInt("id");
            }
            
        } finally {
            Conexao.fecharConexao(conexao, stmt);
            return resultado - 1;
        }
    }
    
    /*
    *   TESTE
    */
    
  /*  public static void main(String args[]) throws ClassNotFoundException, SQLException{
    
      Curso curso = new Curso("CIVIL", 192);
        
      curso.inserir();
        
        Aluno aluno = new Aluno(390240, "Willi", curso, true);
        
        aluno.inserir();
        
        aluno.alterar();
       
        aluno.buscar(390239);
   
        aluno.excluir();
        
    }*/
    
}
