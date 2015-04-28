/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.servico;

import br.solutio.licita.servico.Transacional;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author WitaloCarlos
 */
@Priority(Interceptor.Priority.APPLICATION)
@Interceptor
@Transacional
public class InterceptadorTransacoes implements Serializable{
    
    private static final Logger logger = Logger.getGlobal();
    private EntityManager entityManager;
    
     @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        boolean owner = false;

        try {
            if (!transaction.isActive()) {
				// truque para fazer rollback no que já passou
                // (senão, um futuro commit, confirmaria até mesmo operações sem
                // transação)
                transaction.begin();
                logger.info("Transação Iniciada");
                transaction.rollback();
                logger.info("Rollback intencional");

                transaction.begin();
                logger.info("Transação Reiniciada");

                owner = true;
            }

            return context.proceed();
        } catch (Exception e) {
            if (transaction != null && owner) {
                logger.info("catch Rollback ");
                transaction.rollback();

            }

            throw e;
        } finally {
            if (transaction != null && transaction.isActive() && owner) {
                transaction.commit();
                logger.info("Operação Comitada");
            }
        }
    }
    
    
    
}
