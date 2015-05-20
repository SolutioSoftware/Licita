/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoPregao;
import java.util.List;
import java.util.logging.Level;
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
    private List<Pregao> pregoes;
    private ServicoIF<Pregao> servico = new ServicoPregao();

    public ControladorPregao() {
        entidade = new Pregao();
        pregoes = servico.buscarTodos();
    }

    @Override
    public String criar(Pregao entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new Pregao());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            pregoes = servico.buscarTodos();
            return "pregao";
        }catch(PersistenceException e){
            JsfUtil.addErrorMessage("Pregao ou Processo já existe");
            return "pregaoSalvar";
        }

    }

    @Override
    public String editar(Pregao entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        entidade = new Pregao();
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        pregoes = servico.buscarTodos();
        return "pregao";
    }

    @Override
    public String deletar(Pregao entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        entidade = new Pregao();
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        pregoes = servico.buscarTodos();
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
        return pregoes;
    }

    public void setPregoes(List<Pregao> pregoes) {
        this.pregoes = pregoes;
    }

    public void setServico(ServicoIF<Pregao> servico) {
        this.servico = servico;
    }

}
