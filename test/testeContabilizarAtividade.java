/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Aluno;
import Models.Atividade;
import Models.Categoria;
import Models.Curso;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author willi
 */
public class testeContabilizarAtividade {
    
    public testeContabilizarAtividade() {
    }
    
    /*@BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //*/
    @Test
    public void testeHorasAproveitadas() throws SQLException, ClassNotFoundException {
        Aluno aluno = new Aluno();
        Curso curso = new Curso();
        Categoria categoria = new Categoria();
        Atividade atividade = new Atividade();
        
        aluno.setMatricula(303030);
        categoria.setCurso(curso);
        aluno.setCurso(curso);
        curso.setMaximoHorasComplementares(288);
        aluno.setQuantHoras(100);
        categoria.setLimiteHoras(96);
        atividade.setQuantHoras(100);
        atividade.setCategoria(categoria);
        
        curso.inserir();
        aluno.inserir();
        categoria.inserir();
        atividade.inserir();
        
        int resultCorreto = 96;
        aluno.addAtividade(atividade);
        aluno.contabilizarAtividade(atividade);
        int retorno = atividade.getTotalAproveitado();
        
        
        assertEquals(resultCorreto, retorno);
        
    }
}
