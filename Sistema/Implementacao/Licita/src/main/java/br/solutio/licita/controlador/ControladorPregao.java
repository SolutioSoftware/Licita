/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Pregao;
import br.solutio.licita.servico.ServicoIF;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ricardocaldeira
 */
@ManagedBean
public class ControladorPregao extends ControladorAbstrato<Pregao>{
    
    private Pregao pregao = new Pregao();
    private List<Pregao> pregoes;

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
