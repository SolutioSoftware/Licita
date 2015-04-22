/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.persistencia.dao.DaoAbstratoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.persistencia.dao.local.DaoLogin;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocalIF;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLoginLocal extends ServicoAbstrato implements ServicoLoginIF{

    FabricaDaoLocalIF fabricaLocal = (FabricaDaoLocal) FabricaDAO.getFabricaDAO(TipoDAO.Local);
    DaoLogin dao;
    @Override
    public Identificavel verificarDados(String login, String senha) {
        return null;
    }

    @Override
    public DaoAbstratoIF getDao() {
        return fabricaLocal.getDaoLogin();
    }
    
}
