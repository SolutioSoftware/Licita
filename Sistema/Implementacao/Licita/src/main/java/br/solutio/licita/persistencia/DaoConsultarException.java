/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia;

/**
 *
 * @author WitaloCarlos
 */
public class DaoConsultarException extends RuntimeException {

    
    /**
     * Constructs an instance of <code>DaoConsultarException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DaoConsultarException(String msg) {
        super(msg);
    }
}
