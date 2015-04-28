/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.servico.ServicoIF;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author WitaloCarlos
 */
@ManagedBean
public class EquipeBean extends ControladorAbstrato<PessoaFisica> {

    PessoaFisica entidade;
    private boolean cargo = true;
    private String valor;
    
    public boolean tipoPessoaFisica(){
        if("Pregoeiro".equals(valor)){
            return this.cargo = true;
        }else{
            return this.cargo = false;
        }
    }

    public boolean isCargo() {
        return cargo;
    }

    public void setCargo(boolean cargo) {
        this.cargo = cargo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public PessoaFisica getEntidade() {
        return this.entidade;
    }

    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntidade(PessoaFisica entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
