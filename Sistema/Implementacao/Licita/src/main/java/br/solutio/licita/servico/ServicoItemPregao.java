/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.qualificador.ItemPregaoDao;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoItemPregao extends ServicoAbstrato<ItemPregao> implements ServicoItemPregaoIF {

    @Inject
    private DaoIF<ItemPregao> dao;
    
    private EntityManager entityLocal;
    

    public ServicoItemPregao() {
    }

    @Override
    public DaoIF<ItemPregao> getDao() {
       
        return dao;
    }

    public void setDao(DaoIF<ItemPregao> dao) {
        this.dao = dao;
    }

    @Override
    public ItemPregao buscarPorId(Long id) {
        return getDao().buscarPorId(id);
    }

    @Override
    public List<ItemPregao> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("ItemPregao.findAll", null, null);
    }

    public EntityManager getEntityLocal() {
       if (entityLocal == null) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }

}
