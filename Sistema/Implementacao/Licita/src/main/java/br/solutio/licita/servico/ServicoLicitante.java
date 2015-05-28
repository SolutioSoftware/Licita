/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoLicitante extends ServicoAbstrato<EmpresaLicitante> implements ServicoLicitanteIF {

    private DaoIF<EmpresaLicitante> dao;
    private FabricaDaoIF fabricaDao;
    private EntityManager entityLocal;

    public ServicoLicitante() {
    }

    @Override
    public DaoIF<EmpresaLicitante> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityLocal());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoEmpresaLicitante();
        }
        return dao;
    }

    public void setDao(DaoIF<EmpresaLicitante> dao) {
        this.dao = dao;
    }

    private EntityManager getEntityLocal() {
        if (entityLocal == null || !entityLocal.isOpen()) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }

    @Override
    public List<EmpresaLicitante> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("EmpresaLicitante.findAll", null, null);
    }
}
