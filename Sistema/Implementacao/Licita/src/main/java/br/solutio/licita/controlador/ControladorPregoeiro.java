/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Pregoeiro;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.ServicoPregoeiro;
import br.solutio.licita.servico.ServicoPregoeiroIF;
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
public class ControladorPregoeiro extends ControladorAbstrato<Pregoeiro> implements ControladorAbstratoIF<Pregoeiro> {

    private Pregoeiro entidade;
    private transient List<Pregoeiro> pregoeiros;
    private final transient ServicoPregoeiroIF servico;

    public ControladorPregoeiro() {
        entidade = new Pregoeiro();
        servico = new ServicoPregoeiro(ProdutorEntityManager.getInstancia().getEmLocal());
    }

    @Override
    public String criar(Pregoeiro entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(new Pregoeiro());
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
            return "equipeSalvarPregoeiro?faces-redirect=true";
        }

    }

    @Override
    public String editar(Pregoeiro entidade) {

        try {
            entidade = getEntidade();
            getServico().editar(entidade);
            setEntidade(new Pregoeiro());
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
            return "equipeEditarPregoeiro?faces-redirect=true";
        }

    }

    @Override
    public String deletar(Pregoeiro entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Pregoeiro());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        //Imprimir Message apos o redirect
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "equipe?faces-redirect=true";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new Pregoeiro());
        //Imprimir Message apos o redirect
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "equipeSalvarPregoeiro?faces-redirect=true";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        //Imprimir Message apos o redirect
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "equipeEditarPregoeiro";
    }

    @Override
    public Pregoeiro getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Pregoeiro entidade) {
        this.entidade = entidade;
    }

    public List<Pregoeiro> getPregoeiros() {
        return pregoeiros = servico.buscarTodos();
    }

    @Override
    public ServicoPregoeiroIF getServico() {
        return servico;
    }

}
