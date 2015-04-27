/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;


import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;
import br.solutio.licita.persistencia.dao.remoto.FabricaDaoRemoto;

/**
 *
 * @author WitaloCarlos
 */
public abstract class FabricaDAO implements FabricaDaoIF{
    
    
    public static FabricaDAO getFabricaDAO(TipoDAO tipo){
        
        switch(tipo){
            case Local:
                return new FabricaDaoLocal();
            case Remoto:
                return new FabricaDaoRemoto();
            default:
                return null;
                
        }
        
    }
    
    @Override
    public abstract DaoIF<Pregoeiro> getDaoPregoeiro();
    
    @Override
    public abstract DaoIF<InstituicaoLicitadora> getDaoInstituicaoLicitadora();
    
    @Override
    public abstract DaoIF<Login> getDaoLogin();
    
    @Override
    public abstract DaoIF<EmpresaLicitante> getDaoEmpresaLicitante();
    
    @Override
    public abstract DaoIF<ItemPregao> getDaoItemPregao();
    
    
    
    
    
    
   
}
