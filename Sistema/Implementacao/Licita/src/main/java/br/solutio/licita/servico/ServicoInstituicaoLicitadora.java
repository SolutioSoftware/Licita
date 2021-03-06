/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoInstituicaoLicitadora extends ServicoAbstrato<InstituicaoLicitadora> implements ServicoInstituicaoLicitadoraIF {
    
    private DaoIF<InstituicaoLicitadora> dao;
    private FabricaDaoIF fabricaDao;

    public ServicoInstituicaoLicitadora(EntityManager entityManager){
        super(entityManager);
    }

   
    @Override
    public void setDao(DaoIF<InstituicaoLicitadora> dao) {
        this.dao = dao;
    }

    @Override
    public List<InstituicaoLicitadora> buscarTodos() {
        
        return getDao().consultar("InstituicaoLicitadora.findAll");
    }

    @Override
    public DaoIF<InstituicaoLicitadora> getDao() {
       if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoInstituicaoLicitadora();
        }
        return dao; 
    }
    
}
