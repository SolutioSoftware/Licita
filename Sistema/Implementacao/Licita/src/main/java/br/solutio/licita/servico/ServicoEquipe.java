/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoEquipe implements ServicoEquipeIF {

    private DaoIF<PessoaFisica> dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoPessoaFisica();
    private static Logger log = Logger.getGlobal();

    @Override
    public int contagem() {
        return dao.contagem();
    }

    @Override
    public void criar(PessoaFisica entidade) {
        if (entidade != null) {
            log.info("PessoaFisica preparando para ser salva");
            this.dao.criar(entidade);
            log.info("PessoaFisica salva");

        } else {
            log.warning("Nenhum valor foi inserido!");
        }
    }

    @Override
    public void editar(PessoaFisica entidade) {
        dao.criar(entidade);
    }

    @Override
    public void deletar(PessoaFisica entidade) {
        dao.criar(entidade);
    }

    @Override
    public PessoaFisica buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<PessoaFisica> buscarTodos() {
        return dao.buscarTodos();
    }
}
