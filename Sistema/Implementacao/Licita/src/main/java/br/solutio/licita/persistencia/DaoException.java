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
public class DaoException extends Exception {

    /**
     * Creates a new instance of <code>DaoException</code> without detail
     * message.
     */
    public DaoException() {
    }

    /**
     * Constructs an instance of <code>DaoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public DaoException(String msg) {
        super(msg);
    }
}
