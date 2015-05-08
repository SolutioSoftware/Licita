/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.MembroApoioPK;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.modelo.PregoeiroPK;
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
        dao.editar(entidade);
    }

    @Override
    public void deletar(PessoaFisica entidade) {
        dao.deletar(entidade);
    }

    @Override
    public PessoaFisica buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<PessoaFisica> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void criarPregoeiro(PessoaFisica pessoaFisica, Pregoeiro pregoeiro, Login login) {
        dao.criar(pessoaFisica);
        criptografandoSenha(login, pregoeiro);
        inserindoPkPregoeiro(pregoeiro, pessoaFisica);
        dao.editar(pessoaFisica);
    }

    /**
     * Criando PK na entidade Pregoeiro, para que possa ser persistido no banco,
     * realizando o setPregoeirro(pregoeiro), onde o parametro esta com sua PK
     * informada corretamente
     * @param pregoeiro
     * @param pessoaFisica 
     */
    private void inserindoPkPregoeiro(Pregoeiro pregoeiro, PessoaFisica pessoaFisica) {
        pregoeiro.setPregoeiroPK(new PregoeiroPK(pessoaFisica.getId(), pessoaFisica.getId()));
        pessoaFisica.setPregoeiro(pregoeiro);
    }

    /**
     * Criptogrando senha, através da classe Criptografar, para que entao
     * possa ser persistido no banco com o MD-5
     * @param login
     * @param pregoeiro 
     */
    private void criptografandoSenha(Login login, Pregoeiro pregoeiro) {
        String senhaCriptografada = Criptografar.getInstance().criptografar(login.getSenha());
        login.setSenha(senhaCriptografada);
        pregoeiro.setLogin(login);
    }

    @Override
    public void criarMembroApoio(PessoaFisica pessoaFisica, MembroApoio membroApoio) {
        dao.criar(pessoaFisica);
        membroApoio.setMembroApoioPK(new MembroApoioPK(pessoaFisica.getId(), pessoaFisica.getId()));
        pessoaFisica.setMembroApoio(membroApoio);
        dao.editar(pessoaFisica);
    }
}
