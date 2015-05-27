/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.DaoIF;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author WitaloCarlos
 */
@br.solutio.licita.servico.qualificador.ServicoPregao
public class ServicoPregao extends ServicoAbstrato<Pregao> implements ServicoPregaoIF {

    
    private DaoIF<Pregao> dao;
    

    
    private EntityManager entityLocal;

    public ServicoPregao() {
    }

    @Override
    public DaoIF<Pregao> getDao() {
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

    @Override
    public List<Pregao> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("Pregao.findAll", null, null);
    }

}
