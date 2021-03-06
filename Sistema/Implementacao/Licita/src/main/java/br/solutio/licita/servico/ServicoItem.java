/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Item;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoItem extends ServicoAbstrato<Item> implements ServicoItemIF {

    private DaoIF<Item> dao;
    private FabricaDaoIF fabricaDao;

    public ServicoItem(EntityManager entityManager) {
        super(entityManager);
    }

   
    @Override
    public List<Item> buscarTodos() {
        return getDao().consultar("Item.findAll");
    }


    @Override
    public void setDao(DaoIF dao) {
        this.dao = dao;
    }

    @Override
    public DaoIF<Item> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoItem();
        }
        return dao; 
    }

}
