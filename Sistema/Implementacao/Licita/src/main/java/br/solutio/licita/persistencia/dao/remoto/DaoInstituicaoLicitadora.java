/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.remoto;

import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.persistencia.dao.DaoInstituicaoLicitadoraIF;


/**
 *
 * @author WitaloCarlos
 */
public class DaoInstituicaoLicitadora extends DaoRemoto<InstituicaoLicitadora> implements DaoInstituicaoLicitadoraIF{
    
    public DaoInstituicaoLicitadora(){
        super(InstituicaoLicitadora.class);
    }
    
}
