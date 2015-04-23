/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.local;

import br.solutio.licita.persistencia.dao.DaoInstituicaoLicitadoraIF;
import br.solutio.licita.persistencia.dao.DaoLoginIF;
import br.solutio.licita.persistencia.dao.DaoPregoeiroIF;

/**
 *
 * @author WitaloCarlos
 * @param <T>
 */
public interface FabricaDaoLocalIF {

    DaoInstituicaoLicitadoraIF getDaoInstituicaoLicitadora();

    DaoLoginIF getDaoLogin();

    DaoPregoeiroIF getDaoPregoeiro();
    
}
