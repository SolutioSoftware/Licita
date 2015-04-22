/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.remoto;

import br.solutio.licita.persistencia.dao.DaoLoginIF;
import br.solutio.licita.persistencia.dao.local.*;
import br.solutio.licita.modelo.Login;


/**
 *
 * @author WitaloCarlos
 */
public class DaoLogin extends DaoRemoto<Login> implements DaoLoginIF{
    
    public DaoLogin(){
        super(Login.class);
    }
    
}
