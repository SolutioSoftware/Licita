/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Sessao;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoSessao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.PersistenceException;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@RequestScoped
public class ControladorSessao extends ControladorAbstrato<Sessao> {

    private Sessao entidade;
    private transient List<Sessao> sessoes;
    private final transient ServicoIF<Sessao> servico;

    public ControladorSessao() {
        entidade = new Sessao();
        servico = new ServicoSessao();
        sessoes = servico.buscarTodos();
    }

    @Override
    public String criar(Sessao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Sessao());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            sessoes = servico.buscarTodos();
            return "sessao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorSessao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Sessão já existe");
            return "sessaoSalvar";
        }

    }

    @Override
    public String editar(Sessao entidade) {
        
        entidade = getEntidade();
        getServico().editar(entidade);
        setEntidade(new Sessao());
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        sessoes = servico.buscarTodos();
        return "sessao";
    }

    @Override
    public String deletar(Sessao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Sessao());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        sessoes = servico.buscarTodos();
        return "sessao";
    }
    
    public String limparDados() {
        setEntidade(null);
        setEntidade(new Sessao());
        return "sessaoSalvar";
    }
    
    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "sessaoEditar";
    }

    @Override
    public Sessao getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Sessao entidade) {
        this.entidade = entidade;
    }

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }

    @Override
    public ServicoIF<Sessao> getServico() {
        return servico;
    }

}
