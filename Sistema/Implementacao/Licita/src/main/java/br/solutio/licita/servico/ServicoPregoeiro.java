/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.controlador.ControladorPregao;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.DaoIF;
import br.solutio.licita.persistencia.FabricaDAO;
import br.solutio.licita.persistencia.FabricaDaoIF;
import br.solutio.licita.servico.util.Criptografar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoPregoeiro extends ServicoAbstrato<Pregoeiro> implements ServicoPregoeiroIF {

    
    private DaoIF<Pregoeiro> dao;
    private FabricaDaoIF fabricaDao;

    public ServicoPregoeiro(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public void criar(Pregoeiro entidade) {
        Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "passou no servico", "");
        criptografandoSenha(entidade);
        GerenciadorTransacao.abrirTransacao(getEntityManager());
        getDao().criar(entidade);
        GerenciadorTransacao.executarTransacao(getEntityManager());
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

    @Override
    public void setDao(DaoIF<Pregoeiro> dao) {
        this.dao = dao;
    }


    @Override
    public List<Pregoeiro> buscarTodos() {
        getDao().setEntityManager(ProdutorEntityManager.getInstancia().getEmLocal());
        return getDao().consultar("Pregoeiro.findAll");
    }

    @Override
    public DaoIF<Pregoeiro> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoPregoeiro();
        }
        return dao; 
    }
}
