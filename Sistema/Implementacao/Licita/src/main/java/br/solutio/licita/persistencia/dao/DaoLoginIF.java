/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.persistencia.dao;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.persistencia.dao.local.DaoLocalIF;

/**
 *
 * @author WitaloCarlos
 */
public interface DaoLoginIF extends DaoLocalIF{
    public Identificavel verificarDados(String login, String senha);
}
