package Models;

/**
 *
 * @author willi
 */
public class Curso {
    
    private int id;
    private String nome;
    private int maximoHorasComplementares;

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

    public int getMaximoHorasComplementares() {
        return maximoHorasComplementares;
    }

    public void setMaximoHorasComplementares(int maximoHorasComplementares) {
        this.maximoHorasComplementares = maximoHorasComplementares;
    }

    public void buscar(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
