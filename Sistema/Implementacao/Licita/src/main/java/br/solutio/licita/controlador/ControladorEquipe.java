/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.PessoaFisica;
import br.solutio.licita.servico.ServicoIF;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author WitaloCarlos
 */
@ManagedBean
public class ControladorEquipe extends ControladorAbstrato<PessoaFisica> {

    PessoaFisica entidade;
    private List<PessoaFisica> pessoasfisica = new ArrayList<>();
    private boolean cargoPregoeiro = false;
    private boolean cargoMembrodeApoio = false;
    private String valor;
    
    public void tipoPessoaFisica(){
        
        if("Pregoeiro".equals(valor)){
            setCargoPregoeiro(true);
            setCargoMembrodeApoio(false);
        }else{
            setCargoPregoeiro(false);
            setCargoMembrodeApoio(true);
        }
            
    }

    public boolean isCargoPregoeiro() {
        return cargoPregoeiro;
    }

    public void setCargoPregoeiro(boolean cargoPregoeiro) {
        this.cargoPregoeiro = cargoPregoeiro;
    }

    public boolean isCargoMembrodeApoio() {
        return cargoMembrodeApoio;
    }

    public void setCargoMembrodeApoio(boolean cargoMembrodeApoio) {
        this.cargoMembrodeApoio = cargoMembrodeApoio;
    }

    public List<PessoaFisica> getPessoasfisica() {
        return pessoasfisica;
    }

    public void setPessoasfisica(List<PessoaFisica> pessoasfisica) {
        this.pessoasfisica = pessoasfisica;
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
