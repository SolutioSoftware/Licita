/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.persistencia.dao.DaoIF;
import br.solutio.licita.persistencia.dao.FabricaDAO;
import br.solutio.licita.persistencia.dao.TipoDAO;
import br.solutio.licita.servico.util.Criptografar;
import java.util.List;

/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLogin extends ServicoAbstrato<Login> implements ServicoLoginIF {

    private final DaoIF<Login> dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoLogin();

    @Override
    public void criar(Login login) {
        try {
            String senhaCript = Criptografar.getInstance().criptografar(login.getSenha());
            login.setSenha(senhaCript);
            getDao().criar(login);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
        }
    }

    /**
     *
     * @param usuario
     * @param senha
     * @return
     */
    @Override
    public boolean verificarDados(String usuario, String senha) {
        String senhaCript;
        senhaCript = Criptografar.getInstance().criptografar(senha);
        String[] parametros = {"usuario", "senha"};
        Object[] valores = {usuario, senhaCript};
        List<Login> list = getDao().consultar("Login.buscaPorLogin", parametros, valores);
        return list.size() >= 1;
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }

}
