/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import static br.solutio.licita.controlador.ControladorAbstrato.logger;
import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Item;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoItem;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorItem extends ControladorAbstrato<Item> {

    private Item entidade;
    private transient List<Item> itens;
    private transient ServicoIF<Item> servico;

    public ControladorItem() {
        entidade = new Item();
        servico = new ServicoItem();
        itens = servico.buscarTodos();
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new Item());
        return "itemSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        
        return "itemEditar";
    }

    @Override
    public Item getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Item entidade) {
        this.entidade = entidade;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public ServicoIF<Item> getServico() {
        return servico;
    }

    public void setServico(ServicoIF<Item> servico) {
        this.servico = servico;
    }

    @Override
    public String criar(Item entidade) {

        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Item());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            itens = servico.buscarTodos();
            return "item";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Item já existe");
            return "itemSalvar";
        }
    }

    @Override
    public String editar(Item entidade) {
        
        entidade = getEntidade();
        if (entidade.getId() == null) {
            JsfUtil.addSuccessMessage("Criada!");
            criar(entidade);
        } else {
            getServico().editar(entidade);
            setEntidade(new Item());
            JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
            itens = servico.buscarTodos();
        }
        return "item";
    }

    @Override
    public String deletar(Item entidade) {

        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Item());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        itens = servico.buscarTodos();
        return "item";

    }

}
