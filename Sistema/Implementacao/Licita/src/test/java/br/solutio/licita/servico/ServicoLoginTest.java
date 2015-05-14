/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

//import static org.junit.Assert.assertEquals;
import br.solutio.licita.dao.teste.DaoTeste;
import br.solutio.licita.modelo.Pregao;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

//import org.junit.Before;
//import org.junit.Test;
/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLoginTest {

    private DaoTeste dao = new DaoTeste();

    @Before
    public void setUp() {
        dao.getEntityManager();
    }

    @Test
    public void salvarPregao() {
        Pregao pregao = new Pregao();
        Pregao pregao2;
        pregao.setDescricao("vai começar a ccyber lluta");
        pregao.setNumeroPregao("123123");
        pregao.setNumeroProcesso("74367463");
        pregao.setStatusPregao("Aberto");
        pregao.setSincronizado(Boolean.TRUE);
        pregao2 = pregao;
        dao.criar(pregao2);
        assertEquals(true, pregao2.equals(pregao));
    }

}
