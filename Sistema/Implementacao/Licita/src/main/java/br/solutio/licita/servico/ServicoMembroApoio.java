/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoMembroApoio extends ServicoAbstrato<MembroApoio> implements ServicoMembroApoioIF {

    private FabricaDaoIF fabricaDao;
    private EntityManager entityLocal;
    
    private DaoIF<MembroApoio> dao;

    @Override
    public int contagem() {
        return dao.contagem();
    }


    @Override
    public MembroApoio buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<MembroApoio> buscarTodos() {
        return dao.buscarTodos();
    }

    public void setDao(DaoIF<MembroApoio> dao){
        this.dao = dao;
    }

    @Override
    public DaoIF<MembroApoio> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityLocal());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoMembroApoio();
        }
        return dao;
    }

    public EntityManager getEntityLocal() {
        if (entityLocal == null) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }
}
