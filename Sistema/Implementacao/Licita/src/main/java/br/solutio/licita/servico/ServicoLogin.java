/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.FabricaDaoIF;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;


/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLogin extends ServicoAbstrato<Login> implements ServicoLoginIF{

    private FabricaDaoIF fabricaLocal = (FabricaDaoLocal) FabricaDAO.getFabricaDAO(TipoDAO.Local);
    private DaoIF<Login> dao = fabricaLocal.getDaoLogin();

    /**
     *
     * @param login
     * @param senha
     * @return
     */
    @Override
    public boolean verificarDados(String login, String senha) {
        //TODO resolver este método neste nível
        // dao.verificarDados(login, senha);
        return false;
    }

    @Override
    public DaoIF getDao() {
        return this.dao;
    }
    
}
