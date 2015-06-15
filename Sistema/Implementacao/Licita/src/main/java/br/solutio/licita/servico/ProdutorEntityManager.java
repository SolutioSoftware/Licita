/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matheus Oliveira
 */
public class ProdutorEntityManager {

    private EntityManagerFactory emfRemoto;
    private EntityManagerFactory emfLocal;
    private EntityManager entityManagerLocal;
    private EntityManager entityManagerRemoto;
    private static ProdutorEntityManager instancia;

    private ProdutorEntityManager() {
    }

    public static ProdutorEntityManager getInstancia() {
        if (instancia == null) {
            instancia = new ProdutorEntityManager();
        }
        return instancia;
    }

    public EntityManager getEmLocal() {
        if (emfLocal == null) {
            emfLocal = Persistence.createEntityManagerFactory("Licita_PU_Local");
        }
        
        if (entityManagerLocal == null || !entityManagerLocal.isOpen()) {
            entityManagerLocal = emfLocal.createEntityManager();
        }
        
        
        return entityManagerLocal;
    }

    public EntityManager getEmRemoto() {
        if (emfRemoto == null) {
            emfRemoto = Persistence.createEntityManagerFactory("Licita_PU_Remoto");
        }
        entityManagerRemoto = emfRemoto.createEntityManager();
        return entityManagerRemoto;
    }


}
