package Models;

/**
 *
 * @author willi
 */
public class Categoria {

    private int id;
    private String nome;
    private String descricao;
    private int limiteHoras;
    private Curso curso;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLimiteHoras() {
        return limiteHoras;
    }

    public void setLimiteHoras(int limiteHoras) {
        this.limiteHoras = limiteHoras;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void buscar(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
