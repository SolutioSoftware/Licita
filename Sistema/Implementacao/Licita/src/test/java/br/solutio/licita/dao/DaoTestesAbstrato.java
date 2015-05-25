/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoTestesAbstrato {
    
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("Licita_PU_Teste");
    
}
