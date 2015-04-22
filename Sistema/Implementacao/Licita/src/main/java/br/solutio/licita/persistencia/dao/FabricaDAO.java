/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;


import br.solutio.licita.persistencia.dao.local.FabricaDaoLocal;
import br.solutio.licita.persistencia.dao.remoto.FabricaDaoRemoto;

/**
 *
 * @author WitaloCarlos
 */
public abstract class FabricaDAO {
    
    
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
    
    
   
}
