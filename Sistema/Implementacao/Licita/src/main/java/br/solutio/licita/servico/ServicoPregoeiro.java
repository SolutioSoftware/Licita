/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.servico.util.Criptografar;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoPregoeiro extends ServicoAbstrato<Pregoeiro> implements ServicoPregoeiroIF {

    private final static Logger log = Logger.getGlobal();
    private EntityManager entityLocal;
    private EntityManager entityRemoto;
    private DaoIF<Pregoeiro> dao;
    private FabricaDaoIF fabricaDao;

    @Override
    public int contagem() {
        return dao.contagem();
    }

    @Override
    public void criar(Pregoeiro entidade) {
        criptografandoSenha(entidade);
        GerenciadorTransacao.abrirTransacao(getEntityLocal());
        getDao().criar(entidade);
        GerenciadorTransacao.encerrarTransacao(getEntityLocal());
    }


    @Override
    public Pregoeiro buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Pregoeiro> buscarTodos() {
        return dao.buscarTodos();
    }

    /**
     * Criptogrando senha, através da classe Criptografar, para que entao possa
     * ser persistido no banco com o MD-5
     *
     * @param login
     * @param pregoeiro
     */
    private void criptografandoSenha(Pregoeiro entidade) {
        String novaSenha = Criptografar.getInstance().criptografar(entidade.getLogin().getSenha());
        entidade.getLogin().setSenha(novaSenha);
    }

    public void setDao(DaoIF<Pregoeiro> dao) {
        this.dao = dao;
    }

    @Override
    public DaoIF<Pregoeiro> getDao() {
         if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityLocal());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoPregoeiro();
        }
        return dao;
    }

    private EntityManager getEntityLocal() {
        if (entityLocal == null) {
            entityLocal = ProdutorEntityManager.getInstancia().getEmLocal();
        }
        return entityLocal;
    }
}
