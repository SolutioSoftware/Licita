/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Item;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.servico.ProdutorEntityManager;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoPregao;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;

/**
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorPregao extends ControladorAbstrato<Pregao> {

    private Pregao entidade;
    private ItemPregao itemPregao;
    private Item item;
    private transient List<Pregao> pregoes;
    private transient Set<ItemPregao> itensPregao;
    private transient ServicoIF<Pregao> servico;

    public ControladorPregao() {
        entidade = new Pregao();
        servico = new ServicoPregao(ProdutorEntityManager.getInstancia().getEmLocal());
        item = new Item();
        itemPregao = new ItemPregao();
        itensPregao = entidade.getItensPregoes();
    }

    @Override
    public String criar(Pregao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Pregao());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "pregao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Pregao ou Processo já existe");
            return "pregaoSalvar";
        }

    }

    @Override
    public String editar(Pregao entidade) {

        try {
            entidade = getEntidade();
            entidade.setItensPregoes(getItensPregao());
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "" + getItensPregao().size());
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.INFO, "" + entidade.getItensPregoes().size());
            getServico().editar(entidade);
            setEntidade(new Pregao());
            JsfUtil.addSuccessMessage("Atualizado com Sucesso!!?");
            return "pregao";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Pregao ou Processo já existe");
            return "pregaoEditar";
        }

    }

    @Override
    public String deletar(Pregao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new Pregao());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "pregao";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new Pregao());
        return "pregaoSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "pregaoEditar";
    }

    public String preparaAdicionaItens() {
        logger.log(Level.INFO, "Adicionar Itens funfando");
        return "pregaoAdicionarItens";
    }

    public void adicionarItem() {
        itemPregao.setPregao(entidade);
        itemPregao.setItem(item);
        itensPregao.add(itemPregao);
        itemPregao = new ItemPregao();
        item = new Item();
    }
    
    public String removerItem(){
        logger.log(Level.INFO, "Excluir Itens funfando");
        itensPregao.remove(itemPregao);
        return "pregaoAdicionarItens";
    }

    @Override
    public ServicoIF getServico() {
        return this.servico;
    }

    @Override
    public Pregao getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(Pregao entidade) {
        this.entidade = entidade;
    }

    public boolean getEditando() {
        return this.entidade.getId() != null;
    }

    public List<Pregao> getPregoes() {
        return pregoes = servico.buscarTodos();
    }

    public void setPregoes(List<Pregao> pregoes) {
        this.pregoes = pregoes;
    }

    public Set<ItemPregao> getItensPregao() {
        return itensPregao;
    }

    public void setItensPregao(Set<ItemPregao> itensPregao) {
        this.itensPregao = itensPregao;
    }

    public ItemPregao getItemPregao() {
        return itemPregao;
    }

    public void setItemPregao(ItemPregao itemPregao) {
        this.itemPregao = itemPregao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
