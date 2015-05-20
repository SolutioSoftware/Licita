/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.ItemPregao;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoItemPregao;
import br.solutio.licita.servico.ServicoItemPregaoIF;
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

    private ItemPregao entidade;
    private List<ItemPregao> itens;
    private List<Pregao> pregoes;
    private ServicoItemPregaoIF servico;

    public ControladorItemPregao() {
        this.entidade = new ItemPregao();
        this.servico = new ServicoItemPregao();
        itens = servico.buscarTodos();
        pregoes = servico.listarPregoes();
    }

    @Override
    public String criar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().criar(entidade);
        setEntidade(null);
        setEntidade(new ItemPregao());
        JsfUtil.addSuccessMessage("Salvo com Sucesso!");
        itens = servico.buscarTodos();
        pregoes = servico.listarPregoes();
        return "itemSalvar";
    }

    @Override
    public String editar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        entidade = new ItemPregao();
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        itens = servico.buscarTodos();
        pregoes = servico.listarPregoes();
        return "item";
    }

    @Override
    public String deletar(ItemPregao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        entidade = new ItemPregao();
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        itens = servico.buscarTodos();
        pregoes = servico.listarPregoes();
        return "item";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new ItemPregao());
        return "itemSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "itemEditar";
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

    public List<ItemPregao> getItens() {
        return itens;
    }

    public void setItens(List<ItemPregao> pregoes) {
        this.itens = pregoes;
    }

    public List<Pregao> getPregoes() {
        return pregoes;
    }

    public void setPregoes(List<Pregao> pregoes) {
        this.pregoes = pregoes;
    }

    public ServicoItemPregaoIF getServicoItemPregaoIF() {
        return servico;
    }

    public void setServico(ServicoItemPregaoIF servico) {
        this.servico = servico;
    }

   


}
