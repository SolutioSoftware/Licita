/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.servico.util.Criptografar;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoMembroApoio implements ServicoMembroApoioIF {

    private DaoIF<MembroApoio> dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoMembroApoio();
    private static Logger log = Logger.getGlobal();

    @Override
    public int contagem() {
        return dao.contagem();
    }

    @Override
    public void criar(MembroApoio entidade) {
        dao.criar(entidade);
    }

    @Override
    public void editar(MembroApoio entidade) {
        dao.editar(entidade);
    }

    @Override
    public void deletar(MembroApoio entidade) {
        dao.deletar(entidade);
    }

    @Override
    public MembroApoio buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<MembroApoio> buscarTodos() {
        return dao.buscarTodos();
    }

    public void setDao(DaoIF dao){
        this.dao = dao;
    }
}
