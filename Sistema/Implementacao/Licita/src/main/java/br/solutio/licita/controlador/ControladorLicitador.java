/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoInstituicaoLicitadora;
import br.solutio.licita.servico.ServicoInstituicaoLicitadoraIF;
import java.util.List;
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
public class ControladorLicitador extends ControladorAbstrato<InstituicaoLicitadora> implements ControladorAbstratoIF<InstituicaoLicitadora> {

    private InstituicaoLicitadora entidade;
    private transient List<InstituicaoLicitadora> instituicoes;
    private final transient ServicoInstituicaoLicitadoraIF servico;

    public ControladorLicitador() {
        entidade = new InstituicaoLicitadora();
        servico = new ServicoInstituicaoLicitadora();
    }

    @Override
    public String criar(InstituicaoLicitadora entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new InstituicaoLicitadora());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "licitador";
        } catch (PersistenceException e) {
            Logger.getLogger(ControladorLicitante.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Servidor fora do ar");
            return "licitadorSalvar";
        } catch (IllegalStateException e) {
            Logger.getLogger(ControladorLicitante.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("CNPJ já cadastrado");
            Logger.getLogger(e.getMessage());
            return "licitadorSalvar";
        }

    }

    @Override
    public String editar(InstituicaoLicitadora entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        setEntidade(new InstituicaoLicitadora());
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        return "licitador";
    }

    @Override
    public String deletar(InstituicaoLicitadora entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new InstituicaoLicitadora());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "licitador";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new InstituicaoLicitadora());
        return "licitadorSalvar";
    }

    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "licitadorEditar";
    }

    @Override
    public InstituicaoLicitadora getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(InstituicaoLicitadora entidade) {
        this.entidade = entidade;
    }

    public List<InstituicaoLicitadora> getInstituicoes() {
        return instituicoes = servico.buscarTodos();
    }

    public void setInstituicoes(List<InstituicaoLicitadora> instituicoes) {
        this.instituicoes = instituicoes;
    }

    @Override
    public ServicoIF<InstituicaoLicitadora> getServico() {
        return servico;
    }

}
