/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoItemPregao;
import java.util.List;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorItemPregao extends ControladorAbstrato<ItemPregao> {

    private ItemPregao entidade = new ItemPregao();
    private List<ItemPregao> itensPregao;
    private ServicoIF<ItemPregao> servico = new ServicoItemPregao();
    
    public ControladorItemPregao() {
        itensPregao = servico.buscarTodos();
    }

    @Override
    public String criar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().criar(entidade);
        entidade = new ItemPregao();
        JsfUtil.addSuccessMessage("Salvo com Sucesso!");
        itensPregao = servico.buscarTodos();
        return "item";
    }

    @Override
    public String editar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        entidade = new ItemPregao();
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        itensPregao = servico.buscarTodos();
        return "item";
    }

    @Override
    public String deletar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        entidade = new ItemPregao();
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        itensPregao = servico.buscarTodos();
        return "item";
    }

    public String limparDados() {
        entidade = new ItemPregao();
        return "itemSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "pregaoEditar";
    }

    @Override
    public ServicoIF getServico() {
        return this.servico;
    }

    @Override
    public ItemPregao getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(ItemPregao entidade) {
        this.entidade = entidade;
    }

    public boolean getEditando() {
        return this.entidade.getId() != null;
    }

    public List<ItemPregao> getItensPregao() {
        return itensPregao;
    }

    public void setItensPregao(List<ItemPregao> itens) {
        this.itensPregao = itens;
    }

    public void setServico(ServicoIF<ItemPregao> servico) {
        this.servico = servico;
    }

}
