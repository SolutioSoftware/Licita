/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.ContatoPessoaJuridica;
import br.solutio.licita.modelo.Endereco;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.modelo.PessoaJuridica;
import br.solutio.licita.servico.ServicoIF;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author ricardocaldeira
 */
@ManagedBean(name="Licitador")
@ViewScoped
public class ControladorLicitador extends ControladorAbstrato<InstituicaoLicitadora> implements ControladorAbstratoIF<InstituicaoLicitadora>{
    
    private PessoaJuridica pessoaJuridica;
    private InstituicaoLicitadora instituicaoLicitadora;
    private Endereco endereco;
    private ContatoPessoaJuridica contato;

    public ControladorLicitador() {
        this.endereco = new Endereco();
        this.instituicaoLicitadora = new InstituicaoLicitadora();
        this.pessoaJuridica = new PessoaJuridica();
        this.contato = new ContatoPessoaJuridica();
    }
    
    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public InstituicaoLicitadora getInstituicaoLicitadora() {
        return instituicaoLicitadora;
    }

    public void setInstituicaoLicitadora(InstituicaoLicitadora instituicaoLicitadora) {
        this.instituicaoLicitadora = instituicaoLicitadora;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ContatoPessoaJuridica getContato() {
        return contato;
    }

    public void setContato(ContatoPessoaJuridica contato) {
        this.contato = contato;
    }
    
    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstituicaoLicitadora getEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntidade(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String criar(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editar(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletar(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
