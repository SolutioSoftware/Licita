/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.dao;

import br.solutio.licita.dao.teste.DAOTestes;
import br.solutio.licita.modelo.Pregoeiro;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoPregoeiroTest {

    private Pregoeiro pregoeiro;
    private Pregoeiro pregoeiroAux;
    private DAOTestes<Pregoeiro> dao;

    @Before
    public void setUp() {
        dao = new DAOTestes<>();
        dao.getEntityManager();
        pregoeiro = new Pregoeiro();
        pregoeiro.getPessoaFisica().setCpf("06953601400");
        pregoeiro.getPessoaFisica().setNome("Matheus");
        pregoeiro.getPessoaFisica().setRg("35229");
        pregoeiro.getLogin().setLogado(Boolean.TRUE);
        pregoeiro.getLogin().setUsuario("admin");
        pregoeiro.getLogin().setSenha("123");

        pregoeiroAux = new Pregoeiro();
        pregoeiroAux.getPessoaFisica().setCpf("06953601400");
        pregoeiroAux.getPessoaFisica().setNome("Matheus");
        pregoeiroAux.getPessoaFisica().setRg("35229");
        pregoeiroAux.getLogin().setLogado(Boolean.TRUE);
        pregoeiroAux.getLogin().setUsuario("admin");
        pregoeiroAux.getLogin().setSenha("123");


    }

    @Test
    public void testeSalvarEditarBuscar() {
        //Salvando Pregoeiros
        dao.criar(pregoeiro);
        dao.criar(pregoeiroAux);
        
        //Verificando pregoeiro
        assertEquals(true, pregoeiro.getId() == 1);
        assertEquals(false, pregoeiro.equals(pregoeiroAux));

        //Verificando pregoeiroAux
        assertEquals(false, pregoeiroAux.equals(pregoeiro));
        
        
        //Verificando edicao
        pregoeiroAux.getPessoaFisica().setCpf("12312312312");
        dao.editar(pregoeiroAux);
        
        //Verificando remocao
        dao.deletar(pregoeiro);
        dao.deletar(pregoeiroAux);
        
    }

}
