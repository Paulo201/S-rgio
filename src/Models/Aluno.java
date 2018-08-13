
package Models;

import static com.itextpdf.text.Annotation.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import static com.itextpdf.text.pdf.PdfPKCS7.X509Name.C;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;


/**
 *
 * @author willi
 */
public class Aluno extends Document{
    
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
        this.quantHoras += quantHoras;
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
    
    public void emitirRelatorio(){
        
        Document documento = new Document();
        
        try {
              
                PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf"));
                
                documento.open();
                
                Image imagemLogoUFC = Image.getInstance("C:/Users/willi/Desktop/a.png");
                
                imagemLogoUFC.setAlignment(Element.ALIGN_CENTER);
                
                documento.add(imagemLogoUFC);
                
                Paragraph titulo = new Paragraph();
                
                titulo.add("RELATÓRIO - ATIVIDADES COMPLEMENTARES");
                
                titulo.setAlignment(Element.ALIGN_CENTER);
                              
                titulo.setFont(new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLDITALIC, 40));
                
                
                        
                  
                //font = getFont(Font.FontFamily.TIMES_ROMAN, Font.BOLDITALIC, 40); 
                
               
                documento.add(titulo);
                /*Paragraph pImagem = new Paragraph();
                pImagem.add(imagem);
                pImagem.setAlignment(Element.ALIGN_CENTER);
                documento.add(pImagem);
                Paragraph p = new Paragraph();
                
                */
                
                /*
                Phrase a = new Phrase("Titulo: ");
                a.setFont(new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLDITALIC, 40));
                documento.add(a);
                p.add(a);
                p.add("Teste de Titulo");
                p.setAlignment(Element.ALIGN_CENTER);
                p.setIndentationLeft(18);
                p.setFirstLineIndent(-18);
                p.add(" ");
                p.add(new Phrase("Titulo 2: ", BOLD_UNDERLINED));
                p.add("Teste de Titulo 2");
                 */   
                
               
             
             documento.add(new Paragraph("Gerando PDF - Java aaaa"));             
}
          catch(DocumentException de) {
              System.err.println(de.getMessage());
          }
          catch(IOException ioe) {
              System.err.println(ioe.getMessage());
          }
          documento.close();
        
       /*
          
          quando clicar no botao de gerar pdf
          
           */
          
          
          
          
       File file = new File("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf");
       
       try{
        Desktop.getDesktop().open(file);
       } catch(IOException ex){
           
       }
     }
       
    public static void main(String args[]){
        Aluno a = new Aluno();
        a.emitirRelatorio();
    }
    
}
