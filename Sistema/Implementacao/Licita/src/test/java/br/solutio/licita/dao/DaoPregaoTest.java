/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.dao;

import br.solutio.licita.dao.teste.DAOTestes;
import br.solutio.licita.modelo.Pregao;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoPregaoTest {
    
    private DAOTestes dao = new DAOTestes(Pregao.class);
    private Pregao pregao;
    private Pregao pregao2, pregaoVazio, pregaoAtualizado;
    
    @Before
    public void setUp() {
        pregao = new Pregao();
        pregao2 = new Pregao();
        pregaoVazio = new Pregao();
        pregaoAtualizado = new Pregao();
        dao.getEntityManager();
        pregao.setDescricao("vai começar a ccyber lluta");
        pregao.setNumeroPregao("123123");
        pregao.setNumeroProcesso("74367463");
        pregao.setStatusPregao("Aberto");
        pregao.setSincronizado(Boolean.TRUE);
        
        pregao.setDescricao("vai terminar a ccyber lluta");
        pregao.setNumeroPregao("1111");
        pregao.setNumeroProcesso("76666");
        pregao.setStatusPregao("Fechado");
        pregao.setSincronizado(Boolean.FALSE);
    }
    
    @Test
    public void salvarPregao() {
        //Salvando no banco(HSQL) os pregoes.
        dao.criar(pregao);
        dao.criar(pregao2);
        
        /**
         * 1 - Falso, caso o pregao2.id = pregao.id
         * 2 - Verdade, caso o pregao2.id <> pregao.id
         * 3 - Falso, pregao2 for igual ao pregaoVazio
         * 4 - Falso, pregao for igual ao pregaoAtualizado
         */
        assertEquals(false, pregao2.equals(pregao));
        assertEquals(true, !pregao2.equals(pregao));
        assertEquals(false, pregao2.equals(pregaoVazio));
        assertEquals(false, pregao.equals(pregaoAtualizado));
        
        
        //Atualizando os valores de PRegao2
        pregao2.setDescricao("eu quero mudança meu filho");
        pregao2.setSincronizado(Boolean.TRUE);
        dao.editar(pregao2);
        
        //Verificando buscaPorId
        pregaoAtualizado = (Pregao) dao.buscarPorId(pregao2.getId());
        assertEquals(true, pregao2.equals(pregaoAtualizado));
        
        //Verificando remocao do banco
        dao.deletar(pregao);
        dao.deletar(pregao2);
        
        assertEquals(true, !pregao.equals(pregaoVazio));
        assertEquals(false, pregao.equals(pregao2));
        assertEquals(false, pregao.equals(pregaoVazio));
        assertEquals(false, pregao2.equals(pregaoVazio));
        
    }
    
}
