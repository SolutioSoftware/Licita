/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.solutio.licita.servico;

import br.solutio.licita.modelo.Login;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.modelo.Pregoeiro;

/**
 *
 * @author Matheus Oliveira
 */
public interface ServicoEquipeIF extends ServicoIF<PessoaFisica>{
    
    void criarPregoeiro(PessoaFisica pessoaFisica, Pregoeiro pregoeiro, Login login);
    void criarMembroApoio(PessoaFisica pessoaFisica, MembroApoio membroApoio);
    
}
