/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Sessao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoSessao extends ServicoAbstrato<Sessao> implements ServicoSessaoIF {

    private DaoIF<Sessao> dao;
    private FabricaDaoIF fabricaDao;
    private EntityManager entityLocal;

    public ServicoSessao() {
    }

    @Override
    public DaoIF<Sessao> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityLocal());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoSessao();
        }
        return dao;
    }
    
    @Override
    public void setDao(DaoIF<Sessao> dao) {
        this.dao = dao;
    }

    private EntityManager getEntityLocal() {
        if (entityLocal == null || !entityLocal.isOpen()) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }

    @Override
    public List<Sessao> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("Sessao.findAll", null, null);
    }

}
 
    

