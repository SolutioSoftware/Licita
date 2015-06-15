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
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 */
public class ServicoPregao extends ServicoAbstrato<Pregao> implements ServicoPregaoIF {

    private DaoIF<Pregao> dao;
    private FabricaDaoIF fabricaDao;

    public ServicoPregao(EntityManager entityManager) {
        super(entityManager);
    }
    
    

    @Override
    public void setDao(DaoIF<Pregao> dao) {
        this.dao = dao;
    }

    

    @Override
    public List<Pregao> buscarTodos() {
        return getDao().consultar("Pregao.findAll");
    }
    
    

    @Override
    public DaoIF<Pregao> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoPregao();
        }
        return dao; 
    }

}
