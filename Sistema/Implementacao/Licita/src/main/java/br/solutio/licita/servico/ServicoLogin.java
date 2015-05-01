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
import java.util.List;


/**
 *
 * @author Matheus Oliveira
 */
public class ServicoLogin extends ServicoAbstrato<Login> implements ServicoLoginIF{

    
    private final DaoIF<Login> dao = FabricaDAO.getFabricaDAO(TipoDAO.Local).getDaoLogin();

    /**
     *
     * @param usuario
     * @param senha
     * @return
     */
    @Override
    public boolean verificarDados(String usuario, String senha) {
        //TODO resolver este método neste nível
        // dao.verificarDados(login, senha);
        
        String[] parametros = {"usuario", "senha"};
        Object[] valores = {usuario, senha};
        
        List<Login>  list = getDao().consultar("Login.buscaPorLogin", parametros, valores);
       
        return list.size() >= 1;
        
        
        
    }

    @Override
    public DaoIF getDao() {
        return dao;
    }
    
}
