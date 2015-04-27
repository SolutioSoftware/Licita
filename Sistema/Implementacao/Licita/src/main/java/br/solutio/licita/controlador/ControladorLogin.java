/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.solutio.licita.controlador;

import br.solutio.licita.modelo.Identificavel;
import br.solutio.licita.modelo.Login;
import br.solutio.licita.servico.ServicoIF;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Matheus Oliveira
 */
@ManagedBean(name = "Login")
public class ControladorLogin extends ControladorAbstrato {

    private static final Logger logger = Logger.getGlobal();
    private Login login;

    public ControladorLogin() {
        login = new Login();
    }

    @Override
    public Login getEntidade() {
        return this.login;
    }

    @Override
    public void setEntidade(Identificavel entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServicoIF getServico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String validarLogin() {
        return "/index.xhtml";
    }

}
