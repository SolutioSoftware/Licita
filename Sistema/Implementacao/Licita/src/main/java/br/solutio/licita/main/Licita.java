/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.main;

import br.solutio.licita.servico.ServicoLogin;
import br.solutio.licita.servico.ServicoLoginIF;

/**
 *
 * @author WitaloCarlos
 */
public class Licita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        ServicoLoginIF servico = new ServicoLogin();
        
        servico.verificarDados("Admin", "admin");
        
    }
    
}
