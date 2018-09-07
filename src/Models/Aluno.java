package Models;

import DAO.AlunoDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Aluno extends Document implements InterfaceManter{

    private int matricula;
    private String nome;
    private Curso curso;
    private boolean situacao;//saber se está ativo ou não na faculdade
    private int quantHoras;//quantas horas acumuladas o aluno tem
    private int pontuacaoPAC;//ainda não sei o que é!
    private String advertencia;
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>();//preencher fazendo uma consulta de todas as atividades que tem do mesmo aluno na tabela Debitar Hora

    
    public Aluno(){
        super();
    }
    
    public Aluno(int matricula, String nome, Curso curso, boolean situacao){
        
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setCurso(curso);
        this.setSituacao(situacao);
    
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if (matricula > 0) {
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

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void addAtividade(Atividade atividade) throws SQLException, ClassNotFoundException {
        if (atividade != null) {
            int somaAtividadePorCategoria = this.buscarHorasPorCategoria(atividade);
            if(somaAtividadePorCategoria == 0 || somaAtividadePorCategoria + atividade.getQuantHoras() <= atividade.getCategoria().getLimiteHoras()){
                atividade.setTotalAproveitado(atividade.getQuantHoras());
            }else{
                if (atividade.getCategoria().getLimiteHoras() - somaAtividadePorCategoria >= 0){
                atividade.setTotalAproveitado(atividade.getCategoria().getLimiteHoras() - somaAtividadePorCategoria);
                }
            }
            this.atividades.add(atividade);
        }
    }
    
    
    public void contabilizarAtividade(Atividade atividade) throws SQLException, ClassNotFoundException{
        if (this != null && atividade != null) {
            int somaAtividadePorCategoria = this.buscarHorasPorCategoria(atividade);
            if (somaAtividadePorCategoria < atividade.getCategoria().getLimiteHoras()) {                
                if (somaAtividadePorCategoria + atividade.getQuantHoras() <= atividade.getCategoria().getLimiteHoras()) {
                    this.setQuantHoras(this.getQuantHoras());                    
                } else {
                    this.setQuantHoras(atividade.getCategoria().getLimiteHoras() - atividade.getQuantHoras());
                }
                AlunoDAO.getInstancia().alterar(this);
            }            
        }   
    
    }

    public static final Font BOLD_UNDERLINED = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public static final Font NORMAL = new Font(Font.FontFamily.TIMES_ROMAN, 12);

    private void emitirRelatorio(int x) {

        Document documento = new Document();

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf"));

            documento.open();
            
            Font f = new Font(FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
             Font g = new Font(FontFamily.TIMES_ROMAN, 20, Font.NORMAL);

            Image imagemLogoUFC = Image.getInstance("C:/Users/willi/Desktop/a.png");

            imagemLogoUFC.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(imagemLogoUFC);
            
            Paragraph titulo = new Paragraph("RELATÓRIO - ATIVIDADES COMPLEMENTARES", f);

           // titulo.add("RELATÓRIO - ATIVIDADES COMPLEMENTARES");

            titulo.setAlignment(Element.ALIGN_CENTER);
            
            

        //    titulo.setFont(f/*new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLDITALIC, 40)*/);

            titulo.setSpacingBefore((float)15.00);
            
            titulo.setSpacingAfter((float) 20.00);

            documento.add(titulo);

            Paragraph matricula = new Paragraph();

            matricula.add("Matricula: ");

            matricula.add("" + this.matricula);

            matricula.setAlignment(Element.ALIGN_LEFT);

            matricula.setSpacingAfter((float) 10.00);

            documento.add(matricula);

            Paragraph nome = new Paragraph();

            nome.add("Nome: ");

            nome.add("" + this.nome);

            nome.setAlignment(Element.ALIGN_LEFT);

            nome.setSpacingAfter((float) 10.00);

            documento.add(nome);

            //AGORA È A TABELA
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
            //TESTANDO LISTA
           /* List list = new List(true, 20);
            list.add(new ListItem("Primeira Linha"));
            list.add(new ListItem("Essa linha tem o intuito de ser um pouco maior que uma linha apenas. Por isso estamos nos alongando neste texto para ver o que acontece, será que uma nova linha é criada ou teremos tudo numa mesma linha?"));
            list.add(new ListItem("Terceira Linha"));
            documento.add(list);

            
            //
            
            List lista = new RomanList();
       
           
       ListItem item1 = new ListItem("Teste ListItem 1", f);
       ListItem item2 = new ListItem("Teste ListItem 2", BOLD_UNDERLINED);
       ListItem item3 = new ListItem("Teste ListItem 3");
  
       lista.add(item3);
              
       lista.add(item1);
       lista.add(item2);
              
       documento.add(lista);
            */
      /* PdfPTable table = new PdfPTable(4);
       PdfPCell celula1 = new PdfPCell();
            table.getDefaultCell().setPadding((float)7.00);
       //     table.getDefaultCell().setSpaceCharRatio((float) 50.00);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
           // table.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
            table.addCell(new Paragraph("Atividade"));
            table.addCell(new Paragraph("Documento Comprobatório"));
            table.addCell(new Paragraph("Limite Da Categoria"));
            table.addCell(new Paragraph("Total Aproveitado"));
        */ PdfPTable table = new PdfPTable(3);
    table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
    PdfPCell cell = new PdfPCell(new Paragraph("header with colspan 3"));
    cell.setColspan(3);
    table.addCell(cell);
    table.addCell("1.1");
    table.addCell("2.1");
    table.addCell("3.1");
    table.addCell("1.2");
    table.addCell("2.2");
    table.addCell("3.2");
    documento.add(table);  
            
                
            documento.add(table);
          
       
       /*PdfPTable topo = new PdfPTable(2);
        PdfPCell cellTopo = new PdfPCell();
        cellTopo.setColspan(2);

        
       
       
        topo.addCell(titulo);
        documento.add(topo);
*/
        //Menu
        PdfPTable menu = new PdfPTable(7);
        PdfPCell cellMenu = new PdfPCell();
        cellMenu.setColspan(3);
        Font imenu = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        menu.addCell(new Paragraph("Atendente", imenu));
        menu.addCell(new Paragraph("Cliente de Entrada", imenu));
        menu.addCell(new Paragraph("Data de Entrada", imenu));
        /*menu.addCell(new Paragraph("Problema", imenu));
        menu.addCell(new Paragraph("Solução", imenu));
        menu.addCell(new Paragraph("Cliente de Saída", imenu));
        menu.addCell(new Paragraph("Data de Saída", imenu));*/
        documento.add(menu);

        //Conteudo
        PdfPTable conteudo = new PdfPTable(7);
        PdfPCell cellConteudo = new PdfPCell();
        cellConteudo.setColspan(2);

      conteudo.addCell(new Paragraph("Eu sou um conteudo"));
     conteudo.addCell(new Paragraph("Eu sou um conteudo2"));    
       
        PdfPCell celula1 = new PdfPCell(new Paragraph("Eu sou um conteudo"));
        PdfPCell celula2 = new PdfPCell(new Paragraph("Eu sou um conteudo2"));
        
        conteudo.addCell(celula1);
       conteudo.addCell(celula2);
        
        documento.add(conteudo);
       
            documento.add(new Paragraph("Gerando PDF - Java aaaa"));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        documento.close();

        /*
          
          quando clicar no botao de gerar pdf
          
         */
        File file = new File("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf");

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {

        }
    }

    public void emitirRelatorio(){
         Document documento = new Document();

        try {

            PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf"));

            documento.open();

            Font fTitulo = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD);
            
            Font fCorpo = new Font(FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
            
            Font fLista = new Font(FontFamily.TIMES_ROMAN, 11, Font.BOLD);
                      
            Image imagemLogoUFC = Image.getInstance("C:/Users/willi/Desktop/a.png");

            imagemLogoUFC.setAlignment(Element.ALIGN_CENTER);

            documento.add(imagemLogoUFC);

            Paragraph titulo = new Paragraph("RELATÓRIO - ATIVIDADES COMPLEMENTARES", fTitulo);

            titulo.setAlignment(Element.ALIGN_CENTER);
            
            titulo.setSpacingAfter((float) 20.00);

            documento.add(titulo);

            Paragraph matricula = new Paragraph("Matricula: ", fCorpo);

            matricula.add("" + this.matricula);

            matricula.setAlignment(Element.ALIGN_LEFT);

            matricula.setSpacingAfter((float) 10.00);

            documento.add(matricula);

            Paragraph nome = new Paragraph("Nome: ", fCorpo);

            nome.add("" + this.nome);

            nome.setAlignment(Element.ALIGN_LEFT);

            nome.setSpacingAfter((float) 10.00);

            documento.add(nome);
            
            Paragraph curso = new Paragraph("Curso: ", fCorpo);
            
            curso.add("" + this.getCurso().getNome());
            
            curso.setAlignment(Element.ALIGN_LEFT);
            
            curso.setSpacingAfter((float)10.00);
            
            documento.add(curso);
           
            
            Paragraph categoria = new Paragraph("Categoria: ", fLista);
            
            List listaCategorias = new RomanList();
            
            ListItem categoria1 = new ListItem("Atividades de iniciação à docência", fLista);
            
            ListItem categoria2 = new ListItem("Atividades de iniciação à pesquisa", fLista);
            
            ListItem categoria3 = new ListItem("Atividades de extensão", fLista);
            
            ListItem categoria4 = new ListItem("Atividades artístico-culturais e esportivas", fLista);
            
            ListItem categoria5 = new ListItem("Atividades de participação e/ou organização de eventos", fLista);
            
            ListItem categoria6 = new ListItem("Experiências ligadas à formação profissional e/ou correlatas", fLista);
            
            ListItem categoria7 = new ListItem("Produção Técnica e/ou Científica", fLista);
            
            ListItem categoria8 = new ListItem("Vivências de gestão", fLista);
            
            ListItem categoria9 = new ListItem("Outras atividades, estabelecidas de acordo com o Art. 3º. dessa Resolução", fLista);
        
            documento.add(listaCategorias);
            
            
            //AGORA É A TABELA!
            
            PdfPTable tabelAtividades = new PdfPTable(4);
            
            
       
        } catch (DocumentException de) {
           
            System.err.println(de.getMessage());
        
        } catch (IOException ioe) {
        
            System.err.println(ioe.getMessage());
        
        }
        
        documento.close();

        /*
          
          quando clicar no botao de gerar pdf
          
         */
        File file = new File("C:\\Users\\willi\\OneDrive\\Documentos\\2018.2\\Processos de Software\\Parte 1\\Trabalho\\Relatorios\\relatorio.pdf");

        try {
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {

        }
    
    }
     
    
    public static void main(String args[]) {
        Aluno a = new Aluno();
        a.emitirRelatorio(0);
    }

    @Override
    public void inserir() throws ClassNotFoundException, SQLException {
        if(this.matricula > 0 && this.nome != null && this.curso != null && this.situacao != false){
            
               AlunoDAO.getInstancia().inserir(this);
           
        }
    }

    @Override
    public void alterar() throws ClassNotFoundException, SQLException {
        if(this.matricula > 0 && this.nome != null && this.curso != null && this.situacao != false){
            AlunoDAO.getInstancia().alterar(this);
        }
    }

    @Override
    public void buscar(int codigo) throws ClassNotFoundException, SQLException {
        if(codigo > 0){
            this.matricula = codigo;
            AlunoDAO.getInstancia().buscar(this);
        }
    }

    @Override
    public void excluir() throws ClassNotFoundException, SQLException {
        AlunoDAO.getInstancia().excluir(this);
    }

    public void inserirAlunoAtividade(Atividade atividade) throws SQLException, ClassNotFoundException {
        if(this != null && atividade != null){
            AlunoDAO.getInstancia().inserirAlunoAtividade(this, atividade);
        }
    }
    
    public void alterarAlunoAtividade(Atividade atividade) throws SQLException, ClassNotFoundException{
        if(this != null && atividade != null){
            AlunoDAO.getInstancia().alterarAlunoAtividade(this, atividade);
        }
    }
    
    public void excluirAlunoAtividade(Atividade atividade) throws SQLException, ClassNotFoundException{
        if(this != null && atividade != null){
            AlunoDAO.getInstancia().excluirAlunoAtividade(this, atividade);
        }
    }
    
    public int buscarHorasPorCategoria(Atividade atividade) throws SQLException, ClassNotFoundException{
        if(this != null && atividade != null){
            return AlunoDAO.getInstancia().buscarHorasPorCategoria(this, atividade);
        }
        return -1;
    }
    
    public ArrayList<Atividade> buscarAtividades() throws SQLException, ClassNotFoundException{
        if(this != null){
            AlunoDAO.getInstancia().buscarAtividades(this);
        }
        return this.getAtividades();
    }
    
    public void buscarAlunoAtividade(Atividade atividade) throws SQLException, ClassNotFoundException{
        if(this != null && atividade != null){
            AlunoDAO.getInstancia().buscarAlunoAtividade(this, atividade);
        }
    }
 
}
