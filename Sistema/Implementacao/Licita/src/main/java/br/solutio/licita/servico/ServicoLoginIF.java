/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;

/**
 *
 * @author Matheus Oliveira
 */
public interface ServicoLoginIF extends ServicoIF<Login>{
    
    public boolean verificarDados(String usuario, String senha);
}
