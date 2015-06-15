/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoPessoaFisica extends ServicoAbstrato<PessoaFisica> implements ServicoPessoaFisicaIF{

   private DaoIF<PessoaFisica> dao;
    private FabricaDaoIF fabricaDao;

    public ServicoPessoaFisica(EntityManager entityManager) {
        super(entityManager);
    }
  

   @Override
    public void setDao(DaoIF<PessoaFisica> dao) {
        this.dao = dao;
    }

    

    @Override
    public List<PessoaFisica> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("PessoaFisica.findAll");
    }

    @Override
    public DaoIF<PessoaFisica> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoPessoaFisica();
        }
        return dao; 
    }

    
}
