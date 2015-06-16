/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.controlador.ControladorPregao;
import br.solutio.licita.modelo.Login;
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
public class ServicoLogin extends ServicoAbstrato<Login> implements ServicoLoginIF {

    private FabricaDaoIF fabricaDao;
    private DaoIF<Login> dao;

    public ServicoLogin(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean verificarDados(String usuario, String senha) {
        if (usuario != null && senha != null) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "{0}{1}", new Object[]{usuario, senha});
            String senhaCript;
            senhaCript = Criptografar.getInstance().criptografar(senha);
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "{0}{1}", new Object[]{usuario, senhaCript});
            String[] parametros = {"usuario", "senha"};
            Object[] valores = {usuario, senhaCript};
            List<Login> list = getDao().consultar("Login.buscaPorLogin", parametros, valores);
            return !list.isEmpty();
        } else {
            return false;
        }
    }

    @Override
    public void setDao(DaoIF<Login> dao) {
        this.dao = dao;
    }

    @Override
    public List<Login> buscarTodos() {
        return this.dao.consultar("Login.findAll");
    }

    @Override
    public DaoIF<Login> getDao() {
        if (fabricaDao == null) {
            fabricaDao = new FabricaDAO(getEntityManager());
        }
        if (dao == null) {
            dao = fabricaDao.getDaoLogin();
        }
        return dao;
    }

}
