/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.controlador.util.JsfUtil;
import br.solutio.licita.modelo.EmpresaLicitante;
import br.solutio.licita.servico.ServicoIF;
import br.solutio.licita.servico.ServicoLicitante;
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
public class ControladorLicitante extends ControladorAbstrato<EmpresaLicitante> {

    private EmpresaLicitante entidade;
    private transient List<EmpresaLicitante> empresas;
    private transient ServicoIF<EmpresaLicitante> servico;

    public ControladorLicitante() {
        entidade = new EmpresaLicitante();
        servico = new ServicoLicitante();
        empresas = servico.buscarTodos();
    }

    @Override
    public String criar(EmpresaLicitante entidade) {
        try {
            entidade = getEntidade();
            getServico().criar(entidade);
            setEntidade(null);
            setEntidade(new EmpresaLicitante());
            JsfUtil.addSuccessMessage("Salvo com Sucesso!");
            empresas = servico.buscarTodos();
            return "licitante";
        } catch (PersistenceException e) {
            Logger.getLogger(ControladorLicitante.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Servido fora do ar");
            return "licitanteSalvar";
        } catch(IllegalStateException e){
            Logger.getLogger(ControladorLicitante.class.getName()).log(Level.SEVERE, null, e);
            JsfUtil.addErrorMessage("Empresa já existe");
            return "licitanteSalvar";
        }

    }

    @Override
    public String editar(EmpresaLicitante entidade) {
        entidade = getEntidade();
        getServico().editar(entidade);
        setEntidade(new EmpresaLicitante());
        JsfUtil.addSuccessMessage("Atualizado com Sucesso!");
        empresas = servico.buscarTodos();
        return "licitante";
    }

    @Override
    public String deletar(EmpresaLicitante entidade) {
        entidade = getEntidade();
        getServico().deletar(entidade);
        setEntidade(new EmpresaLicitante());
        JsfUtil.addSuccessMessage("Excluido com Sucesso!");
        empresas = servico.buscarTodos();
        return "licitante";
    }

    public String limparDados() {
        setEntidade(null);
        setEntidade(new EmpresaLicitante());
        return "licitanteSalvar";
    }
    
    public String preparaEditar() {
        logger.log(Level.INFO, "Editar funfando");
        return "licitanteEditar";
    }

    public List<EmpresaLicitante> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaLicitante> empresas) {
        this.empresas = empresas;
    }

    @Override
    public ServicoIF<EmpresaLicitante> getServico() {
        return servico;
    }

    @Override
    public EmpresaLicitante getEntidade() {
        return entidade;
    }

    @Override
    public void setEntidade(EmpresaLicitante entidade) {
        this.entidade = entidade;
    }

}
