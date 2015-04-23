/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;


import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.servico.ServicoIF;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author WitaloCarlos
 */
@ManagedBean
public class EquipeBean extends ControladorAbstrato{

    PessoaFisica entidade;
    
    
    @Override
    public PessoaFisica getEntidade() {
        return this.entidade;
    }

    @Override
    public void setEntidade(Identificavel entidade) {
        this.entidade = (PessoaFisica) entidade;
        
    }

    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}