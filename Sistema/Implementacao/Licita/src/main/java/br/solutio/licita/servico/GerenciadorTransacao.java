/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Matheus Oliveira
 */
public class GerenciadorTransacao {

    private GerenciadorTransacao(){
    }
    
    public static void abrirTransacao(EntityManager entity) {
        EntityTransaction et = entity.getTransaction();
        et.begin();
    }

    public static void encerrarTransacao(EntityManager entity) {
        entity.flush();
        entity.getTransaction().commit();
        entity.close();
    }

    public static void rollbackTransacao(EntityManager entity) {
        entity.getTransaction().rollback();
        entity.close();
    }

}
