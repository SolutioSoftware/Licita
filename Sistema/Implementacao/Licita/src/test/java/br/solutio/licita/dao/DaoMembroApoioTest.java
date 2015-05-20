/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import br.solutio.licita.dao.teste.DAOTestes;
import br.solutio.licita.modelo.MembroApoio;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoMembroApoioTest {
    
    private DAOTestes<MembroApoio> dao;
    private MembroApoio membro;
    
    @Before
    public void setUp(){
        membro = new MembroApoio();
        dao = new DAOTestes<>();
        
        membro.getPessoaFisica().setCpf("12312312312");
        membro.getPessoaFisica().setNome("Matheus");
        membro.getPessoaFisica().setRg("11221312");
        membro.setFuncao("Avaliador");
    }
    
    @Test
    public void teste(){
        dao.criar(membro);
        assertEquals(true, membro.getId() == 1);
        membro.setFuncao("Aviador");
        dao.editar(membro);
        
        dao.deletar(membro);
    }
}
