/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import java.util.List;

/**
 *
 * @author WitaloCarlos
 */
public class ServicoPregao extends ServicoAbstrato<Pregao> implements ServicoPregaoIF {

    private DaoIF<Pregao> dao;

    public ServicoPregao() {
        this.dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPregao();
    }

    @Override
    public DaoIF<Pregao> getDao() {
        return dao;
    }

    public void setDao(DaoIF<Pregao> dao) {
        this.dao = dao;
    }

    @Override
    public int contagem() {

        return getDao().contagem();
    }

    @Override
    public void criar(Pregao entidade) {
        getDao().criar(entidade);
    }

    @Override
    public void editar(Pregao entidade) {
        getDao().editar(entidade);
    }

    @Override
    public void deletar(Pregao entidade) {
        getDao().deletar(entidade);
    }

    @Override
    public Pregao buscarPorId(Long id) {
        return getDao().buscarPorId(id);
    }

    @Override
    public List<Pregao> buscarTodos() {
        return getDao().consultar("Pregao.findAll", null, null);
    }

}
