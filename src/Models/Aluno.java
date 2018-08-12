
package Models;

/**
 *
 * @author willi
 */
public class Aluno {
    
    private int matricula;
    private String nome;
    private Curso curso;
    private boolean situacao;//saber se está ativo ou não na faculdade
    private int quantHoras;//quantas horas acumuladas o aluno tem
    private int pontuacaoPAC;//ainda não sei o que é!
    private String advertencia;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
       if(matricula > 0){
            this.matricula = matricula;
       }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public int getQuantHoras() {
        return quantHoras;
    }

    public void setQuantHoras(int quantHoras) {
        this.quantHoras = quantHoras;
    }

    public int getPontuacaoPAC() {
        return pontuacaoPAC;
    }

    public void setPontuacaoPAC(int pontuacaoPAC) {
        this.pontuacaoPAC = pontuacaoPAC;
    }

    public String getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(String advertencia) {
        this.advertencia = advertencia;
    }

    
}
