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
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
@SessionScoped
public class ControladorMembroApoio extends ControladorAbstrato<MembroApoio> implements ControladorAbstratoIF<MembroApoio>  {
    
    private MembroApoio entidade;
    private transient List<MembroApoio> membros;
    private final transient ServicoMembroApoioIF servico;
    
    public ControladorMembroApoio(){
        entidade = new MembroApoio();
        servico = new ServicoMembroApoio();
    }
    
    @Override
    public String criar(MembroApoio entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new MembroApoio());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            return "equipe";
        } catch (PersistenceException | IllegalStateException e) {
            Logger.getLogger(ControladorPregao.class.getName()).log(Level.SEVERE, null, e);
            return "equipeSalvarMembroApoio";
        }

    }

    @Override
    public String editar(MembroApoio entidade) {
        
        entidade = getEntidade();
        getServico().editar(entidade);
        setEntidade(new MembroApoio());
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        return "equipe";
    }

    @Override
    public String deletar(MembroApoio entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new MembroApoio());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        return "equipe";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new MembroApoio());
        return "equipeSalvarMembroApoio";
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
