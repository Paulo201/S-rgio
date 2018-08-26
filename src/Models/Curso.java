package Models;

import DAO.CursoDAO;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class Curso implements InterfaceManter {

    private int id;
    private String nome;
    private int maximoHorasComplementares;

    public Curso(){
        super();
    }
    
    public Curso(String nome, int maximoHorasComplementares){
        this.setNome(nome);
        this.setMaximoHorasComplementares(maximoHorasComplementares);
    }
    
    public Curso(int id, String nome, int maximoHorasComplementares){
        this.setId(id);
        this.setNome(nome);
        this.setMaximoHorasComplementares(maximoHorasComplementares);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMaximoHorasComplementares() {
        return maximoHorasComplementares;
    }

    public void setMaximoHorasComplementares(int maximoHorasComplementares) {
        this.maximoHorasComplementares = maximoHorasComplementares;
    }

    @Override
    public void inserir() throws ClassNotFoundException, SQLException {
        if (this.maximoHorasComplementares > 0 && this.nome != null) {
           
            if (this.id == 0) {
                 CursoDAO.getInstancia().inserir(this);
            } else {
                this.alterar();
            }
        }
    }

    @Override
    public void alterar() throws ClassNotFoundException, SQLException {
        if (this.maximoHorasComplementares > 0 && this.nome != null) {
            CursoDAO.getInstancia().alterar(this);
        }
    }

    @Override
    public void buscar(int codigo) throws ClassNotFoundException, SQLException {
        if (codigo > 0) {
            this.id = codigo;
            CursoDAO.getInstancia().buscar(this);
        }
    }

    @Override
    public void excluir() throws ClassNotFoundException, SQLException {
        CursoDAO.getInstancia().excluir(this);
    }

}
