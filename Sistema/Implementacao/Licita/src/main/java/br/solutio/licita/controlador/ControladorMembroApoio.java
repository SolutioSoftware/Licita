/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.MembroApoio;
import br.solutio.licita.servico.ServicoMembroApoio;
import br.solutio.licita.servico.ServicoMembroApoioIF;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@RequestScoped
public class ControladorMembroApoio extends ControladorAbstrato<MembroApoio> implements ControladorAbstratoIF<MembroApoio> {

    private MembroApoio entidade;
    private transient List<MembroApoio> membros;
    private final transient ServicoMembroApoioIF servico;

    public ControladorMembroApoio() {
        entidade = new MembroApoio();
        servico = new ServicoMembroApoio();
    }

    @Override
    public String criar(MembroApoio entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(new MembroApoio());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            //Imprimir Message apos o redirect
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            return "equipe?faces-redirect=true";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            //Imprimir Message apos o redirect
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            return "equipeSalvarMembroApoio?faces-redirect=true";
        }

    }

    @Override
    public String editar(MembroApoio entidade) {

        try {
            getServico().editar(this.entidade);
            setEntidade(new MembroApoio());
            JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
            //Imprimir Message apos o redirect
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            return "equipe?faces-redirect=true";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            //Imprimir Message apos o redirect
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);
            return "equipeEditarMembroApoio?faces-redirect=true";
        }

    }

    @Override
    public String deletar(MembroApoio entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new MembroApoio());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        //Imprimir Message apos o redirect
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "equipe?faces-redirect=true";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new MembroApoio());
        //Imprimir Message apos o redirect
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "equipeSalvarMembroApoio?faces-redirect=true";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "equipeEditarMembroApoio";
    }

    @Override
    public MembroApoio getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(MembroApoio entidade) {
        this.entidade = entidade;
    }

    public List<MembroApoio> getMembros() {
        return membros = servico.buscarTodos();
    }

    @Override
    public ServicoMembroApoioIF getServico() {
        return servico;
    }

}
