/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.dao;

import br.solutio.licita.util.ProdutorEntityManagerDeTeste;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Matheus Oliveira
 */
public class DaoTestesAbstrato {
    
    public EntityManagerFactory emf = ProdutorEntityManagerDeTeste.getEntityManagerFactory();
    
}
