package Models;

/**
 *
 * @author willi
 */
public class Atividade {
    
    private int id;
    private String nome;
    private Categoria categoria;
    private int quantHoras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(int quantHoras) {
        this.quantHoras = quantHoras;
    }
    
    //aqui fica o método pra debitar a hora
    
}
