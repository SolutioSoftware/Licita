/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.persistencia.dao.DaoPregoeiroIF;
import br.solutio.licita.modelo.Pregoeiro;


/**
 *
 * @author WitaloCarlos
 */
public class DaoPregoeiro extends DaoLocal<Pregoeiro> implements DaoPregoeiroIF{
    
    public DaoPregoeiro(){
        super(Pregoeiro.class);
    }
    
}
