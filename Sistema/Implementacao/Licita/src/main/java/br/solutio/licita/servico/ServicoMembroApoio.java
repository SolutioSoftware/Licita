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
import javax.persistence.EntityManager;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoMembroApoio extends ServicoAbstrato<MembroApoio> implements ServicoMembroApoioIF {

    private FabricaDaoIF fabricaDao;

    private DaoIF<MembroApoio> dao;

    public ServicoMembroApoio(EntityManager entityManager) {
        super(entityManager);
    }
    
    
    @Override
    public void setDao(DaoIF<MembroApoio> dao) {
        this.dao = dao;
    }

    
    @Override
    public List<MembroApoio> buscarTodos() {

        return getDao().consultar("MembroApoio.findAll");
    }

    @Override
    public DaoIF<MembroApoio> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoMembroApoio();
        }
        return dao; 
    }
}
