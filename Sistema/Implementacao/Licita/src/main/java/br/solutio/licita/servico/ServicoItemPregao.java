/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import java.util.List;

/**
 *
 * @author ricardocaldeira
 */
public class ServicoItemPregao extends ServicoAbstrato<ItemPregao> implements ServicoItemPregaoIF {

    private DaoIF<ItemPregao> dao;
    public DaoIF<Pregao> daoPregao;

    public ServicoItemPregao() {
        this.dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoItemPregao();
        this.daoPregao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPregao();
    }

    @Override
    public DaoIF<ItemPregao> getDao() {
        return dao;
    }

    public void setDao(DaoIF<ItemPregao> dao) {
        this.dao = dao;
    }

    public DaoIF<Pregao> getDaoPregao() {
        return daoPregao;
    }

    public void setDaoPregao(DaoIF<Pregao> daoPregao) {
        this.daoPregao = daoPregao;
    }
    
    

    @Override
    public int contagem() {
        return getDao().contagem();
    }

    @Override
    public void criar(ItemPregao entidade) {
        getDao().criar(entidade);
    }

    @Override
    public void editar(ItemPregao entidade) {
        getDao().editar(entidade);
    }

    @Override
    public void deletar(ItemPregao entidade) {
        getDao().deletar(entidade);
    }

    @Override
    public ItemPregao buscarPorId(Long id) {
        return getDao().buscarPorId(id);
    }

    @Override
    public List<ItemPregao> buscarTodos() {
         return getDao().consultar("ItemPregao.findAll", null, null);
    }

    @Override
    public List<Pregao> listarPregoes() {
        return getDaoPregao().consultar("Pregao.findAll", null, null);
    }

    
    
}
