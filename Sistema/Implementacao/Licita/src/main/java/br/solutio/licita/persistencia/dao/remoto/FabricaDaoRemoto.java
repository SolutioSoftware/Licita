/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao.remoto;

import br.solutio.licita.persistencia.dao.FabricaDAO;

/**
 *
 * @author WitaloCarlos
 */
public class FabricaDaoRemoto extends FabricaDAO implements FabricaDaoRemotoIF {

    public FabricaDaoRemoto() {
    }
    
    @Override
    public DaoRemotoIF getDaoPregoeiro(){
        return new DaoPregoeiro();
    }
    
    @Override
    public DaoRemotoIF getDaoInstituicaoLicitadora(){
        return new DaoInstituicaoLicitadora();
    }
    
    @Override
    public DaoRemotoIF getDaoLogin(){
        return new DaoLogin();
    }
    
}
