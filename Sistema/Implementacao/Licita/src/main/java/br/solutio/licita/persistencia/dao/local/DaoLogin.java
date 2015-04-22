/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.persistencia.dao.DaoLoginIF;
import java.util.List;


/**
 *
 * @author WitaloCarlos
 */
public class DaoLogin extends DaoLocal<Login> implements DaoLoginIF{
    
    public DaoLogin(){
        super(Login.class);
    }

    @Override
    public Identificavel verificarDados(String login, String senha) {
        List<Identificavel> list = getEntityManager().createQuery("FROM Login as l where l.usuario = :login AND l.senha = :senha").getResultList();
        for (Identificavel id : list) {
            return id;
        }
        return null;
    }
}
