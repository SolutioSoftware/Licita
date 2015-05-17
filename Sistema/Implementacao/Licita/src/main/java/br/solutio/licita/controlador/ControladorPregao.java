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
import javax.faces.bean.ManagedBean;

/**
 * @author ricardocaldeira
 */
@ManagedBean
public class ControladorPregao extends ControladorAbstrato<Pregao> {

    private Pregao pregao = new Pregao();
    private List<Pregao> pregoes;
    private ServicoIF<Pregao> servico = new ServicoPregao();

    public ControladorPregao() {
        pregoes = servico.buscarTodos();
    }

    public boolean getEditando() {
        return this.pregao.getId() != null;
    }

    public Pregao getPregao() {
        return pregao;
    }

    public void setPregao(Pregao pregao) {
        this.pregao = pregao;
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

    @Override
    public String criar(Pregao pregao) {
        pregao = getPregao();
        this.servico.criar(pregao);
        pregao = null;
        JsfUtil.addSuccessMessage("Salvo com Sucesso!");
        pregoes = servico.buscarTodos();
        return "pregao";
    }
    
    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pregao getEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntidade(Pregao entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
