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
    
    
    public Atividade(){
        super();
    }
    
    public Atividade(String nome, Categoria categoria, int quantHoras){
        if(categoria != null && quantHoras > 0){
            this.nome = nome;
            this.categoria = categoria;
            this.quantHoras = quantHoras;
            this.categoria.setQuantHoras(quantHoras);
        }
    }
    
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
    public void calcularHoras(Aluno aluno){
        if(aluno != null && this.categoria != null){
            if(this.categoria.getQuantHoras() < this.categoria.getLimiteHoras()){
                if(aluno.getQuantHoras() + this.categoria.getQuantHoras() < this.categoria.getCurso().getMaximoHorasComplementares()){
                    aluno.setQuantHoras(this.categoria.getQuantHoras());
                }
            } else {
               if(aluno.getQuantHoras() + this.categoria.getLimiteHoras() < this.categoria.getCurso().getMaximoHorasComplementares()){
                     aluno.setQuantHoras(this.categoria.getLimiteHoras());
                }
            }
        }  
    }

    public Atividade buscar(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
