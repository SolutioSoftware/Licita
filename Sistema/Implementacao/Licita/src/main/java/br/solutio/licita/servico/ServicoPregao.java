/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 */
public class ServicoPregao extends ServicoAbstrato<Pregao> implements ServicoPregaoIF {

    private DaoIF<Pregao> dao;
    private FabricaDaoIF fabricaDao;
    private EntityManager entityLocal;

    public ServicoPregao() {
    }

    @Override
    public DaoIF<Pregao> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityLocal());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoPregao();
        }
        return dao;
    }

    public void setDao(DaoIF<Pregao> dao) {
        this.dao = dao;
    }

    private EntityManager getEntityLocal() {
        if (entityLocal == null || !entityLocal.isOpen()) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }

    private EntityManager getEntityRemoto() {
        return ProdutorEntityManager.getInstancia().getEmRemoto();
    }

    @Override
    public List<Pregao> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("Pregao.findAll", null, null);
    }

}
