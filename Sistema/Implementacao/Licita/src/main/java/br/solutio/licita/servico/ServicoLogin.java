/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.DaoLoginIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocalIF;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLogin extends ServicoAbstrato implements ServicoLoginIF{

    private FabricaDaoLocalIF fabricaLocal = (FabricaDaoLocal) FabricaDAO.getFabricaDAO(TipoDAO.Local);
    private DaoLoginIF dao = fabricaLocal.getDaoLogin();

    /**
     *
     * @param login
     * @param senha
     * @return
     */
    @Override
    public boolean verificarDados(String login, String senha) {
        return dao.verificarDados(login, senha);
    }

    @Override
    public DaoIF getDao() {
        return this.dao;
    }
    
}
