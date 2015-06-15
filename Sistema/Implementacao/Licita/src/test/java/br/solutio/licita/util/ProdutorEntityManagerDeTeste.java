/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author WitaloCarlos
 */
public class ProdutorEntityManagerDeTeste {
    
    private static EntityManagerFactory emf = null;
    
    
    public static EntityManagerFactory getEntityManagerFactory(){
        
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("Licita_PU_Teste");
        }
        
        return emf;
              
        
    }
    
    
    
}
