/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.InstituicaoLicitadora;
import br.solutio.licita.servico.ServicoIF;
import javax.faces.bean.ManagedBean;

/**
 * @author ricardocaldeira
 */
@ManagedBean
public class ControladorLicitador extends ControladorAbstrato<InstituicaoLicitadora> {
    
    

    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstituicaoLicitadora getEntidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntidade(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String criar(InstituicaoLicitadora entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
